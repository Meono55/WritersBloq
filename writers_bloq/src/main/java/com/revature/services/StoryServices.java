package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.dto.PageDTO;
import com.revature.models.Story;
import com.revature.models.Token;
import com.revature.repos.AuthRepo;
import com.revature.repos.StoryRepo;
import com.revature.repos.TagRepo;

@Service
public class StoryServices {
	StoryRepo storyRepo;
	AuthRepo authRepo;
	TagRepo tagRepo;


	@Autowired
	public StoryServices(StoryRepo storyRepo, AuthRepo authRepo, TagRepo tagRepo) {
		super();
		this.storyRepo = storyRepo;
		this.authRepo = authRepo;
		this.tagRepo = tagRepo;
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
		newStory.setModifiedDate(System.currentTimeMillis());
		newStory.setAuthor(token.getUser());
		
		// Load the tags from the database
		newStory.setTags(tagRepo.loadTags(newStory.getTags()));

		// Save story to database
		return storyRepo.saveStory(newStory);
	}
	
	/**
	 * Changed the appropriate story values on the database to match the updated story values provided. 
	 * @param updatedStory object containing the updated story values.
	 * @return the updated story object
	 */
	public Story editStory(Story updatedStory) {
		Story currStory = getStoryById(updatedStory.getId());
		currStory.setModifiedDate(System.currentTimeMillis());
		currStory.setTitle(updatedStory.getTitle());
		currStory.setSummary(updatedStory.getSummary());
		
		return storyRepo.editStory(currStory);
	}
	
	/**
	 * Retrieves the story from the database using a provided id.
	 * @param id of the story in the database
	 * @return the story object of the retrieved story.
	 */
	public Story getStoryById(int id) {
		Story story = storyRepo.getStoryById(id);
		
		if(story == null) {
			throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Story not Found!");
		}
		else return story;
		
	}

	/**
	 * Get a page of stories from the database where the stories satisfy a given filter.
	 * @param query to filter the stories by
	 * @param genre to filter the stories by
	 * @param tag to filter the stories by
	 * @return the page of filtered story
	 */
	public PageDTO<Story> filterStories(String query, String genre, String tag, PageDTO<Story> pageInfo) {
		// Get stories by search query
		if(query != null) {
			return storyRepo.filterStoriesByQuery(query, pageInfo);
		}
		// Get stories by genre
		else if (genre != null) {
			return storyRepo.filterStoriesByGenre(genre, pageInfo);
		}
		// Get stories by tag
		else if (tag != null) {
			return storyRepo.filterStoriesByTag(tag, pageInfo);
		}
		// Get all stories
		else {
			return storyRepo.getAllStories(pageInfo);
		}
	}
}
