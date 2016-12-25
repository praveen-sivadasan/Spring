package io.egen.movieflix.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The persistent class for the user_title_rating database table.
 * 
 */
@Entity
@Table(name = "user_title_rating")
@NamedQuery(name = "UserTitleRating.findAll", query = "SELECT u FROM UserTitleRating u")
public class UserTitleRating implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "user_title_rating_id_pk")
	private Integer userTitleRatingIdPk;

	private Integer rating;

	@OneToOne
	@JoinColumn(name = "title_id_fk")
	private Title title;

	@ManyToOne
	@JoinColumn(name = "account_id_fk")
	private Account account;

	public UserTitleRating() {
	}

	public Integer getUserTitleRatingIdPk() {
		return this.userTitleRatingIdPk;
	}

	public void setUserTitleRatingIdPk(Integer userTitleRatingIdPk) {
		this.userTitleRatingIdPk = userTitleRatingIdPk;
	}

	public Integer getRating() {
		return this.rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}