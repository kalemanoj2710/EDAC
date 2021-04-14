package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.AccountHandlingException;
import com.app.dao.BankAccountRepository;
import com.app.pojos.BankAccount;

@Service
@Transactional
public class BankAccountServiceImpl implements IBankAccountService {
	@Autowired
	private BankAccountRepository acctRepo;

	@Override
	public BankAccount getAccountSummary(int acctId) {
		// invoke DAO layer's method n handle Optional
		return acctRepo.findById(acctId).orElseThrow(()->new AccountHandlingException("Invalid Account ID !!!!"));
	}

}
