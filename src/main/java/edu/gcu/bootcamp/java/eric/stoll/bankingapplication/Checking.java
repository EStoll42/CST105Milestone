package edu.gcu.bootcamp.java.eric.stoll.bankingapplication;

public class Checking extends Account {
	
	private double overDraft;
	

	public double getOverDraft() {
		return overDraft;
	}

	public void setOverDraft(double overDraft) {
		this.overDraft = overDraft;
	}

	public double doWithdraw(double amount) {
		return amount;		
	}
	
	public Checking(double balance, String account) {
		
		this.balance = balance;
	}
}
