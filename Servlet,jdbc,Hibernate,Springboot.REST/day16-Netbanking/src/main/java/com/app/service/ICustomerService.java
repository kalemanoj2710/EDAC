package com.app.service;

import java.util.List;

import com.app.pojos.BankAccount;

public interface ICustomerService {
   List<BankAccount>getAllAccountsForCustomer(long custId,String pwd);
}
