package Package_TrainReservation;
/**
@author Junior
 */
public class TrainTicket {
    
    //Private Variables
    private String passengerName;
    private String destination;
    private String ticketClass;
    private double basePrice;
    
    // Constructor
    public TrainTicket(String passengerName, String destination, String ticketClass, double basePrice) {
        this.passengerName = passengerName;
        this.destination = destination;
        this.ticketClass = ticketClass;
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
        } 
        
        else if (ticketClass.equalsIgnoreCase("Business")) {
            return basePrice * 1.5;
        } 
        
        else {
            return basePrice;
        }
    }
    
    public String getFormattedTicket(){
        return "Passenger: " + passengerName +
               "\nDestination: " + destination +
               "\nClass: " + ticketClass +
               "\nPrice: R" + calculateTotalPrice() +
               "\n-----------------------------\n";
    }

    //Method to display formatted ticket information
    public void displayTicketInfo() {
        System.out.println("Passenger Name: " + passengerName);
        System.out.println("Destination: " + destination);
        System.out.println("Class: " + ticketClass);
        System.out.printf("Total Price: R%.2f%n", calculateTotalPrice());
    }

}
