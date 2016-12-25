package io.egen.movieflix.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the code database table.
 * 
 */
@Entity
@NamedQuery(name="Code.findAll", query="SELECT c FROM Code c")
public class Code implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="code_id_pk")
	private Integer codeIdPk;

	private String value;

	public Code() {
	}

	public Integer getCodeIdPk() {
		return this.codeIdPk;
	}

	public void setCodeIdPk(Integer codeIdPk) {
		this.codeIdPk = codeIdPk;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}