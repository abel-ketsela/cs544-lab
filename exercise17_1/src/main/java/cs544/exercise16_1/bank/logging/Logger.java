package cs544.exercise16_1.bank.logging;

import org.springframework.stereotype.Service;

@Service("logger")
public class Logger implements ILogger{

	public void log(String logstring) {
		java.util.logging.Logger.getLogger("BankLogger").info(logstring);		
	}

}
