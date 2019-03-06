package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Chapter;
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
	 * Get a specific chapter from a story
	 * @param chapterId of the chapter to get
	 * @return the specific chapter from the database
	 */
	@GetMapping(path = "/{chapterId}")
	public Chapter getChapterById(@PathVariable int chapterId) {
		return chapterServices.getChapterById(chapterId);
	}
	
	/**
	 * Updates a chapter.
	 * @param chapterId of the chapter to update
	 * @param chapter object holding the updated chapter
	 * @return the updated chapter
	 */
	@PutMapping(path = "/{chapterId}")
	public Chapter updateChapter(@PathVariable int chapterId, @RequestBody Chapter chapter) {
		return chapterServices.updateChapter(chapterId, chapter);
	}
}
