import part1.*;
import part2.*;

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
            System.out.println("Failed to make connection/");
            return;
        }


        // PART 2: Create and populate the database
        // Creation done in part 1
        // Populating the database

    }
}
