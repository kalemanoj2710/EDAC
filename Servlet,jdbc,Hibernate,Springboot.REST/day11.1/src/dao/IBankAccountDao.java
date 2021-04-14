package dao;

import pojos.BankAccount;

public interface IBankAccountDao {
	String openAccount(int vendorId, BankAccount account);

	String closeAccount(int vendorId, int acctId);
}
