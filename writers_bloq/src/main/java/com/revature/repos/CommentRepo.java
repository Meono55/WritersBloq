package com.revature.repos;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.models.Comments;
import com.revature.models.Story;

@Repository
public class CommentRepo {

	@Autowired
	EntityManagerFactory emf;

	/**
	 * Create a new comment about a story.
	 * @param id of the story to comment on
	 * @param newComment to be added to the story
	 * @return the comment about the story
	 */
	public Comments createComment(int id, Comments newComment) {
		SessionFactory sf = emf.unwrap(SessionFactory.class);
		try(Session session = sf.openSession()) {
			Transaction tx = session.beginTransaction();
			
			// Save comment to database
			newComment.setId((int) session.save(newComment));
			
			// Add new comment
			Story story = session.get(Story.class, id);
			story.getComments().add(newComment);
			session.merge(story);
			tx.commit();
			
			return newComment;
		}
	}

	/**
	 * Get all comments associated with the story.
	 * @param id of the story to get the comments from
	 * @return the list of comments of the story
	 */
	public List<Comments> getComments(int id) {
		SessionFactory sf = emf.unwrap(SessionFactory.class);
		try(Session session = sf.openSession()) {
			List<Comments> comments = session.get(Story.class, id).getComments();
			Hibernate.initialize(comments);
			return comments;
		}
	}
}
