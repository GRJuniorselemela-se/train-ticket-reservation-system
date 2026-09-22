package Package_TrainReservation;
/**
@author Junior
 */
import java.util.ArrayList;
public class TicketManager {
    
    private ArrayList<TrainTicket> tickets;

    public TicketManager() {
        tickets = new ArrayList<>();
    }

    public void addTicket(TrainTicket ticket) {
        tickets.add(ticket);
    }

    public void displayAllTickets() {
        if (tickets.isEmpty()) {
            System.out.println("No tickets booked.");
        } 
        else {
            System.out.println("\n=== All Ticket Reservations ===");
            for (int i = 0; i < tickets.size(); i++) {
                System.out.println("Ticket #" + (i + 1));
                tickets.get(i).displayTicketInfo();
                System.out.println("---------------------------");
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (TrainTicket t : tickets){
            sb.append(t.getFormattedTicket());
        }
    }

    public ArrayList<TrainTicket> getTickets() {
        return tickets;
    }

    public boolean addTicketWithValidation(String name, String destination, String ticketClass, double price) {
        
        try {
            TrainTicket ticket = new TrainTicket(name, destination, ticketClass, price);
            tickets.add(ticket);
            return true;
        } 
        catch (IllegalArgumentException e) {
            return false;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    String displayAllTickets(TrainTicket ticket) {
        if (tickets.isEmpty()) {
        return "No tickets booked.\n";
    }

    StringBuilder sb = new StringBuilder();

    for (TrainTicket t : tickets) {
        sb.append(t.getFormattedTicket());
    }

    return sb.toString();
    }
    
    public ArrayList<TrainTicket> searchByDestination(String destination) {
    ArrayList<TrainTicket> results = new ArrayList<>();
    if (destination == null || destination.trim().isEmpty()) {
        return results;
    }
    for (TrainTicket ticket : tickets) {
        if (ticket.getDestination().equalsIgnoreCase(destination.trim())) {
            results.add(ticket);
        }
    }
    return results;
    
    }
        
    
}

    
