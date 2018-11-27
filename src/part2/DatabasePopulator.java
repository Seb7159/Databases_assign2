package part2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class DatabasePopulator {
    /*
    * Populate given table with random values method
    */
    public static boolean populateTable(Connection dbConn, String table) {
        for ( int i = 0; i < 100; i++) {
            // Create values
            String nameTable = "" + table + i;
            String descriptionTable = "Lorem ipsum and so on.";
            int costPrice = new Random().nextInt(100);

            // Create string to update table with new values
            String updateTableStatement = "INSERT INTO " + table +
                    "VALUES (" + nameTable + ", " + descriptionTable + ", " + costPrice + ");";

            // Execute query
            try {
                PreparedStatement updateTable = dbConn.prepareStatement(updateTableStatement);

                updateTable.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }

        // Return true if all values have been added correctly
        return true;
    }
}
