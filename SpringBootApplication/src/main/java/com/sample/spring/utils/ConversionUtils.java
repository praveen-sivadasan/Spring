/*package com.sample.spring.utils;

import org.springframework.stereotype.Service;

import com.sample.spring.dto.AccountDTO;
import com.sample.spring.entity.Account;


@Service
public class ConversionUtils {

	// ACCOUNT
	public AccountDTO convertAccountEntityToDTO(Account entity) throws Exception {

		AccountDTO dto = new AccountDTO();
		dto.setAccountId(entity.getAccountIdPk() != null ? String.valueOf(entity.getAccountIdPk()) : null);
		//dto.setRole(convertCodeMasterEntityToDTO(entity.getAccountRole()));
		//dto.setCreateDate(utils.convertDateToString(entity.getCreateDate()));
		dto.setEmail(entity.getEmail());
		dto.setFirstName(entity.getFirstName());
		//dto.setGender(convertCodeMasterEntityToDTO(entity.getGender()));
		dto.setLastName(entity.getLastName());
		dto.setPassword(entity.getPassword());
		dto.setUserName(entity.getUserName());
		dto.setUserDetailDTO(
				entity.getUserDetail() != null ? convertUserDetailEntityToDTO(entity.getUserDetail()) : null);

		return dto;
	}
}
*/