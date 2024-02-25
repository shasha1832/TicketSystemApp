package com.cloud.me;


public class UserJourneyDetails {
private String firstName;
private final int tickePrice = 20;
public int getTickePrice() {
	return tickePrice;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public int getSeatNumber() {
	return seatNumber;
}

public void setSeatNumber(int seatNumber) {
	this.seatNumber = seatNumber;
}

public String getSectionName() {
	return sectionName;
}

public void setSectionName(String sectionName) {
	this.sectionName = sectionName;
}

public String getFrom() {
	return from;
}

public void setFrom(String from) {
	this.from = from;
}

public String getTo() {
	return to;
}

public void setTo(String to) {
	this.to = to;
}

private String lastName;
private String email;
private int seatNumber; // Each section can have 10 seats
private String sectionName; // Section A or Section B
private String from;
private String to;
@Override
public String toString() {
	return "UserJourneyDetails [firstName=" + firstName + ", tickePrice=" + tickePrice + ", lastName=" + lastName
			+ ", email=" + email + ", seatNumber=" + seatNumber + ", sectionName=" + sectionName + ", from=" + from
			+ ", to=" + to + "]";
}

}
