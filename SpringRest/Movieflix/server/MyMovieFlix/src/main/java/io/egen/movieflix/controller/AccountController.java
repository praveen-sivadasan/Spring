package io.egen.movieflix.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.movieflix.DTO.AccountDTO;
import io.egen.movieflix.entity.Account;
import io.egen.movieflix.entity.CodeMaster;
import io.egen.movieflix.exceptions.UserAlreadyExistsException;
import io.egen.movieflix.exceptions.UserNotFoundException;
import io.egen.movieflix.service.impl.AccountServiceImpl;
import io.egen.movieflix.service.impl.CodeMasterServiceImpl;
import io.egen.movieflix.utils.ApplicationLogger;
import io.egen.movieflix.utils.ConversionUtils;
import io.egen.movieflix.validators.UserValidator;

/**
 * Handles account related functions. Signup and login. Used by external user
 * only. Only access to guest.
 * 
 * @author psivadasan
 *
 */
@RestController
@RequestMapping(value = "/account")
public class AccountController {
	@Autowired
	AccountServiceImpl accountService;

	@Autowired
	ApplicationLogger log;

	@Autowired
	ConversionUtils conversionUtils;

	@Autowired
	UserValidator userValidator;

	@Autowired
	CodeMasterServiceImpl appService;

	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public AccountDTO createAccount(@RequestBody AccountDTO accountDTO) throws UserAlreadyExistsException {
		try {
			if (userValidator.checkUserDataValidity(accountDTO)) {
				Account account = conversionUtils.convertAccountDTOToEntity(accountDTO);
				account.setCreateDate(new Date());
				account.setAccountRole(appService.findCodeMasterByValue("User"));
				// TODO fetch from cache
				String genderId = accountDTO.getGender().getCodeMasterId();
				CodeMaster gender = appService.findCodeMasterById(Integer.valueOf(genderId));
				account.setGender(gender);// TODO fetch from cache
				accountService.create(account);
				accountDTO = conversionUtils.convertAccountEntityToDTO(account);
				return accountDTO;
			}
			return null;
		} catch (UserAlreadyExistsException e) {
			log.error(e.getMessage());
			throw new UserAlreadyExistsException();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}

	@RequestMapping(value = "/lookup", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public AccountDTO lookUpAccount(@RequestBody AccountDTO accountDTO) throws UserNotFoundException{
		try {
			Account account = accountService.lookUpAccount(accountDTO.getUserName(), accountDTO.getPassword());
			if (account != null) {
				accountDTO = conversionUtils.convertAccountEntityToDTO(account);
				return accountDTO;
			}
			return null;
		} catch (UserNotFoundException e) {
			log.error(e.getMessage());
			throw new UserNotFoundException();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}
}
