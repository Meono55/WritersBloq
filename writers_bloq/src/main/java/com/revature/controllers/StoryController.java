package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dto.PageDTO;
import com.revature.models.Story;
import com.revature.services.StoryServices;

@RestController
@RequestMapping("/stories")
public class StoryController {

	StoryServices storyServices;

	@Autowired
	public StoryController(StoryServices storyServices) {
		super();
		this.storyServices = storyServices;
	}

	/**
	 * Creates a new story and add it to the database.
	 * @param newStory   to create and add to the database
	 * @param tokenValue that references the user authoring the story
	 * @return the story object that was created or null if the story could not be
	 *         added to the database
	 */
	@PostMapping(path = "", produces = "application/json")
	public Story createStory(@RequestBody Story newStory,
			@CookieValue(value = "p2-token", required = false) String tokenValue) {
		return storyServices.createStory(newStory, tokenValue);
	}

	/**
	 * Edits a current story and updates it to the database.
	 * @param currStory holding the updated story contents to load to the database
	 * @return the updated story
	 */
	@PutMapping(path = "", produces = "application/json")
	public Story editStory(@RequestBody Story currStory) {
		return storyServices.editStory(currStory);
	}

	/**
	 * Retrieve a story from the database using an id.
	 * @param id of the story to retrieve
	 * @return the story with the given id from the database
	 */
	@GetMapping(path = "/{id}", produces = "application/json")
	public Story getStoryById(@PathVariable int id) {
		return storyServices.getStoryById(id);
	}

	/**
	 * Retrieve a page of stories from the database based on a given filter.
	 * @param query to filter the stories by
	 * @param genre to filter the stories by
	 * @param tag   to filter the stories by
	 * @return the page object of the filtered stories
	 */
	@GetMapping(params = { "query", "genre", "tag", "page" }, produces = "application/json")
	public PageDTO<Story> filterStories(@RequestParam("query") String query, @RequestParam("genre") String genre,
			@RequestParam("tag") String tag, @RequestParam("page") String page) {
		PageDTO pageDTO = new PageDTO();
		pageDTO.setCurPage(Integer.parseInt(page));
		return storyServices.filterStories(query, genre, tag, pageDTO);
	}
}
