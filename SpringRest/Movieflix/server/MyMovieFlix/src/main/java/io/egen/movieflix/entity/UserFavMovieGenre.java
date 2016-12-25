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
 * The persistent class for the user_fav_movie_genre database table.
 * 
 */
@Entity
@Table(name="user_fav_movie_genre")
@NamedQuery(name="UserFavMovieGenre.findAll", query="SELECT u FROM UserFavMovieGenre u")
public class UserFavMovieGenre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="user_fav_movie_genre_id_pk")
	private Integer userFavMovieGenreIdPk;

	@Column(name="genre_id_fk")
	private Integer genreIdFk;

	@ManyToOne
	@JoinColumn(name="account_id_fk")
	private Account account;

	public UserFavMovieGenre() {
	}

	public Integer getUserFavMovieGenreIdPk() {
		return this.userFavMovieGenreIdPk;
	}

	public void setUserFavMovieGenreIdPk(Integer userFavMovieGenreIdPk) {
		this.userFavMovieGenreIdPk = userFavMovieGenreIdPk;
	}

	public Integer getGenreIdFk() {
		return this.genreIdFk;
	}

	public void setGenreIdFk(Integer genreIdFk) {
		this.genreIdFk = genreIdFk;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}