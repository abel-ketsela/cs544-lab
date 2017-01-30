package cs544.exercise16_1.bank.dao;

import java.util.*;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cs544.exercise16_1.bank.domain.Account;

@Repository("accountDAO")
public class AccountDAO implements IAccountDAO {
	//Collection<Account> accountlist = new ArrayList<Account>();
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public  AccountDAO ()
	{
		
	}
	
	
	public void saveAccount(Account account) {
		// System.out.println("AccountDAO: saving account with accountnr ="+account.getAccountnumber());
		//accountlist.add(account); // add the new
		
		sessionFactory.getCurrentSession().persist(account);
	}

	
	public void updateAccount(Account account) {
		// System.out.println("AccountDAO: update account with accountnr ="+account.getAccountnumber());
		//Account accountexist = loadAccount(account.getAccountnumber());
		//if (accountexist != null) {
		//	accountlist.remove(accountexist); // remove the old
		//	accountlist.add(account); // add the new
		//}
		sessionFactory.getCurrentSession().persist(account);

	}

	public Account loadAccount(long accountnumber) {
		// System.out.println("AccountDAO: loading account with accountnr ="+accountnumber);
		//for (Account account : accountlist) {
		//	if (account.getAccountnumber() == accountnumber) {
		//		return account;
		//	}
		//}
		//return null;
		
		Account account=(Account)sessionFactory.getCurrentSession().get(Account.class, accountnumber);
		return account;
	
	}
	@SuppressWarnings("unchecked")
	public Collection<Account> getAccounts() {
		
		return (List<Account>)sessionFactory.getCurrentSession().createQuery("select distinct a from Account a join fetch  a.entryList").list();
	}

}
