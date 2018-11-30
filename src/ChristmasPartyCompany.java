import part1.*;
import part2.*;
import part3.*;

import java.sql.*;
import javax.sql.*;

public class ChristmasPartyCompany {
    public static void main(String[] args) {
        // PART 1: Set up definition of the database (SQL DDL statements)
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://mod-intro-databases/sxs1476", "sxs1476", "DBpasswordLOL");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        if ( conn != null ) {
            System.out.println("Database accessed!");

            // Delete all tables to clear from previous examples
            boolean deleteAllTables = DatabaseCreator.deleteAllTables(conn);
            boolean createAllTables = DatabaseCreator.createAllTables(conn);

            if ( !createAllTables || !deleteAllTables ) {
                return;
            }

            // Else continue with 2nd part
        }
        else {
            System.out.println("Failed to make connection.");
            return;
        }


        // PART 2: Create and populate the database
        // Creation done in part 1
        // Populating the database
        boolean populateTables = DatabasePopulator.populateTables(conn);

        // Check if tables were not populated TODO: populate with 10 sensitive data each table
        if ( !populateTables ) {
            System.out.println("Tables could not be populated.");
            return;
        } else {
            System.out.println("Tables have been populated with random values!");
        }
        // Else continue with 3rd part


        // PART 3: The JDBC Interface
        InterfaceMenu.start(conn);


        // END PART
        System.out.println("Program has ended successfuly, have a great day!");
        return;
    }
}
