package com.revature.repos;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.models.Token;
import com.revature.models.User;

@Repository
public class AuthRepo {

  @Autowired
  EntityManagerFactory emf;
  
  /**
   * Generate a new token value for a user while removing previously assigned tokens from the user
   * @param user to generate a token for
   * @return the generated token to be given to the client
   */
  public Token generateToken(User user) {
    Long random;
    String tokenValue;
    Token found;
    
    SessionFactory sf = emf.unwrap(SessionFactory.class);
    try (Session session = sf.openSession()) {
      Transaction tx = session.beginTransaction();
      
      // Check if user already has a token and delete it
      if (user.getToken() != null) user.setToken(null);
      
      // Create a unique token value
      do {
        random = (long) (Math.random() * Long.MAX_VALUE);
        tokenValue = random.toString();
        found = session.get(Token.class, tokenValue);
      } while (found != null);
      
      // Assign token value to user and save updates
      user.setToken(new Token(tokenValue, user));
      session.merge(user);
      
      tx.commit();
      return user.getToken();
    }
  }
  
  
  /**
   * Finds and deletes an existing token
   * @param tokenValue
   */
  public void deleteToken(String tokenValue) {
    SessionFactory sf = emf.unwrap(SessionFactory.class);
    try (Session session = sf.openSession()) {
      Token token = session.get(Token.class, tokenValue);
      session.delete(token);
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
      if (tokenValue == null) return null;
      return session.get(Token.class, tokenValue);
    }
  }

}
