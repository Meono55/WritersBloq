package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Chapter;
import com.revature.models.Content;
import com.revature.repos.ChapterRepo;
import com.revature.repos.StoryRepo;

@Service
public class ChapterServices {
	StoryRepo storyRepo;
	ChapterRepo chapterRepo;
	
	@Autowired
	public ChapterServices(StoryRepo storyRepo, ChapterRepo chapterRepo) {
		this.storyRepo = storyRepo;
		this.chapterRepo = chapterRepo;
	}
	
	/**
	 * Updates the stories list of chapters
	 * @param chapter to add to the story
	 * @param storyId of story to save to
	 * @return chapter that was added to the story
	 */
	public Chapter createChapter(Chapter chapter, int storyId) {
		// Initialize auto generated values
		chapter.setCreationDate(System.currentTimeMillis());
		chapter.setPublished(false);
		
		// Add new chapter to story
		chapterRepo.createChapter(chapter, storyId);
		return chapter;
	}

	/**
	 * Gets all chapters of the story
	 * @param id of the story
	 * @return all chapters belonging to the story
	 */
	public List<Chapter> getAllChapters(int id) {
		return chapterRepo.getAllChapters(id);
	}

	/**
	 * Get a specific chapter from a story
	 * @param chapterId of the chapter to get
	 * @return the specific chapter from the database
	 */
	public Chapter getChapterById(int chapterId) {
		return chapterRepo.getChapterById(chapterId);
	}

	/**
	 * Updates a chapter.
	 * @param chapterId of the chapter to update
	 * @param chapter object holding the updated chapter
	 * @return the updated chapter
	 */
	public Chapter updateChapter(int chapterId, Chapter chapter) {
		return chapterRepo.updateChapter(chapterId, chapter);
	}

	/**
	 * Adds a content object to the chapter of a story.
	 * @param id of the chapter to add the content to
	 * @param content to add to the chapter
	 * @return the new content that was added to the chapter
	 */
	public Content createContent(int id, Content content) {
		return chapterRepo.createContent(id, content);
	}

	/**
	 * Get all of a chapter's content from the database.
	 * @param id of the chapter to get the content from
	 * @return the list of a chapter's content
	 */
	public List<Content> getAllContent(int id) {
		return chapterRepo.getAllContent(id);
	}

	/**
	 * Get specific content from a chapter.
	 * @param id of the content to get from the chapter
	 * @return the chapter associated with the contentId value
	 */
	public Content getContentById(int id) {
		return chapterRepo.getContentById(id);
	}

	/**
	 * Update the values of the content of a chapter.
	 * @param id of the content to update
	 * @param updatedContent to replace the old content with
	 * @return the updated content
	 */
	public Content updateContent(int id, Content updatedContent) {
		return chapterRepo.updateContent(id, updatedContent);
	}
}
