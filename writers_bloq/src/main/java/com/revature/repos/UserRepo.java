package com.revature.repos;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.models.User;

@Repository
public class UserRepo {

  @Autowired
  EntityManagerFactory emf;
  
  /**
   * Query the database for a user with the given email
   * @param email to use to look for a user
   * @return user found or null if not found
   */
  public User getUserByEmail(String email) {
    SessionFactory sf = emf.unwrap(SessionFactory.class);
    try (Session session = sf.openSession()) {
      User user = (User) session.createQuery("select u from User u where u.email = :email")
                  .setParameter("email", email)
                  .uniqueResult();
      return user;
    }
  }
  
}
