package edu.gcu.bootcamp.java.eric.stoll.bankingapplication;

import java.util.Scanner;

public class Bank {
	private double input;
	private final String name = "GCU Credit Union";
	Scanner sc = new Scanner(System.in);
	double amount = 0;
	
	public static void main(String[] args) {
// set an object to be called later
		Bank m = new Bank();
		Checking checking = new Checking(5000.00, "9991773");
		Saving saving = new Saving(5000.00, "191923");	
		checking.setOverDraft(45.00);
		saving.setServiceFee(25.00);
		saving.setAnnualInterestRate(.06);
		saving.setMinBalance(200.00);
// use object to call display menu
		m.displayMenu(checking, saving);
		checking.setAccount("9991773");
		saving.setAccount("191923");
	
	}
	private void displayMenu(Checking checking, Saving saving) {
// main menu where user can input an option
		int option;
		do {
			System.out.println("=======================================");
			System.out.println("               MAIN MENU");
			System.out.println("           "+ this.name.toUpperCase());
			System.out.println("=======================================");
			System.out.println("Pick an option: ");
			System.out.println("-----------------------");
			System.out.println(" 1: : Deposit to Checking");
			System.out.println(" 2: : Deposit to Savings");
			System.out.println(" 3: : Write a Check");
			System.out.println(" 4: : Withdraw from Savings");			
			System.out.println(" 5: : Get balance");	
			System.out.println(" 6: : Close month");
			System.out.println("------------------------");
			System.out.println(" 9: : Exit");
			option = sc.nextInt();
			this.actionMenu(option, checking, saving);
		} while (option != 9);
	}
// action menu is where all the action happens
	private void actionMenu (int option, Checking checking, Saving saving) {
		Bank m = new Bank();
		if (option == 1) {
			m.displayDepositChecking(checking);
		}else if
			(option == 2) {
			m.displayDepositSaving(saving);
		}else if
			(option == 3) {
			m.displayWithdrawChecking(checking);
		}else if
			(option == 4) {
			m.displayWithdrawSavings(saving);
		}else if
			(option == 5) {
			m.displayBalanceScreen(checking, saving);
		}else if
			(option == 6) {	
			m.doEndOfMonth(checking, saving);
		}else if
			(option == 9) {
			m.displayExitScreen();
		}else
			System.out.println("Wrong Entry");
	}
	/**
	 * This method displays the end of month of checking and saving and calculates
	 * fees and interest for positive balances in savings
	 */
	private void doEndOfMonth(Checking checking, Saving saving) {
		
		if (saving.balance <= saving.getMinBalance()) {
			System.out.println("Checking: $" + checking.getBalance() + " Saving: $" + 
								(saving.balance - saving.getServiceFee()));
			System.out.println("You have been assessed a $25 min balance fee to savings");
		}else {
		
		System.out.println("Checking: $" + checking.getBalance() + " Saving: $" + (saving.getBalance() + 
						saving.getBalance() * saving.getAnnualInterestRate()/12));
	}
	}
	private void displayExitScreen() {
	
		System.out.println("Goodbye");
	}
	
	private void displayBalanceScreen(Checking checking, Saving saving) {
		System.out.println("Your balance in Checking is: $" + checking.getBalance() + 
				" Your balance is Saving is: $" + saving.getBalance());
		
	}
/**
 * This method displays and calculates transactions of the savings
 */
	private void displayWithdrawSavings(Saving saving) {
		
		System.out.println("Saving balance: $" + saving.getBalance());
		System.out.print("How much to withdraw: $");
		input = sc.nextDouble();
		saving.balance -= input;
		if (saving.balance <= 0) {
			System.out.println("You broke foo");
		}else {
			
		System.out.println("New Saving Balance: $" + saving.getBalance());
	}
	}
	/**
	 * this method displays and calculates withdrawal transactions of the checking
	 * and adds overdraft fees
	 */
	private void displayWithdrawChecking(Checking checking) {
		
		System.out.println("Checking balance: $" + checking.getBalance());
		System.out.print("How much is Check: $");
		input = sc.nextDouble();
		checking.balance -= input;
		if (checking.balance < 0) {
			System.out.println("You have been assessed an overdraft fee of $" + 
								checking.getOverDraft());
			System.out.println("Checking balance: $" + (checking.balance - checking.getOverDraft()));
			checking.setBalance(checking.balance - checking.getOverDraft());
		}else {
		System.out.println("New Checking Balance: $" + checking.getBalance());
	}
	}
	/**
	 * This method displays and calculates the deposits in savings
	 */
	private void displayDepositSaving(Saving saving) {
				
		System.out.println("Saving balance: $" + saving.getBalance());
		
		System.out.print("How much to Deposit: $");
		input = sc.nextDouble();
		saving.balance += input;
		System.out.println("New Saving Balance: $" + saving.getBalance());
		
	}
	
	private void displayDepositChecking(Checking checking) {

		System.out.println("Checking balance: $" + checking.getBalance());
		
		System.out.print("How much to Deposit: $");
		input = sc.nextDouble();
		checking.balance += input;
		System.out.println("New Checking Balance: $" + checking.getBalance());
		
	}
	}