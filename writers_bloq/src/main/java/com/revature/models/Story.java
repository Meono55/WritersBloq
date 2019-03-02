package com.revature.models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

	@OneToMany(fetch = FetchType.LAZY)
	private List<Chapter> chapters;

	@OneToMany(fetch = FetchType.LAZY)
	private List<Comments> comments;

	@Column(name = "creation_date")
	private long creationDate;

	@Column(name = "book_cover")
	private String bookCover;

	@Column(name = "is_published")
	private boolean isPublished;

	// Values for determining rating
	@Column(name = "actual_rating")
	private int actualRating;

	@Column(name = "possible_rating")
	private int possibleRating;

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

	public List<Chapter> getChapters() {
		return chapters;
	}

	public void setChapters(List<Chapter> chapters) {
		this.chapters = chapters;
	}

	public List<Comments> getComments() {
		return comments;
	}

	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}

	public long getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(long creationDate) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + actualRating;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((bookCover == null) ? 0 : bookCover.hashCode());
		result = prime * result + ((chapters == null) ? 0 : chapters.hashCode());
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + (int) (creationDate ^ (creationDate >>> 32));
		result = prime * result + id;
		result = prime * result + (isPublished ? 1231 : 1237);
		result = prime * result + possibleRating;
		result = prime * result + ((summary == null) ? 0 : summary.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Story other = (Story) obj;
		if (actualRating != other.actualRating)
			return false;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (bookCover == null) {
			if (other.bookCover != null)
				return false;
		} else if (!bookCover.equals(other.bookCover))
			return false;
		if (chapters == null) {
			if (other.chapters != null)
				return false;
		} else if (!chapters.equals(other.chapters))
			return false;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (creationDate != other.creationDate)
			return false;
		if (id != other.id)
			return false;
		if (isPublished != other.isPublished)
			return false;
		if (possibleRating != other.possibleRating)
			return false;
		if (summary == null) {
			if (other.summary != null)
				return false;
		} else if (!summary.equals(other.summary))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Story [id=" + id + ", title=" + title + ", author=" + author + ", summary=" + summary + ", chapters="
				+ chapters + ", comments=" + comments + ", creationDate=" + creationDate + ", bookCover=" + bookCover
				+ ", isPublished=" + isPublished + ", actualRating=" + actualRating + ", possibleRating="
				+ possibleRating + "]";
	}

	public Story(int id, String title, User author, String summary, List<Chapter> chapters, List<Comments> comments,
			long creationDate, String bookCover, boolean isPublished, int actualRating, int possibleRating) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.summary = summary;
		this.chapters = chapters;
		this.comments = comments;
		this.creationDate = creationDate;
		this.bookCover = bookCover;
		this.isPublished = isPublished;
		this.actualRating = actualRating;
		this.possibleRating = possibleRating;
	}

	public Story() {
		super();
		// TODO Auto-generated constructor stub
	}
}
