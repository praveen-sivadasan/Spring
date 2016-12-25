package io.egen.movieflix.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the title_country database table.
 * 
 */
@Entity
@Table(name = "title_country")
@NamedQuery(name = "TitleCountry.findAll", query = "SELECT t FROM TitleCountry t")
public class TitleCountry implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "title_country_id_pk")
	private Integer titleCountryIdPk;

	@ManyToOne
	@JoinColumn(name = "title_id_fk")
	private Title title;

	@ManyToOne
	@JoinColumn(name = "country_id_fk")
	private CodeMaster country;

	public TitleCountry() {
	}

	public Integer getTitleCountryIdPk() {
		return this.titleCountryIdPk;
	}

	public void setTitleCountryIdPk(Integer titleCountryIdPk) {
		this.titleCountryIdPk = titleCountryIdPk;
	}

	public Title getTitle() {
		return this.title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public CodeMaster getCountry() {
		return country;
	}

	public void setCountry(CodeMaster country) {
		this.country = country;
	}

}