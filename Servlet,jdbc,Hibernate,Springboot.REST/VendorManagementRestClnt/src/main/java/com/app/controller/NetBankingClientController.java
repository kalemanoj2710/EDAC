package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.BankAccount;
import com.app.service.INetbankingService;

@Controller
@RequestMapping("/banking")
public class NetBankingClientController {
	@Autowired
	private INetbankingService netBankingService;

	// add a request method to show a form for netbanking login
	@GetMapping("/login")
	public String showLoginForm() {
		System.out.println("in show login form");
		return "/banking/login";
	}

	// process login form
	@PostMapping("/login")
	public String processLoginForm(@RequestParam long custId, @RequestParam String password,
			RedirectAttributes flashMap,Model map) {
		System.out.println("in process form" + custId + " " + password);
		List<BankAccount> list = netBankingService.authenticateCustomer(custId, password);
		if (list != null) {
			flashMap.addFlashAttribute("accts", list);
			return "redirect:/banking/acct_list";
		}
		map.addAttribute("message", "Invalid Credentials!!!!!");
		return "/banking/login";
	}

	// show list of vendor accounts
	@GetMapping("/acct_list")
	public String showAccountList() {
		System.out.println("in show acct list");
		return "/banking/acct_list";
	}
}
