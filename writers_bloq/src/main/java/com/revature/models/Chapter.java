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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "chapters")
public class Chapter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	// Chapter story information
	private String title;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="chapter_id")
	private List<Content> content;

	// Chapter publishing details
	@Column(name = "creation_date")
	private long creationDate;

	@Column(name = "is_published")
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

	public List<Content> getContent() {
		return content;
	}

	public void setContent(List<Content> content) {
		this.content = content;
	}

	public long getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(long creationDate) {
		this.creationDate = creationDate;
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
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + (int) (creationDate ^ (creationDate >>> 32));
		result = prime * result + id;
		result = prime * result + (isPublished ? 1231 : 1237);
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
		Chapter other = (Chapter) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (creationDate != other.creationDate)
			return false;
		if (id != other.id)
			return false;
		if (isPublished != other.isPublished)
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
		return "Chapter [id=" + id + ", title=" + title + ", content=" + content + ", creationDate=" + creationDate
				+ ", isPublished=" + isPublished + "]";
	}

	public Chapter(int id, String title, List<Content> content, long creationDate, boolean isPublished) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.creationDate = creationDate;
		this.isPublished = isPublished;
	}

	public Chapter() {
		super();
		// TODO Auto-generated constructor stub
	}

}
