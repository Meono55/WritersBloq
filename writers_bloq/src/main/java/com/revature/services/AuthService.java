package com.revature.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.dto.CredentialsDTO;
import com.revature.models.Token;
import com.revature.models.User;
import com.revature.repos.AuthRepo;
import com.revature.repos.UserRepo;

@Service
public class AuthService {

  AuthRepo authRepo;
  UserRepo userRepo;

  @Autowired
  public AuthService(AuthRepo authRepo, UserRepo userRepo) {
    this.authRepo = authRepo;
    this.userRepo = userRepo;
  }

  /**
   * Gets an existing user and checks if the credentials are correct then creates
   * a token and attaches the user to the token to remember them later
   * @param credentials contains email and password representing login information
   * @return token to represent user
   */
  public Token login(CredentialsDTO credentials) {
    User user = this.userRepo.getUserByEmail(credentials.getEmail());
    // If credentials are invalid, throw an exception
    if (user == null || !BCrypt.checkpw(credentials.getPassword(), user.getPassword())) {
      throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED, "Invalid login credentials");
    }
    // Create and save a new token
    Token token = new Token(this.authRepo.createNewToken(), user);
    return this.authRepo.saveToken(token);
  }
  
  
  public User getLoggedInUser(String tokenValue) {
    Token token = this.authRepo.getToken(tokenValue);
    if (token == null) throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED, "Please login");
    return token.getUser();
  }

}
