package com.cloud.me;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class MyTicketSystemController {
	public static void main(String[] args) {
		SpringApplication.run(MyTicketSystemController.class, args);

	}
	MyTicketSystemServiceImpl impl = new MyTicketSystemServiceImpl();
	@PostMapping("/purchaseTicket")
	public String purchaseTicket(@RequestBody UserJourneyDetails userJourneyDetails) {
		return impl.purchaseTicket(userJourneyDetails);
	}

	@GetMapping("/getAllUsersJourneyDetail")
	public List<UserJourneyDetails> getAllUserDetails() {
		return impl.listOfUserJourneyDetails;
	}
	
	@GetMapping("/getUserJourneyDetails")
	public UserJourneyDetails getUserJourneyDetails(@RequestParam String email) {
		return impl.viewUserJourneyDetails(email);
	}
	
	@GetMapping("/viewRequestedSectionDetails")
	public List<UserJourneyDetails> viewRequestedSectionDetails(@RequestParam String sectionName){
		return impl.viewRequestedSectionDetails(sectionName);
	}
	
	@DeleteMapping("/deleteUserJourneyDetails")
	public String deleteUserJourneyDetails(@RequestParam String email){
		return impl.deleteUserJourneyDetails(email);
	}
	
	@PutMapping("/editUserJourneyDetails")
	public String editUserJourneyDetails(String email, String preferedSectionName, int preferedSeatNumber) {
		return impl.editUserJourneyDetails(email, preferedSectionName, preferedSeatNumber);
	}
}
