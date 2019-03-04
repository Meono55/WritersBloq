package com.revature.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PageDTO<T> {
	private List<T> stories;
	private int curPage;
	private int resultCount;

	@JsonIgnore
	private int pageSize = 10;

	public List<T> getStories() {
		return stories;
	}

	public void setStories(List<T> stories) {
		this.stories = stories;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getResultCount() {
		return resultCount;
	}

	public void setResultCount(int resultCount) {
		this.resultCount = resultCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + curPage;
		result = prime * result + pageSize;
		result = prime * result + resultCount;
		result = prime * result + ((stories == null) ? 0 : stories.hashCode());
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
		PageDTO other = (PageDTO) obj;
		if (curPage != other.curPage)
			return false;
		if (pageSize != other.pageSize)
			return false;
		if (resultCount != other.resultCount)
			return false;
		if (stories == null) {
			if (other.stories != null)
				return false;
		} else if (!stories.equals(other.stories))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PageDTO [stories=" + stories + ", curPage=" + curPage + ", resultCount=" + resultCount + ", pageSize="
				+ pageSize + "]";
	}

	public PageDTO(List<T> stories, int curPage, int resultCount, int pageSize) {
		super();
		this.stories = stories;
		this.curPage = curPage;
		this.resultCount = resultCount;
		this.pageSize = pageSize;
	}

	public PageDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
}
