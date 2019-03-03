package com.revature.models;

import java.time.LocalDateTime;

public class Comments {
	private int id;

	// Author of content
	private User author;

	// Comment information
	private Story story;
	private String content;
	private long creationDate;
	private boolean isSpoiler;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Story getStory() {
		return story;
	}

	public void setStory(Story story) {
		this.story = story;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(long creationDate) {
		this.creationDate = creationDate;
	}

	public boolean isSpoiler() {
		return isSpoiler;
	}

	public void setSpoiler(boolean isSpoiler) {
		this.isSpoiler = isSpoiler;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + (int) (creationDate ^ (creationDate >>> 32));
		result = prime * result + id;
		result = prime * result + (isSpoiler ? 1231 : 1237);
		result = prime * result + ((story == null) ? 0 : story.hashCode());
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
		Comments other = (Comments) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (creationDate != other.creationDate)
			return false;
		if (id != other.id)
			return false;
		if (isSpoiler != other.isSpoiler)
			return false;
		if (story == null) {
			if (other.story != null)
				return false;
		} else if (!story.equals(other.story))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Comments [id=" + id + ", author=" + author + ", story=" + story + ", content=" + content
				+ ", creationDate=" + creationDate + ", isSpoiler=" + isSpoiler + "]";
	}

	public Comments(int id, User author, Story story, String content, long creationDate, boolean isSpoiler) {
		super();
		this.id = id;
		this.author = author;
		this.story = story;
		this.content = content;
		this.creationDate = creationDate;
		this.isSpoiler = isSpoiler;
	}

	public Comments() {
		super();
		// TODO Auto-generated constructor stub
	}
}
