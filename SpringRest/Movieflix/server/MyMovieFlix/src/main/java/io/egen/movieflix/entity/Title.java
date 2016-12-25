package io.egen.movieflix.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the title database table.
 * 
 */
@Entity
@NamedQuery(name = "Title.findAll", query = "SELECT t FROM Title t")
public class Title implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "title_id_pk")
	private Integer titleIdPk;

	private String actors;

	private String awards;

	@Temporal(TemporalType.DATE)
	@Column(name = "create_date")
	private Date createDate;

	private String director;

	@Column(name = "imdb_id")
	private String imdbId;

	@Column(name = "imdb_rating")
	private Integer imdbRating;

	@Column(name = "imdb_votes")
	private String imdbVotes;

	private String metascore;

	@Column(name = "user_rating")
	private Float userRating;

	private String plot;

	private String poster;

	@Temporal(TemporalType.DATE)
	@Column(name = "release_date")
	private Date releaseDate;

	private String runtime;

	private String title;

	private String writer;

	private String year;

	@Column(name = "delete_flag")
	private Integer deleteFlag;
	// 0 inactive 1 active

	@OneToOne
	@JoinColumn(name = "title_type_id_fk")
	private CodeMaster titleType;

	@OneToOne
	@JoinColumn(name = "rating_id_fk")
	private CodeMaster titleRating;

	@OneToMany(mappedBy = "title", fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	private List<TitleCountry> titleCountries;

	@OneToMany(mappedBy = "title", fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	private List<TitleGenre> titleGenres;

	@OneToMany(mappedBy = "title", fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	private List<TitleLanguage> titleLanguages;

	@OneToMany(mappedBy = "title", fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	private List<UserTitleComment> userComments;

	public Title() {
	}

	public Integer getTitleIdPk() {
		return this.titleIdPk;
	}

	public void setTitleIdPk(Integer titleIdPk) {
		this.titleIdPk = titleIdPk;
	}

	public String getActors() {
		return this.actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getAwards() {
		return this.awards;
	}

	public void setAwards(String awards) {
		this.awards = awards;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDirector() {
		return this.director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getImdbId() {
		return this.imdbId;
	}

	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}

	public Integer getImdbRating() {
		return this.imdbRating;
	}

	public void setImdbRating(Integer imdbRating) {
		this.imdbRating = imdbRating;
	}

	public String getImdbVotes() {
		return this.imdbVotes;
	}

	public void setImdbVotes(String imdbVotes) {
		this.imdbVotes = imdbVotes;
	}

	public String getMetascore() {
		return this.metascore;
	}

	public void setMetascore(String metascore) {
		this.metascore = metascore;
	}

	public String getPlot() {
		return this.plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public Float getUserRating() {
		return userRating;
	}

	public void setUserRating(Float userRating) {
		this.userRating = userRating;
	}

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getPoster() {
		return this.poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public Date getReleaseDate() {
		return this.releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getRuntime() {
		return this.runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return this.writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public List<TitleCountry> getTitleCountries() {
		return this.titleCountries;
	}

	public void setTitleCountries(List<TitleCountry> titleCountries) {
		this.titleCountries = titleCountries;
	}

	public CodeMaster getTitleType() {
		return titleType;
	}

	public void setTitleType(CodeMaster titleType) {
		this.titleType = titleType;
	}

	public CodeMaster getTitleRating() {
		return titleRating;
	}

	public void setTitleRating(CodeMaster titleRating) {
		this.titleRating = titleRating;
	}

	public TitleCountry addTitleCountry(TitleCountry titleCountry) {
		getTitleCountries().add(titleCountry);
		titleCountry.setTitle(this);

		return titleCountry;
	}

	public TitleCountry removeTitleCountry(TitleCountry titleCountry) {
		getTitleCountries().remove(titleCountry);
		titleCountry.setTitle(null);

		return titleCountry;
	}

	public List<TitleGenre> getTitleGenres() {
		return this.titleGenres;
	}

	public void setTitleGenres(List<TitleGenre> titleGenres) {
		this.titleGenres = titleGenres;
	}

	public TitleGenre addTitleGenre(TitleGenre titleGenre) {
		getTitleGenres().add(titleGenre);
		titleGenre.setTitle(this);

		return titleGenre;
	}

	public TitleGenre removeTitleGenre(TitleGenre titleGenre) {
		getTitleGenres().remove(titleGenre);
		titleGenre.setTitle(null);

		return titleGenre;
	}

	public List<TitleLanguage> getTitleLanguages() {
		return this.titleLanguages;
	}

	public void setTitleLanguages(List<TitleLanguage> titleLanguages) {
		this.titleLanguages = titleLanguages;
	}

	public TitleLanguage addTitleLanguage(TitleLanguage titleLanguage) {
		getTitleLanguages().add(titleLanguage);
		titleLanguage.setTitle(this);

		return titleLanguage;
	}

	public TitleLanguage removeTitleLanguage(TitleLanguage titleLanguage) {
		getTitleLanguages().remove(titleLanguage);
		titleLanguage.setTitle(null);

		return titleLanguage;
	}

	public List<UserTitleComment> getUserComments() {
		return userComments;
	}

	public void setUserComments(List<UserTitleComment> userComments) {
		this.userComments = userComments;
	}

}