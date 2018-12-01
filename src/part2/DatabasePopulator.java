package part2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class DatabasePopulator {
    private static boolean addSensitiveData(Connection dbConn) {
        // Create big string with all sensitive data SQL DDL statement commands
        String longStatement = "INSERT INTO Menu VALUES( 0, 'Croissant, pork and mcNuggets', 5); " +
                "INSERT INTO Menu VALUES( 1, 'Pudding and pasta', 12); " +
                "INSERT INTO Menu VALUES( 2, 'Ice cream and burger', 8); " +
                "INSERT INTO Menu VALUES( 3, 'Reindeer meat', 45); " +
                "INSERT INTO Menu VALUES( 4, 'Buffalo meat', 25); " +
                "INSERT INTO Menu VALUES( 5, 'Salmon pie', 30); " +
                "INSERT INTO Menu VALUES( 6, 'Fries and chicken breast', 15); " +
                "INSERT INTO Menu VALUES( 7, 'Fish and chips', 3); " +
                "INSERT INTO Menu VALUES( 8, 'Fruit salad and sauce', 10); " +
                "INSERT INTO Menu VALUES( 9, 'Big chocolate cake', 100); " +
                "" +
                "INSERT INTO Venue VALUES( 0, 'Marriott Hotel', 125); " +
                "INSERT INTO Venue VALUES( 1, 'Holiday Inn Hotel', 90); " +
                "INSERT INTO Venue VALUES( 2, 'UoB Great Hall', 200); " +
                "INSERT INTO Venue VALUES( 3, 'Lab11', 450); " +
                "INSERT INTO Venue VALUES( 4, 'Suki10c', 250); " +
                "INSERT INTO Venue VALUES( 5, 'Monastery Digbeth', 300); " +
                "INSERT INTO Venue VALUES( 6, 'Pryzm', 150); " +
                "INSERT INTO Venue VALUES( 7, 'Rosies', 310); " +
                "INSERT INTO Venue VALUES( 8, 'Propaganda', 140); " +
                "INSERT INTO Venue VALUES( 9, 'The Mill', 70); " +
                "" +
                "INSERT INTO Entertainment VALUES( 0, 'Comedy with Mr Bean', 1250); " +
                "INSERT INTO Entertainment VALUES( 1, 'Stand up with Jon Snow', 900); " +
                "INSERT INTO Entertainment VALUES( 2, 'Concert from Judas Priest', 2000); " +
                "INSERT INTO Entertainment VALUES( 3, 'Salsa class', 450); " +
                "INSERT INTO Entertainment VALUES( 4, 'Knitting class', 25); " +
                "INSERT INTO Entertainment VALUES( 5, 'Special guest with David Guetta', 300); " +
                "INSERT INTO Entertainment VALUES( 6, 'Fun with housemates', 150); " +
                "INSERT INTO Entertainment VALUES( 7, 'Standup with Mister Man', 310); " +
                "INSERT INTO Entertainment VALUES( 8, 'Yoga with Nico', 140); " +
                "INSERT INTO Entertainment VALUES( 9, 'Learn how to DJ with Theodor', 70); " +
                "" +
                "INSERT INTO Party VALUES( 0, 'Christmas Market', 0, 0, 0, 50, '24-12-2018', 100); " +
                "INSERT INTO Party VALUES( 1, 'Christmas Carols', 1, 1, 1, 150, '23-12-2019', 200); " +
                "INSERT INTO Party VALUES( 2, 'Christmas Techno Party', 2, 2, 2, 250, '22-12-2028', 300); " +
                "INSERT INTO Party VALUES( 3, 'Santa comes to New Street', 3, 3, 3, 350, '24-12-2021', 400); " +
                "INSERT INTO Party VALUES( 4, 'Computer Science Christmas Meal', 4, 4, 4, 450, '22-12-2018', 500); " +
                "INSERT INTO Party VALUES( 5, 'Christmas dances', 5, 5, 5, 550, '21-12-2018', 600); " +
                "INSERT INTO Party VALUES( 6, 'Finding Santa secrets', 6, 6, 6, 650, '19-12-2018', 700); " +
                "INSERT INTO Party VALUES( 7, 'Carols for raising awarness on suicide', 7, 7, 7, 750, '21-12-2021', 800); " +
                "INSERT INTO Party VALUES( 8, 'Silicon Canal awards on Christmas', 8, 8, 8, 850, '22-12-2018', 140); " +
                "INSERT INTO Party VALUES( 9, 'Christmas Electro Party', 9, 9, 9, 950, '23-12-2018', 101); ";

        // Execute query
        try {
            PreparedStatement updateTable = dbConn.prepareStatement(longStatement);

            updateTable.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        // Return true if it all worked
        return true;
    }

    /*
    * Populate given table with random values method
    */
    private static boolean populateTable(Connection dbConn, String table) {
        for ( int i = 10; i < 100; i++) {
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
        for ( int i = 10; i < 1000; i++) {
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
        // First add sensitive data for all 4 different tables
        addSensitiveData(dbConn);

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
