package com.revature.models;

public class Content {
	private int id;

	// Chapter where content is found
	private Chapter chapter;

	// Chapter content information
	private String contentType;
	private String contentData;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Chapter getChapter() {
		return chapter;
	}

	public void setChapter(Chapter chapter) {
		this.chapter = chapter;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getContentData() {
		return contentData;
	}

	public void setContentData(String contentData) {
		this.contentData = contentData;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chapter == null) ? 0 : chapter.hashCode());
		result = prime * result + ((contentData == null) ? 0 : contentData.hashCode());
		result = prime * result + ((contentType == null) ? 0 : contentType.hashCode());
		result = prime * result + id;
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
		Content other = (Content) obj;
		if (chapter == null) {
			if (other.chapter != null)
				return false;
		} else if (!chapter.equals(other.chapter))
			return false;
		if (contentData == null) {
			if (other.contentData != null)
				return false;
		} else if (!contentData.equals(other.contentData))
			return false;
		if (contentType == null) {
			if (other.contentType != null)
				return false;
		} else if (!contentType.equals(other.contentType))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Content [id=" + id + ", chapter=" + chapter + ", contentType=" + contentType + ", contentData="
				+ contentData + "]";
	}

	public Content(int id, Chapter chapter, String contentType, String contentData) {
		super();
		this.id = id;
		this.chapter = chapter;
		this.contentType = contentType;
		this.contentData = contentData;
	}

	public Content() {
		super();
		// TODO Auto-generated constructor stub
	}
}
