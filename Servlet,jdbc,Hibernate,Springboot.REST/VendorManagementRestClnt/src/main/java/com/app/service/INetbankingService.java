package com.app.service;

import java.util.List;

import com.app.pojos.BankAccount;

public interface INetbankingService {
 List<BankAccount> authenticateCustomer(long custId,String pwd);
}
