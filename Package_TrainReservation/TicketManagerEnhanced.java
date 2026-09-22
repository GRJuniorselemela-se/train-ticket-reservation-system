package Package_TrainReservation;
/**
@author Junior
 */
import java.util.ArrayList;
public class TicketManagerEnhanced {
    
    public boolean addTicketWithValidation(String name, String destination, String tClass, double price) {
        try {
            TrainTicket ticket = new TrainTicket(name, destination, tClass, price);
            tickets.add(ticket);
        return true;
        } 
        
        catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
            return false;
        }
    }
    
    private ArrayList<TrainTicket> tickets;

    public TicketManagerEnhanced() {
        tickets = new ArrayList<>();
    }

    public void addTicket(TrainTicket ticket) {
        tickets.add(ticket);
    }

    public void displayAllTickets() {
        if (tickets.isEmpty()) {
            System.out.println("No tickets reserved.");
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
    
}
