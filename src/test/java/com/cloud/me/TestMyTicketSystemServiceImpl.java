package com.cloud.me;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestMyTicketSystemServiceImpl {

	MyTicketSystemServiceImpl ticketImpl = new MyTicketSystemServiceImpl();
	@Test
	public void testCheckDuplicateUserWhenDuplicateFound() {
		// Create a list with some user journey details
		List<UserJourneyDetails> listDetails = new ArrayList<>();
		UserJourneyDetails u1 = new UserJourneyDetails();
		UserJourneyDetails u2 = new UserJourneyDetails();
		u1.setEmail("user1@gmail.com");
		u2.setEmail("user2@gmail.com");
		listDetails.add(u1);
		listDetails.add(u2);
		// Create a user with an email that already exists in the list
		UserJourneyDetails user = new UserJourneyDetails();
		user.setEmail("user1@gmail.com");
		// Call the method under test
		boolean result = ticketImpl.checkDuplicateUser(listDetails, user);
		// Assert that duplicate is found
		assertTrue(result);
	}

	@Test
	public void testCheckDuplicateUserWhenNoDuplicateFound() {
		// Create a list with some user journey details
		List<UserJourneyDetails> listDetails = new ArrayList<>();
		UserJourneyDetails u1 = new UserJourneyDetails();
		UserJourneyDetails u2 = new UserJourneyDetails();
		u1.setEmail("user1@gmail.com");
		u2.setEmail("user2@gmail.com");
		listDetails.add(u1);
		listDetails.add(u2);
		// Create a user with an email that already exists in the list
		UserJourneyDetails user = new UserJourneyDetails();
		user.setEmail("user4@gmail.com");
		// Call the method under test
		boolean result = ticketImpl.checkDuplicateUser(listDetails, user);
		// Assert that duplicate is not found
		assertFalse(result);
	}


}
