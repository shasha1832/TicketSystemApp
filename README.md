## Prerequisites

Before running this project, please ensure that you have the following prerequisites installed:

- Java Development Kit (JDK) version 17 or above.
- Spring Tool Suite or any IDE that supports Spring Boot projects.
- Maven for dependency management.

## Installation and Setup

1. **Install JDK 17:**
   - Download and install Java Development Kit (JDK) version 17 or above on your system from the official Oracle website or adopt OpenJDK.

2. **Clone the Project:**
   - Clone the project repository from your version control system (e.g., Git) or download it as a zip file and extract it to a directory on your local machine.

3. **Import Project:**
   - Import the project into your preferred IDE (e.g., Spring Tool Suite) as a Maven project.

4. **Build the Project:**
   - Open a terminal or command prompt window and navigate to the project directory.
   - Run the following Maven command to clean, build, and install the project dependencies:
     ```
     mvn clean install
     ```

## Running the Application

1. **Start the Application:**
   - Once the project is successfully built, start the Spring Boot application by running the main class (`MyTicketSystemController.java`) from your IDE.

2. **Accessing the Endpoints:**
   - The application will start on a default port (usually 8080). You can access the endpoints using tools like Postman or any web browser.
   - Refer to the API documentation below for details on available endpoints and their usage.

## REST API Endpoints Documentation

Below you will find detailed information about each endpoint available for interacting with the system.

## 1. Purchase Ticket

This endpoint enables users to purchase a ticket by providing their personal details.

- **Endpoint:** `POST /purchaseTicket`
- **Description:** This endpoint allows users to purchase a ticket by providing their personal details.
- **Request Body:**
  ```json
  {
    "firstName": "test",
    "lastName": "test_last",
    "email": "test@gmail.com",
    "from": "bangalore",
    "to": "delhi"
  }
## 2. Get User Journey Details

This endpoint retrieves the details of the receipt for the user based on their booking email ID.

- **Endpoint:** `GET /getUserJourneyDetails`
- **Description:** This endpoint retrieves the details of the receipt for the user based on their booking email ID.
- **Query Parameter:** `email`
- **Example:** `localhost:8080/getUserJourneyDetails?email=test@gmail.com`

## 3. View Requested Section Details

This endpoint retrieves all user details for a specific section.

- **Endpoint:** `GET /viewRequestedSectionDetails`
- **Description:** This endpoint retrieves all user details for a specific section.
- **Query Parameter:** `sectionName`
- **Example:** `localhost:8080/viewRequestedSectionDetails?sectionName=A`

## 4. Delete User Journey Details

This endpoint removes user journey details based on the provided email.

- **Endpoint:** `GET /deleteUserJourneyDetails`
- **Description:** This endpoint removes user journey details based on the provided email.
- **Query Parameter:** `email`
- **Example:** `localhost:8080/deleteUserJourneyDetails?email=test@gmail.com`

## 5. Edit User Journey Details

This endpoint modifies a user's seat by providing the email, preferred section name, and preferred seat number.

- **Endpoint:** `PUT /editUserJourneyDetails`
- **Description:** This endpoint modifies a user's seat by providing the email, preferred section name, and preferred seat number.
- **Query Parameters:**
  - `email`
  - `preferedSectionName`
  - `preferedSeatNumber`
- **Example:** `localhost:8080/editUserJourneyDetails?email=test@gmail.com&preferedSectionName=B&preferedSeatNumber=10`
