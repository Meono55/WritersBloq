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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
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

	@Lob
	@Column
	private String summary;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="story_id") // Watch out here
	private List<Chapter> chapters;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "story_id")
	private List<Comments> comments;

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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + actualRating;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((bookCover == null) ? 0 : bookCover.hashCode());
		result = prime * result + ((chapters == null) ? 0 : chapters.hashCode());
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + id;
		result = prime * result + (isPublished ? 1231 : 1237);
		result = prime * result + ((modifiedDate == null) ? 0 : modifiedDate.hashCode());
		result = prime * result + possibleRating;
		result = prime * result + ((summary == null) ? 0 : summary.hashCode());
		result = prime * result + ((tags == null) ? 0 : tags.hashCode());
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
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (id != other.id)
			return false;
		if (isPublished != other.isPublished)
			return false;
		if (modifiedDate == null) {
			if (other.modifiedDate != null)
				return false;
		} else if (!modifiedDate.equals(other.modifiedDate))
			return false;
		if (possibleRating != other.possibleRating)
			return false;
		if (summary == null) {
			if (other.summary != null)
				return false;
		} else if (!summary.equals(other.summary))
			return false;
		if (tags == null) {
			if (other.tags != null)
				return false;
		} else if (!tags.equals(other.tags))
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
				+ chapters + ", comments=" + comments + ", tags=" + tags + ", genre=" + genre + ", creationDate="
				+ creationDate + ", bookCover=" + bookCover + ", isPublished=" + isPublished + ", actualRating="
				+ actualRating + ", possibleRating=" + possibleRating + ", modifiedDate=" + modifiedDate + "]";
	}

	public Story(int id, String title, User author, String summary, List<Chapter> chapters, List<Comments> comments,
			List<Tag> tags, String genre, Long creationDate, String bookCover, boolean isPublished, int actualRating,
			int possibleRating, Long modifiedDate) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.summary = summary;
		this.chapters = chapters;
		this.comments = comments;
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
