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

final public class SavingAccount extends BankAccount {

	public SavingAccount(String accountnumber, double currentBalance) throws BankingException {
		super(accountnumber, 10000, currentBalance, 4.5, new ArrayList<Transaction>());
		if (currentBalance < 10000)
			throw new NoSufficientAmmountException("Ammount passed to create account is not sufficient. ammount:"
					+ currentBalance + " minimumRequired:10000");
		System.out.println("Bank Saving Account created with account Number:"+accountnumber);
	}

	public Status withdraw(double ammount) throws BankingException {
		if (ammount < 0)
			throw new NegativeAmmountException("ammount to deposit is not correct:" + ammount);
		if (currentBalance - ammount > minimumBalance) {
			synchronized (this) {
				Transaction t = new Transaction(BankUtils.getInstance().generateUniqueTransactionNum(), ammount,
						TransactionType.withdraw);
				this.transactions.add(t);
				currentBalance -= ammount;
				System.out.println("amount withdrawn:"+ammount+" current Balance:"+this.currentBalance);
				return Status.SUCCESS;

			}
		} else
			throw new NoSufficientAmmountException("sufficient balance is not available, current Balance:"
					+ this.currentBalance + " ,minimum balance required:" + this.minimumBalance);
	}

	public Status deposit(double ammount) throws BankingException {
		if (ammount > 0) {
			synchronized (this) {
				Transaction t = new Transaction(BankUtils.getInstance().generateUniqueTransactionNum(), ammount,
						TransactionType.deposit);
				this.transactions.add(t);
				currentBalance += ammount;
				System.out.println("amount deposited:"+ammount+" current Balance:"+this.currentBalance);
				return Status.SUCCESS;
			}
		} else
			throw new NegativeAmmountException("ammount to deposit is not correct:" + ammount);
	}

	@Override
	public String toString() {
		return "SavingAccount [accountnumber=" + accountnumber + ", minimumBalance=" + minimumBalance
				+ ", currentBalance=" + currentBalance + ", intrestRate=" + intrestRate + ", transactions="
				+ transactions + ", getType()=" + getType() + "]";
	}

	@Override
	public SavingAccount getCopy() throws BankingException {
		SavingAccount c = new SavingAccount(this.accountnumber, this.currentBalance);
		c.transactions = transactions.stream().map(s -> s.getCopy()).collect(Collectors.toList());
		return c;
	}

	@Override
	public String getType() {
		return "Saving";
	}
}
