package edu.gcu.bootcamp.java.eric.stoll.bankingapplication;

import java.util.Scanner;

public class Bank {
	
	private final String name = "GCU Credit Union";
	Scanner sc = new Scanner(System.in);
	double amount = 0;
	Customer c = new Customer();

	
	public static void main(String[] args) {
// set an object to be called later
		Bank m = new Bank();
		Checking checking = new Checking(2500.00);
		Saving saving = new Saving(5000.00);
		Loan loan = new Loan(10000.00);
// use object to call display menu
		m.displayMenu(checking, saving, loan);
	}
	
	private void displayMenu(Checking checking, Saving saving, Loan loan) {
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
			System.out.println(" 6: : Make Loan Payment");
			System.out.println(" 7: : Close month");
			System.out.println("------------------------");
			System.out.println(" 9: : Exit");
			option = sc.nextInt();
			this.actionMenu(option, checking, saving, loan);
		} while (option != 9);
	}
// action menu is where all the action happens
	private void actionMenu (int option, Checking checking, Saving saving, Loan loan) {
		Bank b = new Bank();

		switch(option) {
		case 1: checking.displayDepositChecking(checking);
			break;
		case 2: saving.displayDepositSaving(saving);
			break;
		case 3: checking.displayWithdrawChecking(checking);
			break;
		case 4: saving.displayWithdrawSavings(saving);
			break;
		case 5: b.displayBalanceScreen(checking, saving, loan);
			break;
		case 6: loan.displayLoanPayment(loan);
			break;
		case 7: b.doEndOfMonth(checking, saving, loan);
			break;
		case 9: b.displayExitScreen();
			break;
		default: System.out.println("Wrong Entry");
		}
	}
	/**
	 * This method displays the end of month of checking and saving and calculates
	 * fees and interest for positive balances in savings
	 */
	private void doEndOfMonth(Checking checking, Saving saving, Loan loan) {
		
		checking.checkingEndOfMonth();
		loan.loanEndOfMonth();										
		saving.savingEndOfMonth(); 
		Account.displayStatement();
		}

	private void displayExitScreen() {
		
		System.out.println("Goodbye " + c.getFirstName() +" "+ c.getLastName());
	}
	
	private void displayBalanceScreen(Checking checking, Saving saving, Loan loan) {
		System.out.println("Your balance in Checking is: $" + checking.getBalance() + 
				" Your balance is Saving is: $" + saving.getBalance() +
				" The balance on your loan is: $" + loan.getBalance());		
	}
}
