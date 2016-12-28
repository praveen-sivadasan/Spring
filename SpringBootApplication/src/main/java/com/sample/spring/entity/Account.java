/*package com.sample.spring.entity;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

*//**
 * The persistent class for the account database table.
 * 
 *//*
@Entity
@NamedQueries({ @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a"),
		@NamedQuery(name = "Account.lookUpLogin", query = "SELECT a FROM Account a where a.userName = :userName ") })
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "account_id_pk")
	private Integer accountIdPk;

	
	 * @OneToOne
	 * 
	 * @JoinColumn(name = "account_role_id_fk") private CodeMaster accountRole;
	 

	@Temporal(TemporalType.DATE)
	@Column(name = "create_date")
	private Date createDate;

	private String email;

	@Column(name = "first_name")
	private String firstName;

	
	 * @OneToOne
	 * 
	 * @JoinColumn(name = "gender_id_fk") private CodeMaster gender;
	 

	@Column(name = "last_name")
	private String lastName;

	private String password;

	@Column(name = "user_name")
	private String userName;

	
	 * @OneToOne
	 * 
	 * @JoinColumn(name = "user_details_id_fk") private UserDetail userDetail;
	 

	public Account() {
	}

	public Account(Integer accountIdPk, Date createDate, String email, String firstName, String lastName,
			String password, String userName  UserDetail userDetail ) {
		// super();
		this.accountIdPk = accountIdPk;
		// this.accountRole = accountRole;
		this.createDate = createDate;
		this.email = email;
		this.firstName = firstName;
		// this.gender = gender;
		this.lastName = lastName;
		this.password = password;
		this.userName = userName;
		// this.userDetail = userDetail;
	}

	public Integer getAccountIdPk() {
		return this.accountIdPk;
	}

	public void setAccountIdPk(Integer accountIdPk) {
		this.accountIdPk = accountIdPk;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	
	 * public CodeMaster getAccountRole() { return accountRole; }
	 * 
	 * public void setAccountRole(CodeMaster accountRole) { this.accountRole =
	 * accountRole; }
	 * 
	 * public CodeMaster getGender() { return gender; }
	 * 
	 * public void setGender(CodeMaster gender) { this.gender = gender; }
	 

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	 * public UserDetail getUserDetail() { return this.userDetail; }
	 * 
	 * public void setUserDetail(UserDetail userDetail) { this.userDetail =
	 * userDetail; }
	 
}*/