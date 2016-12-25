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
 * The persistent class for the title_language database table.
 * 
 */
@Entity
@Table(name = "title_language")
@NamedQuery(name = "TitleLanguage.findAll", query = "SELECT t FROM TitleLanguage t")
public class TitleLanguage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "title_language_id_pk")
	private Integer titleLanguageIdPk;

	@ManyToOne
	@JoinColumn(name = "title_id_fk")
	private Title title;

	@ManyToOne
	@JoinColumn(name = "language_id_fk")
	private CodeMaster language;

	public TitleLanguage() {
	}

	public Integer getTitleLanguageIdPk() {
		return this.titleLanguageIdPk;
	}

	public void setTitleLanguageIdPk(Integer titleLanguageIdPk) {
		this.titleLanguageIdPk = titleLanguageIdPk;
	}

	public Title getTitle() {
		return this.title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public CodeMaster getLanguage() {
		return language;
	}

	public void setLanguage(CodeMaster language) {
		this.language = language;
	}

}