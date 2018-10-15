package edu.gcu.bootcamp.java.eric.stoll.bankingapplication;

import java.util.Scanner;

public class Saving extends Account {
	
	private double serviceFee = 25.00;
	double annualInterestRate = .03;
	private double minBalance = 500.00;
	static String account = "12345678";
	private double input;
	Scanner sc = new Scanner(System.in);
	
	public double getServiceFee() {
		return serviceFee;
	}
	
	public void setServiceFee(double serviceFee) {
		this.serviceFee = serviceFee;
	}
	
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	
	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	
	public double getMinBalance() {
		return minBalance;
	}
	
	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}
	
	public Saving(double balance) {
		
		this.balance = balance;

	}
	
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		Saving.account = account;
	}

	/**
	 * This method displays and calculates the deposits in savings
	 */
	public void displayDepositSaving(Saving saving) {
				
		System.out.printf("Saving balance: $%.2f\n", saving.getBalance());
		
		System.out.print("How much to Deposit: $");
		input = sc.nextDouble();
		saving.balance += input;
		System.out.printf("New Saving Balance: $%.2f\n", saving.getBalance());
		saving.addToStatement(Saving.account, input, "deposit", "saving");
	}
	/**
	 * This method displays and calculates transactions of the savings
	 */
	public void displayWithdrawSavings(Saving saving) {
		
		System.out.printf("Saving balance: $%.2f\n", saving.getBalance());
		System.out.print("How much to withdraw: $");
		input = sc.nextDouble();
		saving.balance -= input;
		if (saving.balance <= 0) {
			System.out.println("You broke foo");
		}else {
			
		System.out.printf("New Saving Balance: $%.2f\n", saving.getBalance());
		}
		saving.addToStatement(Saving.account, input, "withdraw", "saving");
	}

	void savingEndOfMonth() {
		
		if(this.balance <= this.getMinBalance()) {
			System.out.printf("Saving: $%.2f in acct# %s " +  "You have been assessed" +
				"a $25 min balance fee to savings", (this.balance - this.getServiceFee()), this.getAccount());		
		}else {
			double interest = this.getBalance() * this.getAnnualInterestRate()/12;
			setBalance(interest + getBalance());
			System.out.printf("Saving: $%.2f in acct# %s \n", this.getBalance(), this.getAccount());						 
		}
	
	}


}