package com.sample.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sample.spring.entity.Account;
import com.sample.spring.utils.ApplicationConstants;
import com.sample.spring.utils.ConversionUtils;

@RestController
@RequestMapping(value = "/account")
public class AccountController {

	@Autowired
	com.sample.spring.service.AccountServiceImpl accountService;

	@Autowired
	ConversionUtils conversionUtils;

	@RequestMapping(value = "/lookup{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> lookUpAccount(@PathVariable String id) {
		try {
			ApplicationConstants.resetOutput();
			ApplicationConstants.getOutput().add("Searching for users..");
			ApplicationConstants.getOutput().add(" ");
			ApplicationConstants.getOutput().add("AccountController.class: Invoking lookUpAccount GET method..");

			List<Account> accounts = accountService.fetchAllUserAccount(id);
			// AccountDTO accountDTO =
			// conversionUtils.convertAccountEntityToDTO(accounts.get(0));
			ApplicationConstants.getOutput().add(" ");
			ApplicationConstants.getOutput().add("Printing data fetched from Amazon RDS..");

			for (Account obj : accounts) {
				ApplicationConstants.getOutput().add(obj.toString());
			}
			return ApplicationConstants.getOutput();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
