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

	@Override
	public BankAccount createAccount(BankAccount a) {
		System.out.println("in service "+a);
		System.out.println(a.getAcctOwner());
		return acctRepo.save(a);
	}

	@Override
	public BankAccount updateAccount(int acctId,BankAccount a) {
		
		System.out.println("in service "+a);
		System.out.println(a.getAcctOwner());
		acctRepo.findById(acctId).orElseThrow(()->new AccountHandlingException("A/C Updates failed !!!: ivalid a/c id"));
		return acctRepo.save(a);
	}

	@Override
	public BankAccount deleteAccountSummary(int acctId) {
		BankAccount a=acctRepo.findById(acctId).orElseThrow(()->new AccountHandlingException("Invalid Account ID !!!!"));
		acctRepo.deleteById(acctId);
		return a;
	}

	

}
