package com.cloud.me;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyTicketSystemServiceImpl implements MyTicketSystemServiceInterface {
	private static int seatCounterSectionA =1;
	private static int seatCounterSectionB =1;
	private static int maxNumberofSeatsinSection = 10;
	public static List<UserJourneyDetails> listOfUserJourneyDetails = new ArrayList<UserJourneyDetails>();

	@Override
	public String purchaseTicket(UserJourneyDetails userJourneyDetails) {
		try {
			if (!checkDuplicateUser(listOfUserJourneyDetails, userJourneyDetails)) {
				userJourneyDetails = generateSeatDetailsForPurchaseTicket(userJourneyDetails);
			}else {
				return "Ticket can not be purchased as user trying to book ticket with the same email id";
			}
			
		}catch(Exception e) {
			return "Ticket can not be purchased as the Seats are full";
		}
		listOfUserJourneyDetails.add(userJourneyDetails);
		return "Ticket Purchased for "+ userJourneyDetails.getFirstName();
	}

	@Override
	public UserJourneyDetails viewUserJourneyDetails(String email) {
		for (UserJourneyDetails userJouDetails : listOfUserJourneyDetails) {
			if(userJouDetails.getEmail().equals(email)) {
				return userJouDetails;
			}
		}
		return null;
	}

	@Override
	public String editUserJourneyDetails(String email, String preferedSectionName, int preferedSeatNumber) {
//		Shashank should fix the checking which seat is prepared
		boolean preferedSeatIsEmpty = checkPreferdSeatIsEmpty(preferedSectionName, preferedSeatNumber);
		String message = "User not found";
		if(preferedSeatIsEmpty) {
			Iterator<UserJourneyDetails> itr = listOfUserJourneyDetails.iterator();
			while(itr.hasNext()) {
				UserJourneyDetails ujd = (UserJourneyDetails)itr.next();
				if (ujd.getEmail().equals(email)) {
					listOfUserJourneyDetails.remove(ujd);
					ujd.setSeatNumber(preferedSeatNumber);
					ujd.setSectionName(preferedSectionName);
					listOfUserJourneyDetails.add(ujd);
					message = "User details updated of "+ ujd.getFirstName() +" is "+ ujd;
					break;
				}
			}  
		}else {
			message = "Prefered seat is not empty or not valid";
		}
		return message;
	}

	@Override
	public String deleteUserJourneyDetails(String email) {
		// TODO Auto-generated method stub
		Iterator<UserJourneyDetails> itr = listOfUserJourneyDetails.iterator();
		String message =  "No user deleted"; 
		while(itr.hasNext()) {
			UserJourneyDetails ujd = (UserJourneyDetails)itr.next();
			if (ujd.getEmail().equals(email)) {
				listOfUserJourneyDetails.remove(ujd);
				message = "User details deleted of "+ ujd.getFirstName();
				break;
			}
		}
		return message;
	}


	@Override
	public List<UserJourneyDetails> viewRequestedSectionDetails(String sectionName) {
		// TODO Auto-generated method stub
		List<UserJourneyDetails> filterdUserJourneyDetails = new ArrayList<UserJourneyDetails>();
		for(UserJourneyDetails userJorDetails : listOfUserJourneyDetails) {
			if(userJorDetails.getSectionName().equals(sectionName)) {
				filterdUserJourneyDetails.add(userJorDetails);
			}	
		}
		return filterdUserJourneyDetails;
	}
	
	public UserJourneyDetails generateSeatDetailsForPurchaseTicket(UserJourneyDetails userJourneyDetails) throws Exception {
		if (seatCounterSectionA > maxNumberofSeatsinSection && seatCounterSectionB > maxNumberofSeatsinSection) {
			throw new Exception("All the Seats are sold");
		}
		else if (seatCounterSectionA <= seatCounterSectionB) {
			userJourneyDetails.setSectionName("A");
			userJourneyDetails.setSeatNumber(seatCounterSectionA++);
		} else {
			userJourneyDetails.setSectionName("B");
			userJourneyDetails.setSeatNumber(seatCounterSectionB++);
		}
		return userJourneyDetails;

	}
	
	public boolean checkDuplicateUser(List<UserJourneyDetails> listDetails, UserJourneyDetails user) {
		boolean duplicateFound = false;
		for(UserJourneyDetails ujd : listDetails) {
			if(ujd.getEmail().equals(user.getEmail())) {
				duplicateFound = true;
				break;
			}
		}
		return duplicateFound;
		
	}
	
	public boolean checkPreferdSeatIsEmpty(String preferedSectionName, int preferedSeatNumber) {
		boolean preferedSeatIsEmpty = true;
		if(!(preferedSectionName.equals("A") || preferedSectionName.equals("B")) || preferedSeatNumber > maxNumberofSeatsinSection) {
			preferedSeatIsEmpty = false;
			return preferedSeatIsEmpty;
		}
		
		for(UserJourneyDetails ujd : listOfUserJourneyDetails) {
			if(preferedSectionName.equals(ujd.getSectionName()) && preferedSeatNumber == ujd.getSeatNumber()) {
				preferedSeatIsEmpty = false;
				break;
			}
		}
		return preferedSeatIsEmpty;
	}

}
