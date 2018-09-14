package edu.gcu.bootcamp.java.eric.stoll.bankingapplication;

public class Account {
	
	double balance;
	private String account;
	
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
		return balance;
		
	}
}
