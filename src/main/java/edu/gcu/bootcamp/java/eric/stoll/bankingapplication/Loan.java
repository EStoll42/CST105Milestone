package edu.gcu.bootcamp.java.eric.stoll.bankingapplication;

import java.util.Scanner;

public class Loan extends Account{

	private double interestRate = .09;
	private double lateFee = 25.00;
	static String account = "9876543";
	private double input;
	Scanner sc = new Scanner(System.in);
	
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		Loan.account = account;
	}

	public double getInterestRate() {
		return interestRate;
	}
	
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	public double getLateFee() {
		return lateFee;
	}
	
	public void setLateFee(double lateFee) {
		this.lateFee = lateFee;
	}

	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this. balance = balance;
	}	
	/**
	 * displays loan transaction
	 * @param loan
	 */
	public void displayLoanPayment(Loan loan) {
		
		System.out.println("Loan balance: $" + this.getBalance() + " in loan acct# " + account);
		System.out.print("How much to pay towards loan: $");
		this.input = sc.nextDouble();		
		this.balance -= this.input;
		
		if (this.balance == 0) {
			System.out.println("Your loan has been paid off");
		}else {			
		System.out.printf("New Loan Balance: $%.2f in loan acct# %s\n", this.getBalance(), this.getAccount());
		}
		loan.addToStatement(Loan.account, input, "payment", "loan");
	}
	/**
	 * shows all loan end of month info
	 */
	void loanEndOfMonth() {
		
		if(this.input <= 0) {
			double interest = this.getBalance() * this.getInterestRate()/12;
			this.setBalance(interest + this.getLateFee() + this.getBalance());
		
		System.out.printf("Loan balance: $%.2f in acct# %s "
				+ "The late fee is $%.2f.\n", this.balance, this.getAccount(), this.getLateFee());
		}else {
	
		System.out.printf("Loan balance: $%.2f in acct# %s\n",
				this.getBalance() + (this.getBalance() * this.getInterestRate()/12), this.getAccount());
		}
	}
	public Loan(double balance) {

		this.balance = balance;
	}
}
