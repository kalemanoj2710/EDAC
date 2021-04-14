package utils;

import custom_exception.AccountHandlingException;

public class BankValidationRules {
	public static double MIN_BALANCE;
	static {
		MIN_BALANCE=1000;
	}
	//add a static method for validating balance
	public static double validateBalance(double balance) throws AccountHandlingException
	{
		if(balance < MIN_BALANCE)
			throw new AccountHandlingException("A/C Overdrawn!!!!!!");
		return balance;
	}

}
