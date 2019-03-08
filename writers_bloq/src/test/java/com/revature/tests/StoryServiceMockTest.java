package com.revature.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.models.Story;
import com.revature.repos.AuthRepo;
import com.revature.repos.StoryRepo;
import com.revature.repos.TagRepo;
import com.revature.services.StoryServices;

@RunWith(MockitoJUnitRunner.class)
public class StoryServiceMockTest {

	@Mock
	StoryRepo mockStoryRepo;

	@Mock
	AuthRepo mockAuthRepo;

	@Mock
	TagRepo mockTagRepo;

	@InjectMocks
	StoryServices storyService;

	@Test
	public void getStoryByIdTest() {
		int id = 5;
		Story expectedStory = new Story();
		expectedStory.setId(id);

		when(mockStoryRepo.getStoryById(id)).thenReturn(expectedStory);

		assertEquals(expectedStory, storyService.getStoryById(id));
	}

	@Test
	public void getStoryByIdNotValidTest() {
		int id = 5;

		when(mockStoryRepo.getStoryById(id)).thenReturn(null);
		try {
			Story story = storyService.getStoryById(id);
			fail();
		} catch (HttpClientErrorException e) {
			assertThat("Client Error is 404", e.getStatusCode(), is(HttpStatus.NOT_FOUND));
		}

	}

	@Test
	public void editStoryTest() {
		Story updatedStory = new Story();
		updatedStory.setActualRating(0);
		updatedStory.setId(5);
		updatedStory.setPossibleRating(0);
		updatedStory.setPublished(false);
		updatedStory.setBookCover(null);
		updatedStory.setTitle("Star Wars 2");
		updatedStory.setSummary("This is a starwars book");
		updatedStory.setCreationDate(System.currentTimeMillis());
		updatedStory.setModifiedDate(null);

		Story currStory = updatedStory;
		currStory.setModifiedDate(System.currentTimeMillis());
		currStory.setTitle("Star Wars 3");
		currStory.setSummary("This is another starwars book!");

		when(mockStoryRepo.getStoryById(updatedStory.getId())).thenReturn(currStory);
		when(mockStoryRepo.editStory(currStory)).thenReturn(currStory);

		assertEquals(currStory, storyService.editStory(updatedStory));

	}

//	@Test
//	public void createStoryTest() {
//		Story story = new Story();
//		story.setActualRating(0);
//		story.setId(5);
//		story.setPossibleRating(0);
//		story.setPublished(false);
//		story.setBookCover(null);
//		story.setTitle("Star Wars 2");
//		story.setSummary("This is a starwars book");
//		story.setCreationDate(System.currentTimeMillis());
//		story.setModifiedDate(null);
//
//		User user = new User();
//
//		Token token = new Token();
//		token.setUser(user);
//		token.setValue("123213123123123");
//
//		when(mockAuthRepo.getToken(token.getValue())).thenReturn(token);
//		when(mockTagRepo.loadTags(storyTags))
//		when(mockStoryRepo.saveStory(story)).thenReturn(story);
//
//		assertEquals(story, storyService.createStory(story, token.getValue()));
//
//	}

}
