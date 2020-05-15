package Entities.accounts;

import java.util.ArrayList;
import java.util.stream.Collectors;

import Entities.Transaction;
import Entities.TransactionType;
import Exceptions.BankingException;
import Exceptions.NegativeAmmountException;
import Exceptions.NoSufficientAmmountException;
import Status.Status;
import utils.BankUtils;

public final class CurrentAccount extends BankAccount {
	public CurrentAccount(String accountnumber, double currentBalance) throws BankingException {
		super(accountnumber, 20000, currentBalance, 0, new ArrayList<Transaction>());
		if (currentBalance < 10000)
			throw new NoSufficientAmmountException("Ammount passed to create account is not sufficient. ammount:"
					+ currentBalance + " minimumRequired:20000");
		System.out.println("Bank Current Account created with account Number:" + accountnumber);
	}

	@Override
	public Status withdraw(double ammount) throws BankingException {
		if (ammount < 0)
			throw new NegativeAmmountException("ammount to deposit is not correct:" + ammount);
		if (currentBalance - ammount > minimumBalance) {
			synchronized (this) {
				Transaction t = new Transaction(BankUtils.getInstance().generateUniqueTransactionNum(), ammount,
						TransactionType.withdraw);
				this.transactions.add(t);
				currentBalance -= ammount;
				System.out.println("amount withdrawn:" + ammount + " current Balance:" + this.currentBalance);
				return Status.SUCCESS;

			}
		} else
			throw new NoSufficientAmmountException("sufficient balance is not available, current Balance:"
					+ this.currentBalance + " ,minimum balance required:" + this.minimumBalance);
	}

	@Override
	public String toString() {
		return "CurrentAccount [accountnumber=" + accountnumber + ", minimumBalance=" + minimumBalance
				+ ", currentBalance=" + currentBalance + ", intrestRate=" + intrestRate + ", transactions="
				+ transactions + ", getType()=" + getType() + "]";
	}

	@Override
	public Status deposit(double ammount) throws BankingException {
		if (ammount > 0) {
			synchronized (this) {
				Transaction t = new Transaction(BankUtils.getInstance().generateUniqueTransactionNum(), ammount,
						TransactionType.deposit);
				this.transactions.add(t);
				currentBalance += ammount;
				System.out.println("amount deposited:" + ammount + " current Balance:" + this.currentBalance);
				return Status.SUCCESS;

			}
		} else
			throw new NegativeAmmountException("ammount to deposit is not correct:" + ammount);
	}

	@Override
	public CurrentAccount getCopy() throws BankingException {
		CurrentAccount c = new CurrentAccount(this.accountnumber, this.currentBalance);
		c.transactions = transactions.stream().map(s -> s.getCopy()).collect(Collectors.toList());
		return c;
	}

	@Override
	public String getType() {

		return "Current";
	}
}
