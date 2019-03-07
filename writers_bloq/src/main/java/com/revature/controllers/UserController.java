package com.revature.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.models.Token;
import com.revature.models.User;
import com.revature.services.UserService;

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
   * Handle any client exceptions thrown from this controller
   * @param e the exception that was thrown
   * @return the response entity to Spring to build a response for the client
   */
  @ExceptionHandler
  public ResponseEntity<String> handleHttpClienException(HttpClientErrorException e) {
    return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
  }
  
  /**
   * Handle any internal exceptions thrown from this controller
   * @param e the exception that was thrown
   * @return the response entity to Spring to build a response for the client
   */
  @ExceptionHandler
  public ResponseEntity<String> generalExceptionHandler(Exception e) {
    // Log the exception
    return ResponseEntity.status(500).body("An internal error has occured, please try again later");
  }
}
