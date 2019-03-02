package com.revature.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.models.Token;
import com.revature.models.User;
import com.revature.services.UserService;

@CrossOrigin(
    methods = { RequestMethod.GET, RequestMethod.POST }
    )
@RestController
@RequestMapping("users")
public class UserController {
  
  UserService userService;
  
  @Autowired
	public UserController(UserService userService) {
    this.userService = userService;
  }

  /**
	 * Adds a new user to the database.
	 * 
	 * @param user The information of the user to add to the database.
	 * @return The user that was added to the database. Null is returned if the user
	 *         was not added to the database.
	 */
	@PostMapping(path="", produces="application/json")
	public User register(HttpServletResponse res, @RequestBody User user) {
	  Token token = this.userService.register(user);
	  Cookie cookie = new Cookie("p2-token", token.getValue());
	  res.addCookie(cookie);
	  token.getUser().setPassword("");
	  return token.getUser();
	}

	/**
	 * Retrieves a user from the database.
	 * 
	 * @param idValue The id of the user to retrieve from the database.
	 * @return The user associated with the provided id number. Null is returned if
	 *         the user could not be found or not be retrieved in the database.
	 */
	@GetMapping(path = "/{id}", produces = "application/json")
	public User getUser(@PathVariable int id) {
		return null;
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
