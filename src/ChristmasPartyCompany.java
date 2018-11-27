import part1.*;
import java.sql.*;
import javax.sql.*;

public class ChristmasPartyCompany {
    public static void main(String[] args) {
        // Part 1: Set up definition of the database (SQL DDL statements)
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://mod-intro-databases/sxs1476", "sxs1476", "DBpasswordLOL");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        if ( conn != null ) {
            System.out.println("Database accessed!");

            boolean createMenuTable = DatabaseCreator.createMenuTable(conn);
            boolean createVenueTable = DatabaseCreator.createVenueTable(conn);
            boolean createEntertainmentTable = DatabaseCreator.createEntertainmentTable(conn);
            boolean createPartyTable = DatabaseCreator.createPartyTable(conn);

            if ( createMenuTable && createVenueTable && createEntertainmentTable && createPartyTable ) {
                System.out.println("Tables have been created successfully!");
            } else {
                // In case
                System.out.println("Failed to create tables.");
                return;
            }
        }
        else {
            System.out.println("Failed to make connection/");
            return;
        }
    }
}
