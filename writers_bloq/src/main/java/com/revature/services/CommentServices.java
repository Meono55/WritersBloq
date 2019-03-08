package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.models.Comments;
import com.revature.models.Token;
import com.revature.repos.AuthRepo;
import com.revature.repos.CommentRepo;

@Service
public class CommentServices {

	CommentRepo commentRepo;
	AuthRepo authRepo;
	
	@Autowired
	public CommentServices(CommentRepo commentRepo, AuthRepo authRepo) {
		this.commentRepo = commentRepo;
		this.authRepo = authRepo;
	}

	/**
	 * Create a new comment about a story.
	 * @param id of the story to comment on
	 * @param newComment to be added to the story
	 * @param tokenValue that references the user authoring the comment
	 * @return the comment about the story
	 */
	public Comments createComment(int id, Comments newComment, String tokenValue) {
		// Validate author
		Token token = authRepo.getToken(tokenValue);
		if(token == null) {
			throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED, "Please log into your account");
		}
		
		// Initialize auto-generated values
		newComment.setAuthor(token.getUser());
		newComment.setCreationDate(System.currentTimeMillis());
		newComment.setSpoiler(true);
		
		// Add comment to story
		return commentRepo.createComment(id, newComment);
	}

	/**
	 * Get all comments associated with the story.
	 * @param id of the story to get the comments from
	 * @return the list of comments of the story
	 */
	public List<Comments> getComments(int id) {
		return commentRepo.getComments(id);
	}
}
