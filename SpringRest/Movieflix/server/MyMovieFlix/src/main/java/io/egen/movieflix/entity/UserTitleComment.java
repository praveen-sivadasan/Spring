package io.egen.movieflix.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the user_title_comment database table.
 * 
 */
@Entity
@Table(name = "user_title_comment")
@NamedQuery(name = "UserTitleComment.findAll", query = "SELECT u FROM UserTitleComment u")
public class UserTitleComment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "user_title_comment_id_pk")
	private Integer userTitleCommentIdPk;

	private String comment;

	@Temporal(TemporalType.DATE)
	@Column(name = "create_date")
	private Date createDate;

	@ManyToOne
	@JoinColumn(name = "title_id_fk")
	private Title title;

	@ManyToOne
	@JoinColumn(name = "account_id_fk")
	private Account account;

	public UserTitleComment() {
	}

	public Integer getUserTitleCommentIdPk() {
		return this.userTitleCommentIdPk;
	}

	public void setUserTitleCommentIdPk(Integer userTitleCommentIdPk) {
		this.userTitleCommentIdPk = userTitleCommentIdPk;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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