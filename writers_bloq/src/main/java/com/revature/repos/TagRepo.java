package com.revature.repos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.models.Tag;

@Repository
public class TagRepo {

	@Autowired
	EntityManagerFactory emf;

	/**
	 * Get all tags in the database
	 * @return a list of tags from the database
	 */
	public List<Tag> getAllTags() {
		SessionFactory sf = emf.unwrap(SessionFactory.class);
		try(Session session = sf.openSession()) {
			List<?> allTags = session.createQuery("select t from Tag t").list();
			return (List<Tag>) allTags;
		}
	}
	
	/**
	 * Load story tags from the database.
	 * @param storyTags associated with a story
	 * @return the tags associated with a story using the tags from the database.
	 */
	public List<Tag> loadTags(List<Tag> storyTags) {
		SessionFactory sf = emf.unwrap(SessionFactory.class);
		try (Session session = sf.openSession()) {
			Transaction tx = session.beginTransaction();
			ArrayList<Tag> dbTags = new ArrayList<Tag>();

			// Get story tags from the database
			Tag foundTag = null;
			for (Tag tag : storyTags) {
				foundTag = (Tag) session.createQuery("select t from Tag t where t.name = :name")
						.setParameter("name", tag.getName()).uniqueResult();
				if (foundTag == null) {
					foundTag = tag;
					session.save(foundTag);
				}
				dbTags.add(foundTag);
			}
			tx.commit();
			return dbTags;
		}
	}
}
