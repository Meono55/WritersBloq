package com.revature.controllers;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Story;
import com.revature.services.StoryServices;

@RestController
@RequestMapping("/stories")
public class StoryController {

	StoryServices storyServices;

	/**
	 * Creates a new story and add it to the database.
	 * @param newStory to create and add to the database
	 * @param tokenValue that references the user authoring the story
	 * @return the story object that was created or null if the story could not be
	 *         added to the database
	 */
	@PostMapping(path = "", produces = "application/json")
	public Story createStory(@RequestBody Story newStory, @CookieValue(value = "p2-cookie", required = false) String tokenValue) {
		return storyServices.createStory(newStory, tokenValue);
	}
}
