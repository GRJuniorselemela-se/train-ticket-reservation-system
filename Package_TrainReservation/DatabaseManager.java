package Package_TrainReservation;
/**
@author Junior
 */
import java.sql.*;

public class DatabaseManager {
    
    private static final String url = "jdbc:mysql://127.0.0.1:3306/train_reservation?zeroDateTimeBehavior=CONVERT_TO_NULL [root on Default schema]";
    private static final String user = "root";
    private static final String password = "";

    
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url, user, password);
        
    }
    
    public void insertTicket(TrainTicket ticket) {
        String sql = "INSERT INTO tickets (passenger_name, destination, ticket_class, base_price, total_price) " + "VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, ticket.getPassengerName());
            pstmt.setString(2, ticket.getDestination());
            pstmt.setString(3, ticket.getTicketClass());
            pstmt.setDouble(4, ticket.getBasePrice());
            pstmt.setDouble(5, ticket.calculateTotalPrice());

            pstmt.executeUpdate();
            System.out.println("Ticket inserted successfully.");

        }
        
        catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }
}
