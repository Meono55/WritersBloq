package com.revature.models;

import java.time.LocalDateTime;

public class Story {
	private int id;
	private String title;
	private String authorId;
	private String summary;
	private LocalDateTime creationDate;
	private String bookCover;
	private boolean isPublished;

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

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authorId == null) ? 0 : authorId.hashCode());
		result = prime * result + ((bookCover == null) ? 0 : bookCover.hashCode());
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + id;
		result = prime * result + (isPublished ? 1231 : 1237);
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
		if (authorId == null) {
			if (other.authorId != null)
				return false;
		} else if (!authorId.equals(other.authorId))
			return false;
		if (bookCover == null) {
			if (other.bookCover != null)
				return false;
		} else if (!bookCover.equals(other.bookCover))
			return false;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (id != other.id)
			return false;
		if (isPublished != other.isPublished)
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
		return "Story [id=" + id + ", title=" + title + ", authorId=" + authorId + ", summary=" + summary
				+ ", creationDate=" + creationDate + ", bookCover=" + bookCover + ", isPublished=" + isPublished + "]";
	}

	public Story(int id, String title, String authorId, String summary, LocalDateTime creationDate, String bookCover,
			boolean isPublished) {
		super();
		this.id = id;
		this.title = title;
		this.authorId = authorId;
		this.summary = summary;
		this.creationDate = creationDate;
		this.bookCover = bookCover;
		this.isPublished = isPublished;
	}

	public Story() {
		super();
		// TODO Auto-generated constructor stub
	}

}
