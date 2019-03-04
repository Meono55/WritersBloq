package com.revature.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "stories")
public class Story {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	// Story information
	private String title;

	@ManyToOne
	private User author;

	private String summary;

//	@OneToMany(fetch = FetchType.LAZY)
//	private List<Chapter> chapters;

//	@OneToMany(fetch = FetchType.LAZY)
//	private List<Comments> comments;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "tag_to_story", inverseJoinColumns = { @JoinColumn(name = "tag_id") }, joinColumns = {
			@JoinColumn(name = "story_id") })
	private List<Tag> tags;
	private String genre;

	@Column(name = "creation_date")
	private Long creationDate;

	@Column(name = "book_cover")
	private String bookCover;

	@Column(name = "is_published")
	private boolean isPublished;

	// Values for determining rating
	@Column(name = "actual_rating")
	private int actualRating;

	@Column(name = "possible_rating")
	private int possibleRating;

	@Column(name = "modified_date")
	private Long modifiedDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Long getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Long creationDate) {
		this.creationDate = creationDate;
	}

	public String getBookCover() {
		return bookCover;
	}

	public void setBookCover(String bookCover) {
		this.bookCover = bookCover;
	}

	public boolean isPublished() {
		return isPublished;
	}

	public void setPublished(boolean isPublished) {
		this.isPublished = isPublished;
	}

	public int getActualRating() {
		return actualRating;
	}

	public void setActualRating(int actualRating) {
		this.actualRating = actualRating;
	}

	public int getPossibleRating() {
		return possibleRating;
	}

	public void setPossibleRating(int possibleRating) {
		this.possibleRating = possibleRating;
	}

	public Long getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Long modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@Override
	public String toString() {
		return "Story [id=" + id + ", title=" + title + ", author=" + author + ", summary=" + summary + ", tags=" + tags
				+ ", genre=" + genre + ", creationDate=" + creationDate + ", bookCover=" + bookCover + ", isPublished="
				+ isPublished + ", actualRating=" + actualRating + ", possibleRating=" + possibleRating
				+ ", modifiedDate=" + modifiedDate + "]";
	}

	public Story(int id, String title, User author, String summary, List<Tag> tags, String genre, Long creationDate,
			String bookCover, boolean isPublished, int actualRating, int possibleRating, Long modifiedDate) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.summary = summary;
		this.tags = tags;
		this.genre = genre;
		this.creationDate = creationDate;
		this.bookCover = bookCover;
		this.isPublished = isPublished;
		this.actualRating = actualRating;
		this.possibleRating = possibleRating;
		this.modifiedDate = modifiedDate;
	}

	public Story() {
		super();
		// TODO Auto-generated constructor stub
	}
}
