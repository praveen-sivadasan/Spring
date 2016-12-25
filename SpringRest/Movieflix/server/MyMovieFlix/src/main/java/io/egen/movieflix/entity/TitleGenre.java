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
 * The persistent class for the title_genre database table.
 * 
 */
@Entity
@Table(name = "title_genre")
@NamedQuery(name = "TitleGenre.findAll", query = "SELECT t FROM TitleGenre t")
public class TitleGenre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "title_genre_id_pk")
	private Integer titleGenreIdPk;

	@ManyToOne
	@JoinColumn(name = "title_id_fk")
	private Title title;

	@ManyToOne
	@JoinColumn(name = "genre_id_fk")
	private CodeMaster genre;

	public TitleGenre() {
	}

	public Integer getTitleGenreIdPk() {
		return this.titleGenreIdPk;
	}

	public void setTitleGenreIdPk(Integer titleGenreIdPk) {
		this.titleGenreIdPk = titleGenreIdPk;
	}

	public Title getTitle() {
		return this.title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public CodeMaster getGenre() {
		return genre;
	}

	public void setGenre(CodeMaster genre) {
		this.genre = genre;
	}

}