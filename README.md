# Train Ticket Reservation System

A multi-stage Java desktop application for booking train tickets, featuring Swing GUI integration, object-oriented validation, Java Collections for in-memory management, and MySQL database persistence via JDBC.

## Project Overview

This system allows users to view available destinations, enter travel information, validate inputs, and calculate ticket prices based on destination and ticket class (Economy/Business). It features both a console-based interface for core logic testing and a fully integrated Swing GUI. The application uses Java Collections to manage multiple reservations in memory and persists final bookings to a MySQL relational database.

## Tech Stack

- **Language:** Java
- **GUI:** Java Swing
- **Data Structures:** Java Collections Framework (`ArrayList`)
- **Database:** MySQL
- **Connectivity:** JDBC with `PreparedStatement`
- **IDE:** NetBeans

## Key Features

- **Dual Interfaces:** Console-based (`TicketReservationSystem`) and GUI-based (`TrainTicketGUI`).
- **Input Validation:** Ensures passenger name and destination are not empty, price is positive, and ticket class is strictly "Economy" or "Business".
- **Dynamic Pricing:** Automatically calculates total price (Business class applies a 1.5x multiplier to the base price).
- **In-Memory Management:** Uses `ArrayList` to temporarily store and search multiple reservations.
- **Search Functionality:** Search tickets by destination.
- **Persistent Storage:** Saves all confirmed bookings to a MySQL database via JDBC.

## Architecture & Code Structure

The project follows a clean separation of concerns to ensure maintainability:

| File                                                      | Role                                                                                                              |
| --------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------- |
| `TrainTicket.java` / `TrainTicketEnhanced.java`           | **Model:** Represents the ticket entity with encapsulation (private fields, public getters) and validation logic. |
| `TicketManager.java` / `TicketManagerEnhanced.java`       | **Controller (In-Memory):** Manages the collection of tickets, handles adding, displaying, and searching.         |
|`TrainTicketGUI.java`                                      | **View:** The Swing-based graphical user interface handling user input and displaying results.                    |
| `DatabaseManager.java`                                    | **Data Access:** Handles JDBC connections and executes SQL queries to persist tickets.                            |
| `TicketReservationSystem.java`                            | **Entry Point (Console):** Demonstrates the core logic without the GUI.                                           |


## Engineering Highlights

- **SQL Injection Prevention:** Utilized `PreparedStatement` in `DatabaseManager` to safely insert user data into the database, preventing SQL injection attacks.
- **Robust Validation:** Implemented `IllegalArgumentException` handling in the enhanced model classes to ensure data integrity before database insertion.
- **Clean GUI Logic:** The Swing interface handles UI validation (using `JOptionPane` for errors) before passing data to the backend manager and database.
- **Multi-Stage Development:** Showcased an evolution from basic Java logic to collections, GUI, and finally database integration.


## Database Schema

To run this project, you will need a MySQL database named `train_reservation` with the following table:

```sql
CREATE DATABASE IF NOT EXISTS train_reservation;

USE train_reservation;

CREATE TABLE tickets (
    id INT AUTO_INCREMENT PRIMARY KEY,
    passenger_name VARCHAR(100) NOT NULL,
    destination VARCHAR(100) NOT NULL,
    ticket_class VARCHAR(50) NOT NULL,
    base_price DECIMAL(10, 2) NOT NULL,
    total_price DECIMAL(10, 2) NOT NULL
); 
```
## How to Run

1. Clone the repository:

```bash
git clone https://github.com/GRJuniorselemela-se/train-ticket-reservation-system.git
```
2. Set up the MySQL database using the SQL script provided above.
3. Open the project in NetBeans (or any Java IDE).
4. Update the database connection settings in `DatabaseManager.java` (lines 10-12) with your local MySQL credentials:

```java
private static final String url = "jdbc:mysql://127.0.0.1:3306/train_reservation";
private static final String user = "your_username"; // Update this
private static final String password = "your_password"; // Update this
```
5. Run either `TicketReservationSystem.java` (for the console version) or `TrainTicketGUI.java` (for the graphical interface).

## What I Learned

- Building multi-stage Java applications from console logic to GUI.
- Integrating GUI event handling with backend business logic and database operations.
- Using Java Collections (`ArrayList`) for in-memory data management.
- Connecting Java applications to a relational database using JDBC.
- Preventing SQL injection using `PreparedStatement`.
- Writing maintainable and modular code using OOP principles.

## Future Improvements

- Implement user authentication (login screen for admins vs. customers)
- Add a "Cancel Ticket" feature that deletes records from the database
- Improve the GUI design with a modern look and feel
- Add unit tests using JUnit to test the pricing and validation logic

## Academic Context

- Developed during Programming in Java (ITJVA2) as part of a second-year Software Engineering curriculum.

## Author

**Gomolemo Reggy Junior Selemela**

Software Engineering Student | Aspiring Software Developer/ Software Engineer (Java)
- **GitHub:** [github.com/GRJuniorselemela-se](https://github.com/GRJuniorselemela-se)
- **LinkedIn:** [linkedin.com/in/grjunior-selemela](https://www.linkedin.com/in/grjunior-selemela)
- **Email:** [juniorselemela@gmail.com](mailto:juniorselemela@gmail.com)
