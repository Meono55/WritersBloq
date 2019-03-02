package com.revature.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.dto.CredentialsDTO;
import com.revature.models.Token;
import com.revature.models.User;
import com.revature.services.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
  
  // Get authService from Spring
  AuthService authService;
  @Autowired
	public AuthController(AuthService authService) {
    this.authService = authService;
  }

  
  /**
	 * Retrieve a user from the database based off the provided login credentials.
	 * 
	 * @param credentials The data transfer object containing the login
	 *                         information.
	 * @return The user account associated with the provided credentials. Null is
	 *         returned if no account could be found.
	 */
	@PostMapping(produces="application/json")
	public User login(HttpServletResponse res, @RequestBody CredentialsDTO credentials) {
	  Token token = this.authService.login(credentials);
	  Cookie cookie = new Cookie("p2-token", token.getValue());
	  res.addCookie(cookie);
	  return token.getUser();
	}
	
	/**
	 * Gets an authenticated user using the token value
	 * @param tokenValue
	 * @return the logged in user
	 */
	@GetMapping("")
	public User getLoggedInUser(@CookieValue(value="p2-token", required=false) String tokenValue) {
		return this.authService.getLoggedInUser(tokenValue);
	}
  
  /**
   * Handle any exceptions thrown in this controller
   * @param e the exception that was thrown
   * @return the response entity to Spring to build a response for the client
   */
  @ExceptionHandler
  public ResponseEntity<String> handleHttpClienException(HttpClientErrorException e) {
    return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
  }
}
