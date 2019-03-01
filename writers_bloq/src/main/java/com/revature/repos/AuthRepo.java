package com.revature.repos;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.models.Token;

@Repository
public class AuthRepo {

  @Autowired
  EntityManagerFactory emf;

  /**
   * Creates a token and checks if the database already includes the token
   * @return the token if it is unique else get a different token until its unique
   */
  public String createNewToken() {
    Long random;
    String tokenValue;
    Token found;
 
    SessionFactory sf = emf.unwrap(SessionFactory.class);
    try (Session session = sf.openSession()) {
      // Create a token and see if it already exists
      do {
        random = (long) (Math.random() * Long.MAX_VALUE);
        tokenValue = random.toString();
        found = session.get(Token.class, tokenValue);
      } while (found != null);
      
      // Return the unique token
      return tokenValue;
    }
  }

  /**
   * Saves a newly created token to the database
   * @param token to be saved
   * @return token that was saved
   */
  public Token saveToken(Token token) {
    SessionFactory sf = emf.unwrap(SessionFactory.class);
    try (Session session = sf.openSession()) {
      Transaction tx = session.beginTransaction();
      session.save(token);
      tx.commit();
      return token;
    }
  }
  
  /**
   * Gets a token in from the database
   * @param tokenValue from a client
   * @return the token if its found, null if its not
   */
  public Token getToken(String tokenValue) {
    SessionFactory sf = emf.unwrap(SessionFactory.class);
    try (Session session = sf.openSession()) {
      return session.get(Token.class, tokenValue);
    }
  }

}
