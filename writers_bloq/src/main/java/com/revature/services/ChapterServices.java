package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Chapter;
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
}
