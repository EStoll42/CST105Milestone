package edu.gcu.bootcamp.java.eric.stoll.bankingapplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Account implements Transaction {
	
	double balance;
	public String account;
	protected static List<String> statement = new ArrayList<String>();

	public static List<String> getStatement() {
		return statement;
	}
	public static void setStatement(List<String> statement) {
		Account.statement = statement;
	}
	public double getBalance() {
		return this.balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	
	public double doWithdraw(double amount) {
		this.balance = this.balance - amount;
		return balance;	
	}
	
	public double doDeposit(double amount) {
		this.balance = this.balance + amount; 
		return this.balance;		
	}
	
	public void Customer(String firstName, String lastName) {
		this.Customer(firstName, lastName);
	}
	/**
	 * Adds to List array
	 */
	public void addToStatement(String account, double amount, String transactionType, String accountType) {
		List<String> myList = getStatement();
		myList.add(LocalDate.now() +"\t"+ account +" \t"+ amount +" \t"+ balance +" \t"+ transactionType +
				" \t" + accountType);
	}
	/**
	 * displays array
	 */
	public static void displayStatement() {
		for(String str: statement) {
			System.out.println(str);
		}
	}
}
