package Package_TrainReservation;
/**
@author Junior
 */
import java.util.Scanner;
public class TicketReservationSystem {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter passenger name: ");
        String name = sc.nextLine();

        System.out.print("Enter destination: ");
        String destination = sc.nextLine();
        
        String ticketClass;
        while (true) {
            System.out.print("Enter class (Economy/Business): ");
            ticketClass = sc.nextLine();
            switch (ticketClass.toLowerCase()) {
                case "economy":
                case "business":
                    break;
                default:
                    System.out.println("Invalid class. Please enter 'Economy' or 'Business'.");
                    continue;
            }
            break;
        }

        double basePrice = 0;
        boolean validPrice = false;
        while (!validPrice) {
            System.out.print("Enter base price: ");
            try {
                basePrice = Double.parseDouble(sc.nextLine());
                if (basePrice <= 0) {
                    System.out.println("Price must be positive. Try again.");
                }
                
                else {
                    validPrice = true;
                }
            } 
            
            catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter a numeric value.");
            }
        }

        TrainTicket ticket = new TrainTicket(name, destination, ticketClass, basePrice);

        System.out.println("\n==== Ticket Details ====");
        ticket.displayTicketInfo();
    }
}
            
   
