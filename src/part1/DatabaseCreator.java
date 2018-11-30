package part1;
import java.sql.*;
import javax.sql.*;

public class DatabaseCreator {
    /*
     * Create Menu table method
     */
    private static boolean createMenuTable(Connection dbConn) {
        String createTableStatement = "CREATE TABLE Menu (" +
                "mid            INTEGER     NOT NULL UNIQUE," +
                "name           CHAR(20)," +
                "costprice      INTEGER," +
                " " +
                "PRIMARY KEY (mid)" +
                ");";

        try {
            PreparedStatement preparedStatement = dbConn.prepareStatement(createTableStatement);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        // Return true to show that creation has been successful
        return true;
    }

    /*
     * Create Entertainment table method
     */
    private static boolean createEntertainmentTable(Connection dbConn) {
        String createTableStatement = "CREATE TABLE Entertainment (" +
                "eid            INTEGER     NOT NULL UNIQUE," +
                "description    CHAR(100)," +
                "costprice      INTEGER," +
                " " +
                "PRIMARY KEY (eid)" +
                ");";
        try {
            PreparedStatement preparedStatement = dbConn.prepareStatement(createTableStatement);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        // Return true to show that creation has been successful
        return true;
    }

    /*
     * Create Venue table method
     */
    private static boolean createVenueTable(Connection dbConn) {
        String createTableStatement = "CREATE TABLE Venue (" +
                "vid            INTEGER     NOT NULL UNIQUE," +
                "description    CHAR(100)," +
                "venueprice      INTEGER," +
                " " +
                "PRIMARY KEY (vid)" +
                ");";
        try {
            PreparedStatement preparedStatement = dbConn.prepareStatement(createTableStatement);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        // Return true to show that creation has been successful
        return true;
    }

    /*
     * Create Party table method
     */
    private static boolean createPartyTable(Connection dbConn) {
        String createTableStatement = "CREATE TABLE Party (" +
                "pid            INTEGER     NOT NULL UNIQUE," +
                "name           CHAR(20)," +
                "mid            INTEGER," +
                "vid            INTEGER," +
                "eid            INTEGER," +
                "price          INTEGER," +
                "timing         TIMESTAMP," +
                "numberofguests INTEGER," +
                " " +
                "PRIMARY KEY (pid)," +
                "FOREIGN KEY (mid) REFERENCES Menu(mid)" +
                "                   ON DELETE CASCADE" +
                "                   ON UPDATE CASCADE," +
                "FOREIGN KEY (vid) REFERENCES Venue(vid)" +
                "                   ON DELETE CASCADE" +
                "                   ON UPDATE CASCADE," +
                "FOREIGN KEY (eid) REFERENCES Entertainment(eid)" +
                "                   ON DELETE CASCADE" +
                "                   ON UPDATE CASCADE" +
                ");";
        try {
            PreparedStatement preparedStatement = dbConn.prepareStatement(createTableStatement);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        // Return true to show that creation has been successful
        return true;
    }


    /*
    * Create all tables method
    */
    public static boolean createAllTables(Connection dbConn) {
        // Try to create tables
        boolean createMenuTable = createMenuTable(dbConn);
        boolean createVenueTable = createVenueTable(dbConn);
        boolean createEntertainmentTable = createEntertainmentTable(dbConn);
        boolean createPartyTable = createPartyTable(dbConn);

        // Check if all tables were created
        if ( createMenuTable && createVenueTable && createEntertainmentTable && createPartyTable ) {
            System.out.println("Tables have been created successfully!");
            return true;
        } else {
            // In case of failing
            System.out.println("Failed to create tables.");
        }
        return false;
    }


    /*
     * Delete all tables method
     */
    public static boolean deleteAllTables(Connection dbConn) {
        // Try to drop all tables
        String dropTablesStatement = "DROP TABLE IF EXISTS Menu, Entertainment, Venue, Party CASCADE;";
        try {
            PreparedStatement preparedStatement = dbConn.prepareStatement(dropTablesStatement);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        // Return true to show that creation has been successful
        return true;
    }
}
