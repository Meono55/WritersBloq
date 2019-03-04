package com.revature.models;

public class Content {
	private int id;
	
	// Chapter where content is found
	private int chapterId;
	
	// Chapter content information
	private String contentType;
	private String contentData;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getChapterId() {
		return chapterId;
	}

	public void setChapterId(int chapterId) {
		this.chapterId = chapterId;
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
		result = prime * result + chapterId;
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
		if (chapterId != other.chapterId)
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
		return "Content [id=" + id + ", chapterId=" + chapterId + ", contentType=" + contentType + ", contentData="
				+ contentData + "]";
	}

	public Content(int id, int chapterId, String contentType, String contentData) {
		super();
		this.id = id;
		this.chapterId = chapterId;
		this.contentType = contentType;
		this.contentData = contentData;
	}

	public Content() {
		super();
		// TODO Auto-generated constructor stub
	}
}
