package com.revature.models;

import java.time.LocalDateTime;

public class Comments {
	private int id;
	private int storyId;
	private int authorId;
	private String content;
	private LocalDateTime creationDate;
	private boolean isSpoiler;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStoryId() {
		return storyId;
	}

	public void setStoryId(int storyId) {
		this.storyId = storyId;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
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
		result = prime * result + authorId;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + id;
		result = prime * result + (isSpoiler ? 1231 : 1237);
		result = prime * result + storyId;
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
		if (authorId != other.authorId)
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (id != other.id)
			return false;
		if (isSpoiler != other.isSpoiler)
			return false;
		if (storyId != other.storyId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Comments [id=" + id + ", storyId=" + storyId + ", authorId=" + authorId + ", content=" + content
				+ ", creationDate=" + creationDate + ", isSpoiler=" + isSpoiler + "]";
	}

	public Comments(int id, int storyId, int authorId, String content, LocalDateTime creationDate, boolean isSpoiler) {
		super();
		this.id = id;
		this.storyId = storyId;
		this.authorId = authorId;
		this.content = content;
		this.creationDate = creationDate;
		this.isSpoiler = isSpoiler;
	}

	public Comments() {
		super();
		// TODO Auto-generated constructor stub
	}

}
