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
import com.revature.models.Content;
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
			
			// Save chapter to database
			chapter.setId((int) session.save(chapter));
			
			// Add chapter to story
			Story currentStory = session.get(Story.class, storyId);
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
			Hibernate.initialize(storyChapters);
			return storyChapters;
//			List<Chapter> chapters = new ArrayList<Chapter>();
//			
//			// Instantiate the return list to be the values of the list of proxies
//			for (Chapter c: storyChapters) {
//				chapters.add(c);
//			}
//			return chapters;
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
			Chapter currentChapter = session.get(Chapter.class, chapterId);
			
			// Update the chapter
			currentChapter.setPublished(chapter.isPublished());
			currentChapter.setTitle(chapter.getTitle());
			session.merge(currentChapter);
			tx.commit();
			return currentChapter;
		}
	}

	/**
	 * Adds a content object to the chapter of a story.
	 * @param id of the chapter to add the content to
	 * @param content to add to the chapter
	 * @return the new content that was added to the chapter
	 */
	public Content createContent(int id, Content content) {
		SessionFactory sf = emf.unwrap(SessionFactory.class);
		try(Session session = sf.openSession()) {
			Transaction tx = session.beginTransaction();
			
			// Save content to database
			content.setId((int) session.save(content));
			
			// Add content to chapter
			Chapter currentChapter = session.get(Chapter.class, id);
			currentChapter.getContent().add(content);
			session.merge(currentChapter);
			tx.commit();
		}
		return null;
	}

	/**
	 * Get all of a chapter's content from the database.
	 * @param id of the chapter to get the content from
	 * @return the list of a chapter's content
	 */
	public List<Content> getAllContent(int id) {
		SessionFactory sf = emf.unwrap(SessionFactory.class);
		try(Session session = sf.openSession()) {
			// Get the list of proxy content from the chapter
			List<Content> proxyContents = session.get(Chapter.class, id).getContent();
			Hibernate.initialize(proxyContents);
			return proxyContents;
//			List<Content> contents = new ArrayList<Content>();
//			
//			// Instantiate the proxies to get their values
//			for(Content c : proxyContents) {
//				contents.add(c);
//			}
//			return contents;
		}
	}

	/**
	 * Get specific content from a chapter.
	 * @param id of the content to get from the chapter
	 * @return the chapter associated with the contentId value
	 */
	public Content getContentById(int id) {
		SessionFactory sf = emf.unwrap(SessionFactory.class);
		try(Session session = sf.openSession()) {
			Content content = session.get(Content.class, id);
			Hibernate.initialize(content);
			return content;
		}
	}

	/**
	 * Update the values of the content of a chapter.
	 * @param id of the content to update
	 * @param updatedContent to replace the old content with
	 * @return the updated content
	 */
	public Content updateContent(int id, Content updatedContent) {
		SessionFactory sf = emf.unwrap(SessionFactory.class);
		try(Session session = sf.openSession()) {
			Transaction tx = session.beginTransaction();
			
			// Get the current content from the database
			Content currentContent = session.get(Content.class, id);
			
			// Update the current content
			currentContent.setContentType(updatedContent.getContentType());
			currentContent.setContentData(updatedContent.getContentData());
			session.merge(currentContent);
			tx.commit();
		}
		return updatedContent;
	}
}
