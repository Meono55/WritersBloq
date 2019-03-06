package com.revature.repos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.models.Chapter;
import com.revature.models.Story;

@Repository
public class ChapterRepo {

	@Autowired
	EntityManagerFactory emf;
	
	/**
	 * Saves chapter to database and adds chapter to story
	 * @param chapter to be saved to the database
	 * @param storyId the story which receives the chapter
	 * @return the chapter that was saved in the database
	 */
	public Chapter createChapter(Chapter chapter, int storyId) {
		SessionFactory sf = emf.unwrap(SessionFactory.class);
		try (Session session = sf.openSession()) {
			Transaction tx = session.beginTransaction();
			Story currentStory = session.get(Story.class, storyId);
			chapter.setId((int) session.save(chapter));
			currentStory.getChapters().add(chapter);
			session.merge(currentStory);
			tx.commit();
		}
		return chapter;
	}
	
	/**
	 * Gets all chapters of a story
	 * @param id the specified story
	 * @return all the chapters belonging to that story
	 */
	public List<Chapter> getAllChapters(int id) {
		SessionFactory sf = emf.unwrap(SessionFactory.class);
		try (Session session = sf.openSession()) {
			
			// Get a list of proxies of the story's chapters
			List<Chapter> storyChapters = session.get(Story.class, id).getChapters();
			List<Chapter> chapters = new ArrayList<Chapter>();
			
			// Instantiate the return list to be the values of the list of proxies
			for (Chapter c: storyChapters) {
				chapters.add(c);
			}
			return chapters;
		}
	}

	/**
	 * Get a specific chapter from a story
	 * @param chapterId of the chapter to get
	 * @return the specific chapter from the database
	 */
	public Chapter getChapterById(int chapterId) {
		SessionFactory sf = emf.unwrap(SessionFactory.class);
		try (Session session = sf.openSession()) {
			Chapter chapter = session.get(Chapter.class, chapterId);
			Hibernate.initialize(chapter);
			return chapter;
		}
	}

	/**
	 * Updates a chapter.
	 * @param chapterId of the chapter to update
	 * @param chapter object holding the updated chapter
	 * @return the updated chapter
	 */
	public Chapter updateChapter(int chapterId, Chapter chapter) {
		SessionFactory sf = emf.unwrap(SessionFactory.class);
		try (Session session = sf.openSession()) {
			Transaction tx = session.beginTransaction();
			Chapter currentStory = session.get(Chapter.class, chapterId);
			
			// Update the chapter
			currentStory.setPublished(chapter.isPublished());
			currentStory.setTitle(chapter.getTitle());
			session.merge(currentStory);
			tx.commit();
			return currentStory;
		}
	}
	
	
}
