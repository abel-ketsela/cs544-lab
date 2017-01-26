package cs544.exercise13_1;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspect {
	
	@After("execution(public void sendEmail(..)) && args(email, message)")
	public void emailLog(JoinPoint joinPoint, String email, String message){
		System.out.println(new Date().toString()+" Method=(sendMail), "
				+ "Email=("+email+"),"
						+ " Message=("+message+")");
		
		IEmailSender emailSender=(EmailSender)joinPoint.getTarget();
		System.out.println( "Outgoing Mail Server=("+emailSender.getOutgoingMailServer() +")");

	}

}
