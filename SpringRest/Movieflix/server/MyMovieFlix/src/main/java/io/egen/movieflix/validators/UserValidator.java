package io.egen.movieflix.validators;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.egen.movieflix.DTO.AccountDTO;
import io.egen.movieflix.entity.Account;
import io.egen.movieflix.exceptions.UserAlreadyExistsException;
import io.egen.movieflix.service.impl.AccountServiceImpl;
import io.egen.movieflix.utils.ApplicationUtils;

@Service
public class UserValidator {

	@Autowired
	ApplicationUtils utils;
	
	@Autowired
	AccountServiceImpl accountService;

	public boolean checkUserDataValidity(AccountDTO dto) throws UserAlreadyExistsException, Exception {
		boolean flag = Boolean.TRUE;

		if (dto.getAccountId() != null && dto.getAccountId().trim().equals("")) {
			try {
				Integer.parseInt(dto.getAccountId());
			} catch (Exception e) {
				flag = Boolean.FALSE;
			}
		}

		if (dto.getCreateDate() == null || dto.getCreateDate().trim().equals("")) {
			flag = Boolean.FALSE;
		} else {
			try {
				utils.convertStringToDate(dto.getCreateDate());
			} catch (Exception e) {
				flag = Boolean.FALSE;
			}
		}

		if (dto.getEmail() == null || dto.getEmail().trim().equals("")) {
			flag = Boolean.FALSE;
		}

		if (dto.getFirstName() == null || dto.getFirstName().trim().equals("")) {
			flag = Boolean.FALSE;
		}

		if (dto.getLastName() == null || dto.getLastName().trim().equals("")) {
			flag = Boolean.FALSE;
		}

		if (dto.getPassword() == null || dto.getPassword().trim().equals("")) {
			flag = Boolean.FALSE;
		}
		
		if (dto.getUserDetailDTO() != null) {
			if (dto.getUserDetailDTO().getAddress() != null && dto.getUserDetailDTO().getAddress().trim().equals("")) {
				flag = Boolean.FALSE;
			}

			if (dto.getUserDetailDTO().getPhoneNumber() != null
					&& dto.getUserDetailDTO().getPhoneNumber().trim().equals("")) {
				flag = Boolean.FALSE;
			}
		}

		if (dto.getUserName() == null || dto.getUserName().trim().equals("")) {
			flag = Boolean.FALSE;
		} else {
			if(dto.getAccountId() != null){
				List<Account> users = accountService.fetchAccountByUserName(dto.getUserName());
				if(users != null && !users.isEmpty()){
					flag = Boolean.FALSE;
				}	
			}
		}
		

		return flag;
	}
}
