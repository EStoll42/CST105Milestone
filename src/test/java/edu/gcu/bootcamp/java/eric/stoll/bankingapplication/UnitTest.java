package edu.gcu.bootcamp.java.eric.stoll.bankingapplication;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UnitTest {

	Account acct = new Account();
	
	@Test
	public void testDeposit() {
		
		double amount = 1000.0;
		acct.setBalance(amount);
		double expected = 1000.0;
		double actual = acct.getBalance();
		assertEquals(actual,expected);
	}
	@Test
	public void testWithdraw() {
		
		double amount = 1000.0;
		acct.setBalance(amount);
		double expected = 1000.0;
		double actual = acct.getBalance();
		assertEquals(actual,expected);
	}
	}