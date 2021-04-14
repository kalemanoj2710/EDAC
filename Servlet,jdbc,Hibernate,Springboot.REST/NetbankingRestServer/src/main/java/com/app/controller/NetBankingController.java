package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.BankAccounts;
import com.app.pojos.BankAccount;
import com.app.service.IBankAccountService;
import com.app.service.ICustomerService;

@RestController // Mandatory class level annotation
//@RestController => @Controller on the cls level + @ResponseBody on the ret types of 
//all req handling methods, annotated with @RequestMapping / @GetMapping.....
@RequestMapping("/accounts")
public class NetBankingController {
	//dependency : customer service i/f
	@Autowired
	private ICustomerService customerService;
	@Autowired
	private IBankAccountService acctService;
	
	public NetBankingController() {
		System.out.println("in ctor of " + getClass().getName());
	}
	//add REST clnt request handling method : for supplying all accounts for the authenticated bank customer
	@GetMapping("/customers/{custId}/{pwd}")
	public ResponseEntity<?> listAccountsForCustomer(@PathVariable long custId,@PathVariable String pwd)
	{
		System.out.println("in list accts "+custId+" "+pwd);
		List<BankAccount> accounts = customerService.getAllAccountsForCustomer(custId, pwd);
		//if accts list is empty => SC 204 (NO CONTENT) , non empty => SC 200 n list of accts
		if(accounts.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		//non empty list
		return new ResponseEntity<>(new BankAccounts(accounts), HttpStatus.OK);
	}
	//add REST clnt request handling method : for getting acct summary
	@GetMapping("/{acctId}")
	public ResponseEntity<?> getAccountSummary(@PathVariable int acctId)
	{
		System.out.println("in get a/c summary "+acctId);
		return ResponseEntity.ok(acctService.getAccountSummary(acctId));
	}
	@PostMapping
	public ResponseEntity<?> createAccount(@RequestBody BankAccount a)
	{
		System.out.println("in create a/c "+a);
		
		return ResponseEntity.ok(acctService.createAccount(a));
	}
	@PutMapping("/{acctId}")
	public ResponseEntity<?> updateAccount(@PathVariable int acctId,@RequestBody BankAccount a)
	{
		System.out.println("in update a/c "+a+" "+acctId);
		
		return ResponseEntity.ok(acctService.updateAccount(acctId,a));
	}
	@DeleteMapping("/{acctId}")
	public ResponseEntity<?> deleteAccountSummary(@PathVariable int acctId)
	{
		System.out.println("in delete a/c summary "+acctId);
		return ResponseEntity.ok(acctService.deleteAccountSummary(acctId));
	}
	
	
}
