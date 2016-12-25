package io.egen.movieflix.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the user_details database table.
 * 
 */
@Entity
@Table(name = "user_details")
@NamedQuery(name = "UserDetail.findAll", query = "SELECT u FROM UserDetail u")
public class UserDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "user_details_id_pk")
	private Integer userDetailsIdPk;

	private String address;

	@Column(name = "phone_number")
	private String phoneNumber;

	public UserDetail() {
	}

	public Integer getUserDetailsIdPk() {
		return this.userDetailsIdPk;
	}

	public void setUserDetailsIdPk(Integer userDetailsIdPk) {
		this.userDetailsIdPk = userDetailsIdPk;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}