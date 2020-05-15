package Entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Entities.accounts.BankAccount;
import Entities.accounts.CurrentAccount;
import Entities.accounts.SavingAccount;
import Exceptions.BankingException;
import Exceptions.InvalidAccountTypeException;
import Exceptions.NoBankAccountExistException;
import Status.Status;
import utils.BankUtils;

public class Branch {
	private Map<String,Customer> customers;
	private Map<String, BankAccount> accounts;
	private String branchID;
	@Override
	public String toString() {
		return "Branch [customers=" + customers + ", accounts=" + accounts + ", branchID=" + branchID + "]";
	}
	public Customer getCustomerByPanNumber(String pan) throws NoBankAccountExistException{
		if(!customers.containsKey(pan))
			throw new NoBankAccountExistException("Customer does not exist with PAN:"+pan);
		return customers.get(pan);
	}
	public BankAccount getAccountByAccountNumber(String an) throws BankingException {
		if(!accounts.containsKey(an))
			throw new NoBankAccountExistException("bankAccount does not exist with id:"+an);
		return accounts.get(an);
	}
	public String getBranchID() {
		return branchID;
	}
	public Status createBankAccount(String pan, String type, double ammount) throws BankingException
	{
		String accountID;
		if("Saving".equals(type))
		{
			accountID = BankUtils.getInstance().generateUniqueAccountNum();
			if(customers.containsKey(pan))
			{
				BankAccount acc = new SavingAccount(accountID, ammount);
				customers.get(pan).addBankAccount(acc);
				accounts.put(acc.getAccountnumber(), acc);
			}
			else
			{
				List<BankAccount> bal = new ArrayList<BankAccount>();
				BankAccount acc = new SavingAccount(accountID, ammount);
				bal.add(acc);
				Customer c = new Customer(bal, pan);
				accounts.put(acc.getAccountnumber(), acc);
				customers.put(pan, c);
				System.out.println("customer created with PAN number :"+pan);
			}
		}
		else if ("Current".equals(type))
		{
			accountID = BankUtils.getInstance().generateUniqueAccountNum();
			if(customers.containsKey(pan))
			{
				
				BankAccount acc = new CurrentAccount(accountID, ammount);
				customers.get(pan).addBankAccount(acc);
				accounts.put(acc.getAccountnumber(), acc);
			}
			else
			{
				List<BankAccount> bal = new ArrayList<BankAccount>();
				BankAccount acc = new CurrentAccount(accountID, ammount);
				bal.add(acc);
				Customer c = new Customer(bal, pan);
				accounts.put(acc.getAccountnumber(), acc);
				customers.put(pan, c);
				System.out.println("customer created with PAN number :"+pan);
			}
		}
		else
		{
			throw new InvalidAccountTypeException("Account type passed is not valid :"+type);
		}
		System.out.println("bank account created with accountID:"+accountID);
		return Status.SUCCESS;
	}
	
	public Branch(String branchID) {
		super();
		this.customers = new HashMap<String ,Customer>();
		this.accounts = new HashMap<String ,BankAccount>();
		this.branchID = branchID;
	}
	Branch getCopy() throws BankingException
	{
		Branch b = new Branch(branchID);
		Map<String, Customer> custMap = new HashMap<String, Customer>();
		for (Customer customer : this.customers.values()) {
			custMap.put(customer.getPanNumber(), customer.getCopy());
		}
		
		Map<String, BankAccount> accMap = new HashMap<String, BankAccount>();
		for (BankAccount acc : this.accounts.values()) {
			accMap.put(acc.getAccountnumber(), acc.getCopy());
		}
		b.accounts = accMap;
		b.customers = custMap;
		return b;
	}
}
