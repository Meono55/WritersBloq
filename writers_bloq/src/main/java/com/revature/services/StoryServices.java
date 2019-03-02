package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.models.Story;
import com.revature.models.Token;
import com.revature.repos.AuthRepo;
import com.revature.repos.StoryRepo;

@Service
public class StoryServices {
	StoryRepo storyRepo;
	AuthRepo authRepo;

	@Autowired
	public StoryServices(StoryRepo storyRepo) {
		super();
		this.storyRepo = storyRepo;
	}

	/**
	 * Validate user input, creates a new story in the database using the StoryRepo.
	 * @param newStory to be added to the database
	 * @param tokenValue that references the author of the story
	 * @return the story that was added to the database or null if the story could
	 *         not be added to the database
	 */
	public Story createStory(Story newStory, String tokenValue) {
		// Validate story
		Token token = authRepo.getToken(tokenValue);
		if(token == null) {
			throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED, "Please log into your account");
		}
		
		// Initialize auto-generated values
		newStory.setCreationDate(System.currentTimeMillis());
		newStory.setAuthor(token.getUser());

		// Save story to database
		return storyRepo.saveStory(newStory);
	}
}
