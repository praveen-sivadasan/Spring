/*package com.sample.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sample.spring.dto.AccountDTO;
import com.sample.spring.entity.Account;
import com.sample.spring.utils.ConversionUtils;

@RestController
@RequestMapping(value="/account")
public class AccountController {
	
	@Autowired
	com.sample.spring.service.AccountServiceImpl accountService;	
	
	@Autowired
	ConversionUtils conversionUtils;
	
	@RequestMapping(value = "/lookup{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Account> lookUpAccount(@PathVariable String id){
		try {
			
			
			List<Account> accounts = accountService.fetchAllUserAccount(id);
			AccountDTO accountDTO = conversionUtils.convertAccountEntityToDTO(accounts.get(0));
			return accounts;
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return null;
	}

}
*/