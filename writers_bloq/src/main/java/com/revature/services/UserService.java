package com.revature.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Token;
import com.revature.models.User;
import com.revature.repos.AuthRepo;
import com.revature.repos.UserRepo;

@Service
public class UserService {

  AuthRepo authRepo;
  UserRepo userRepo;

  @Autowired
  public UserService(AuthRepo authRepo, UserRepo userRepo) {
    this.authRepo = authRepo;
    this.userRepo = userRepo;
  }

  /**
   * Validates user input, creates a new user in the database using the UserRepo,
   * and generates a token for the user to represent that they are logged in
   * @param user to be created in the database
   * @return the token to represent the user is logged in
   */
  public Token register(User user) {
    // Validate user and protect the password
    user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
    
    // Save the user and generate a token for the user
    user = this.userRepo.saveUser(user);
    return this.authRepo.generateToken(user);
  }

}
