package com.revature.repos;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.models.Token;

@Repository
public class AuthRepo {

  @Autowired
  EntityManagerFactory emf;

  /**
   * Checks the database to see if a given token already exists.
   * @param tokenValue to be checked
   * @return true if token is found, and false if not
   */
  public boolean tokenExists(String tokenValue) {
    SessionFactory sf = emf.unwrap(SessionFactory.class);
    try (Session session = sf.openSession()) {
      Token found = session.get(Token.class, tokenValue);
      return found != null;
    }
  }

  /**
   * Saves a newly created token to the database
   * @param token to be saved
   */
  public void saveToken(Token token) {
    SessionFactory sf = emf.unwrap(SessionFactory.class);
    try (Session session = sf.openSession()) {
      session.save(token);
    }
  }

}
