package Package_TrainReservation;
/**
@author Junior
 */
public class TrainTicketEnhanced {
    
    //Private Variables
    private String passengerName;
    private String destination;
    private String ticketClass;
    private double basePrice;
    
    // Constructor
    public TrainTicketEnhanced(String passengerName, String destination, String ticketClass, double basePrice) {
         
        //Validate passenger name
        if (passengerName == null || passengerName.trim().isEmpty()) {
        throw new IllegalArgumentException("Passenger name cannot be empty.");
        }
        
        //Validate destination
        if (destination == null || destination.trim().isEmpty()) {
        throw new IllegalArgumentException("Destination cannot be empty.");
        }
        
        //Validate ticket class
        if (ticketClass == null || 
            (!ticketClass.equalsIgnoreCase("Economy") && !ticketClass.equalsIgnoreCase("Business"))) {
            throw new IllegalArgumentException("Ticket class must be 'Economy' or 'Business'.");
        }
        
        //Validate base price
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Base price must be positive.");
        }

        this.passengerName = passengerName.trim();
        this.destination = destination.trim();
        //Store canonical form: first letter capital, rest lower case
        this.ticketClass = ticketClass.substring(0, 1).toUpperCase() + ticketClass.substring(1).toLowerCase();
        this.basePrice = basePrice;
        }
    
    //Getter methods
    public String getPassengerName() {
        return passengerName;
    }

    public String getDestination() {
        return destination;
    }

    public String getTicketClass() {
        return ticketClass;
    }

    public double getBasePrice() {
        return basePrice;
    }
    
    //Method to calculate total price based on class multiplier
    public double calculateTotalPrice() {
        if (ticketClass.equalsIgnoreCase("Economy")) {
            return basePrice;
        } else if (ticketClass.equalsIgnoreCase("Business")) {
            return basePrice * 1.5;
        } else {
            return basePrice;
        }
    }

    //Method to display formatted ticket information
    public void displayTicketInfo() {
        System.out.println("Passenger Name: " + passengerName);
        System.out.println("Destination: " + destination);
        System.out.println("Class: " + ticketClass);
        System.out.printf("Total Price: R%.2f%n", calculateTotalPrice());
    }

}
