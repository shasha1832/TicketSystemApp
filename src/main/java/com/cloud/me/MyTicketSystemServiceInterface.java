package com.cloud.me;

import java.util.List;

public interface MyTicketSystemServiceInterface {
	public String purchaseTicket(UserJourneyDetails userDetails);
	public UserJourneyDetails viewUserJourneyDetails(String email);
	public String editUserJourneyDetails(String email, String preferedSectionName, int preferedSeatNumber);
	public String deleteUserJourneyDetails(String email);
	public List<UserJourneyDetails> viewRequestedSectionDetails(String sectionName);
}
