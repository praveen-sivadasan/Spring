package io.egen.movieflix.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The persistent class for the code_master database table.
 * 
 */
@Entity
@Table(name = "code_master")
@NamedQuery(name = "CodeMaster.findAll", query = "SELECT c FROM CodeMaster c")
public class CodeMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "code_master_id_pk")
	private Integer codeMasterIdPk;

	private String value;

	@OneToOne
	@JoinColumn(name = "code_id_fk")
	private Code code;

	public CodeMaster() {
	}

	public Integer getCodeMasterIdPk() {
		return this.codeMasterIdPk;
	}

	public void setCodeMasterIdPk(Integer codeMasterIdPk) {
		this.codeMasterIdPk = codeMasterIdPk;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Code getCode() {
		return this.code;
	}

	public void setCode(Code code) {
		this.code = code;
	}

}