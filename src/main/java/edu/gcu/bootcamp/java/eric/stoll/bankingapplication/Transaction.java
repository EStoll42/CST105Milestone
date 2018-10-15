package edu.gcu.bootcamp.java.eric.stoll.bankingapplication;

public interface Transaction {
  
	public void addToStatement (String account, double amount, String transactionType, String accountType);
}