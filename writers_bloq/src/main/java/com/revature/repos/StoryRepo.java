package com.revature.repos;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.models.Story;

@Repository
public class StoryRepo {

	@Autowired
	EntityManagerFactory emf;

	/**
	 * Creates id for story and saves the story to the database.
	 * @param newStory to save to the database
	 * @return the story that was saved to the database, or null if the story could
	 *         not be added to the database
	 */
	public Story saveStory(Story newStory) {
		SessionFactory sf = emf.unwrap(SessionFactory.class);
		try (Session session = sf.openSession()) {
			int id = (int) session.save(newStory);
			newStory.setId(id);
		}
		return null;
	}
}
