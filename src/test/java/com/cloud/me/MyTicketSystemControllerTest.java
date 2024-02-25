package com.cloud.me;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import com.cloud.me.*;

@SuppressWarnings("unused")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MyTicketSystemControllerTest {

    @MockBean
    private MyTicketSystemServiceImpl ticketSystemService;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testPurchaseTicket() {
        UserJourneyDetails userJourneyDetails = new UserJourneyDetails(/* add necessary details */);
        when(ticketSystemService.purchaseTicket(userJourneyDetails)).thenReturn("Ticket purchased successfully");

        ResponseEntity<String> response = restTemplate.postForEntity("/purchaseTicket", userJourneyDetails, String.class);

        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    public void testViewRequestedSectionDetails() {
        String sectionName = "exampleSection";
        List<UserJourneyDetails> userJourneyDetailsList = new ArrayList<>();
        // Add some UserJourneyDetails to the list

        when(ticketSystemService.viewRequestedSectionDetails(sectionName)).thenReturn(userJourneyDetailsList);

        ResponseEntity<List> response = restTemplate.getForEntity("/viewRequestedSectionDetails?sectionName=" + sectionName, List.class);

        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    public void testDeleteUserJourneyDetails() {
        String email = "example@example.com";
        when(ticketSystemService.deleteUserJourneyDetails(email)).thenReturn("User journey details deleted successfully");

        ResponseEntity<String> response = restTemplate.exchange("/deleteUserJourneyDetails?email=" + email, HttpMethod.DELETE, null, String.class);

        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    public void testEditUserJourneyDetails() {
        String email = "example@example.com";
        String preferedSectionName = "exampleSection";
        int preferedSeatNumber = 10;
        when(ticketSystemService.editUserJourneyDetails(email, preferedSectionName, preferedSeatNumber)).thenReturn("User journey details edited successfully");

        ResponseEntity<String> response = restTemplate.exchange("/editUserJourneyDetails?email=" + email + "&preferedSectionName=" + preferedSectionName + "&preferedSeatNumber=" + preferedSeatNumber, HttpMethod.PUT, null, String.class);

        assertEquals(200, response.getStatusCodeValue());
    }
}
