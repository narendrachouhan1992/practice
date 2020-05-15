package Entities.accounts;

import java.util.List;
import java.util.stream.Collectors;

import Entities.Transaction;
import Exceptions.BankingException;
import Status.Status;

public abstract class BankAccount {
	final String accountnumber;
	final double minimumBalance;
	double currentBalance;
	final double intrestRate;
	List<Transaction> transactions;
	BankAccount(String accountnumber, double minimumBalance, double currentBalance, double intrestRate,
			List<Transaction> transactions) {
		super();
		this.accountnumber = accountnumber;
		this.minimumBalance = minimumBalance;
		this.currentBalance = currentBalance;
		this.intrestRate = intrestRate;
		this.transactions = transactions;
	}
	public List<Transaction> getTransactionHistory()
	{
		return this.transactions.stream().map(s->s.getCopy()).collect(Collectors.toList());
	}
	public List<Transaction> getMiniStatement()
	{
		List<Transaction> miniStmt = transactions.subList(transactions.size()<=10? 0:transactions.size()-10, transactions.size());
		return miniStmt.stream().map(s->s.getCopy()).collect(Collectors.toList());
	}
	public String getAccountnumber() {
		return accountnumber;
	}
	public Double getMinimumBalance() {
		return minimumBalance;
	}
	public double getCurrentBalance() {
		return currentBalance;
	}
	public double getIntrestRate() {
		return intrestRate;
	}

	abstract public Status withdraw(double ammount) throws BankingException;
	abstract public Status deposit(double ammount) throws BankingException;
	abstract public BankAccount getCopy() throws BankingException;
	abstract public String getType();
}
