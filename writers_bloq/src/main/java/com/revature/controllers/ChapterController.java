package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Chapter;
import com.revature.models.Content;
import com.revature.services.ChapterServices;

@RestController
@RequestMapping("/chapters")
public class ChapterController {

	ChapterServices chapterServices;
	
	@Autowired
	ChapterController(ChapterServices chapterServices) {
		super();
		this.chapterServices = chapterServices;
	}
	
	/**
	 * Get a specific chapter from a story.
	 * @param chapterId of the chapter to get
	 * @return the specific chapter from the database
	 */
	@GetMapping(path = "/{chapterId}", produces = "application/json")
	public Chapter getChapterById(@PathVariable int chapterId) {
		return chapterServices.getChapterById(chapterId);
	}
	
	/**
	 * Updates a chapter.
	 * @param chapterId of the chapter to update
	 * @param chapter object holding the updated chapter
	 * @return the updated chapter
	 */
	@PutMapping(path = "/{chapterId}", produces = "application/json")
	public Chapter updateChapter(@PathVariable int chapterId, @RequestBody Chapter chapter) {
		return chapterServices.updateChapter(chapterId, chapter);
	}
	
	/**
	 * Adds a content object to the chapter of a story.
	 * @param id of the chapter to add the content to
	 * @param content to add to the chapter
	 * @return the new content that was added to the chapter
	 */
	@PostMapping(path = "/{id}/contents", produces = "application/json")
	public Content createContent(@PathVariable int id, @RequestBody Content content) {
		return chapterServices.createContent(id, content);
	}
	
	/**
	 * Get all of a chapter's content from the database.
	 * @param id of the chapter to get the content from
	 * @return the list of a chapter's content
	 */
	@GetMapping(path = "/{id}/contents", produces = "application/json")
	public List<Content> getAllContent(@PathVariable int id) {
		return chapterServices.getAllContent(id);
	}
	
	/**
	 * Get specific content from a chapter.
	 * @param id of the content to get from the chapter
	 * @return the chapter associated with the contentId value
	 */
	@GetMapping(path = "/contents/{id}", produces = "application/json")
	public Content getContentById(@PathVariable int id) {
		return chapterServices.getContentById(id);
	}
	
	/**
	 * Update the values of the content of a chapter.
	 * @param id of the content to update
	 * @param updatedContent to replace the old content with
	 * @return the updated content
	 */
	@PutMapping(path = "/contents/{id}", produces = "application/json")
	public Content updateContent(@PathVariable int id, @RequestBody Content updatedContent) {
		return chapterServices.updateContent(id, updatedContent);
	}
}
