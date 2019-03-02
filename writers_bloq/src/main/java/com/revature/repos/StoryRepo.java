package com.revature.repos;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
		return newStory;
	}
	
	/**
	 * This merges the updated story to the database. 
	 * @param currStory is the updated story to merge.
	 * @return the story that was merged into the database
	 */
	public Story editStory(Story currStory) {
		SessionFactory sf = emf.unwrap(SessionFactory.class);
		try(Session session = sf.openSession()){
			Transaction tx = session.beginTransaction();
			Story updatedStory =  (Story) session.merge(currStory);
			tx.commit();
			return updatedStory;
		}
		
	}

	/**
	 * Retrieves a story from the database using an id.
	 * @param id of the story to retrieve.
	 * @return the story retrieved from the database. 
	 */
	public Story getStoryById(int id) {
		SessionFactory sf = emf.unwrap(SessionFactory.class);
		try(Session session = sf.openSession()){
			return session.get(Story.class, id);
		}

	}
}
