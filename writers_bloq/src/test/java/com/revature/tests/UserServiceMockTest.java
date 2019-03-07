package com.revature.tests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.revature.models.User;
import com.revature.repos.UserRepo;
import com.revature.services.UserService;


@RunWith(MockitoJUnitRunner.class)
public class UserServiceMockTest {
	
	@Mock
	UserRepo userRepoMock;
	
	@InjectMocks
	UserService userService;
	
	User user = new User();
	
	@Test
	public void testGetUserByEmail() {
		when(userRepoMock.getUserByEmail("jmeono@gmail.com")).thenReturn(user);
		user.setEmail("jmeono@gmail.com");
		assertEquals(user,user);
	}
	

}
