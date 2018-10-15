package edu.gcu.bootcamp.java.eric.stoll.bankingapplication;

import java.util.Scanner;

public class Checking extends Account {
	
	private double overDraft = 45.00;
	static String account = "45676543";
	private double input;
	Scanner sc = new Scanner(System.in);

	public double getOverDraft() {
		return overDraft;
	}

	public void setOverDraft(double overDraft) {
		this.overDraft = overDraft;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		Checking.account = account;
	}

	public double doWithdraw(double amount) {
		return amount;		
	}
	
	public Checking(double balance) {
		
		this.balance = balance;
	}
	/**
	 * this method displays and calculates withdrawal transactions of the checking
	 * and adds overdraft fees
	 */
	public void displayWithdrawChecking(Checking checking) {
		
		System.out.printf("Checking balance: $%.2f\n", checking.getBalance());
		System.out.print("How much is Check: $");
		input = sc.nextDouble();
		checking.balance -= input;
		if (checking.balance < 0) {
			System.out.printf("You have been assessed an overdraft fee of $%.2f ", 
								checking.getOverDraft());
			checking.setBalance(checking.balance - checking.getOverDraft());
			System.out.println("Checking balance: $" + (checking.balance - checking.getOverDraft()));
			
		}else {
		System.out.println("New Checking Balance: $" + checking.getBalance());
	}
		checking.addToStatement(Checking.account, input, "withdraw", "checking");
	}
	
	public void displayDepositChecking(Checking checking) {

		System.out.printf("Checking balance: $%.2f\n", checking.getBalance());
		
		System.out.print("How much to Deposit: $");
		input = sc.nextDouble();
		checking.balance += input;
		System.out.println("New Checking Balance: $" + checking.getBalance());
		checking.addToStatement(Checking.account, input, "deposit", "checking");
	}

	void checkingEndOfMonth() {
		System.out.println("Checking: $" + this.getBalance() + " in acct# " + this.getAccount());
	}
}