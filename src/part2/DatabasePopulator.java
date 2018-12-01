package part2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class DatabasePopulator {
    /*
    * Populate given table with random values method
    */
    private static boolean populateTable(Connection dbConn, String table) {
        for ( int i = 0; i < 100; i++) {
            // Create values
            String nameTable = "'" + table + i + "'";
            String descriptionTable = "'Lorem ipsum and so on.'";
            if ( table.equals("Venue") )
                descriptionTable = nameTable;
            int costPrice = new Random().nextInt(100);

            // Create string to update table with new values
            String updateTableStatement = "INSERT INTO " + table +
                    " VALUES (" + i + ", " + descriptionTable + ", " + costPrice +
                    ");";

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

    /*
    * Populate Party table with random values method
    */
    private static boolean populateParties(Connection dbConn) {
        for ( int i = 0; i < 1000; i++) {
            // Create values
            String nameParty = "'Party" + i + "'";
            int mid = new Random().nextInt(100),
                    vid = new Random().nextInt(100),
                    eid = new Random().nextInt(100),
                    price = new Random().nextInt(1000),
                    numberOfGuests = new Random().nextInt(250),
                    hour = 17 + new Random().nextInt(5),
                    day = 1 + new Random().nextInt(25),
                    year = 2018 + new Random().nextInt(10);
            String timing = "'" + year + "-12-" + day + " " + hour + ":00:00'";

            // Create string to update table with new values
            String updateTableStatement = "INSERT INTO Party " +
                    "VALUES (" + i + ", " + nameParty + ", " + mid + ", " + vid + ", " + eid + ", " +
                                price + ", " + timing + ", " + numberOfGuests +
                    ");";

            // Execute query
            try {
                PreparedStatement updateTable = dbConn.prepareStatement(updateTableStatement);

                updateTable.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }

        // Return true if party table was fully created
        return true;
    }

    /*
    * Populate all tables method
    */
    public static boolean populateTables(Connection dbConn) {
        // Try to populate all the tables
        boolean populateMenu =              populateTable(dbConn, "Menu"),
                populateVenue =             populateTable(dbConn, "Venue"),
                populateEntertainment =     populateTable(dbConn, "Entertainment"),
                populateParty =             populateParties(dbConn);

        // Verify if all tables have been populated
        if ( !( populateMenu && populateVenue && populateEntertainment && populateParty ) ) {
            return false;
        }

        // Return true if population has worked
        return true;
    }
}
