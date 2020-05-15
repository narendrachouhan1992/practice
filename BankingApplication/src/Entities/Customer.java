package Entities;

import java.util.List;
import java.util.stream.Collectors;

import Entities.accounts.BankAccount;
import Exceptions.BankingException;
import Status.Status;

public class Customer{
	private List<BankAccount> accounts;
	private String panNumber;
	
	public Customer(List<BankAccount> accounts, String panNumber) {
		super();
		this.accounts = accounts;
		this.panNumber = panNumber;
	}
	public String getPanNumber()
	{
		return panNumber;
	}
	public Status addBankAccount(BankAccount account)
	{
		accounts.add(account);
		System.out.println("bank account with ID:"+account.getAccountnumber()+" added to customer:"+panNumber);
		return Status.SUCCESS;
	}
	@Override
	public String toString() {
		return "Customer [accounts=" + accounts + ", panNumber=" + panNumber + "]";
	}
	Customer getCopy()
	{
		return new Customer(this.accounts.stream().map(s->{
			try {
				return s.getCopy();
			} catch (BankingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}).collect(Collectors.toList()), this.panNumber);
	}
}
