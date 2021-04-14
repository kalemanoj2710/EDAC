package com.app.service;

import com.app.pojos.BankAccount;

public interface IBankAccountService {
	BankAccount getAccountSummary(int acctId);
}
