package edu.gcu.bootcamp.java.eric.stoll.bankingapplication;

public class Customer {

	 private String firstName = "James";
	 private String lastName = "Bond";
 
	 public String getFirstName() {
		return firstName;
	}
	 
	public String getLastName() {
		return lastName;
	}
	
    Customer(String firstName, String lastName, String account) {   
        this.firstName = firstName;
        this.lastName = lastName;
        Loan.account  = account;
    }

	public Customer() {
		this.getFirstName();
		this.getLastName();
	}
}