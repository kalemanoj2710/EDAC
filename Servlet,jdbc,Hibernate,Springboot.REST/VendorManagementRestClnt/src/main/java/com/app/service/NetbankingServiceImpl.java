package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.app.dto.BankAccounts;
import com.app.pojos.BankAccount;

@Service
public class NetbankingServiceImpl implements INetbankingService {
	private RestTemplate template;
	@Value("${REST_GET_ACCTS}")
	private String getURL;

	@Autowired
	public NetbankingServiceImpl(RestTemplateBuilder builder) {
		template = builder.build();
	}

	@Override
	public List<BankAccount> authenticateCustomer(long custId, String pwd) {
		System.out.println(getURL);
		try {
			ResponseEntity<BankAccounts> respEntity = template.getForEntity(getURL, BankAccounts.class, custId, pwd);
			System.out.println("resp ent " + respEntity);
			return respEntity.getBody().getAccounts();
		} catch (HttpClientErrorException e) {
			System.out.println(e);
			return null;
		}

	}

}
