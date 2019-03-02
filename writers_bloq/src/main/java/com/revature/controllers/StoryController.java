package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	 * @param newStory to create and add to the database
	 * @param tokenValue that references the user authoring the story
	 * @return the story object that was created or null if the story could not be
	 *         added to the database
	 */
	@PostMapping(path = "", produces = "application/json")
	public Story createStory(@RequestBody Story newStory, @CookieValue(value = "p2-token", required = false) String tokenValue) {
		return storyServices.createStory(newStory, tokenValue);
	}
	
	/**
	 * Edits a current story and updates it to the database.
	 * 
	 * @param currStory holding the updated story contents to load to the database
	 * @return the updated story
	 */
	@PutMapping(path="", produces = "application/json")
	public Story editStory(@RequestBody Story currStory) {
		return storyServices.editStory(currStory);
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(path="/{id}", produces = "application/json")
	public Story getStoryById(@PathVariable int id) {
		return storyServices.getStoryById(id);
	}
	
}
