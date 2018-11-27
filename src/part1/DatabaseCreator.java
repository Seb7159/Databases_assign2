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
                "description    CHAR(100)," +
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
                "costprice      INTEGER," +
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
                "FOREIGN KEY (mid) REFERENCES Menu(mid)," +
                "FOREIGN KEY (vid) REFERENCES Venue(vid)," +
                "FOREIGN KEY (eid) REFERENCES Entertainment(eid)" +
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
        boolean createMenuTable = createMenuTable(dbConn);
        boolean createVenueTable = createVenueTable(dbConn);
        boolean createEntertainmentTable = createEntertainmentTable(dbConn);
        boolean createPartyTable = createPartyTable(dbConn);

        if ( createMenuTable && createVenueTable && createEntertainmentTable && createPartyTable ) {
            System.out.println("Tables have been created successfully!");
            return true;
        } else {
            // In case
            System.out.println("Failed to create tables.");
        }
        return false;
    }


    /*
     * Delete all tables method
     */
    public static boolean deleteAllTables(Connection dbConn) {
        String createTableStatement = "DROP TABLE Menu, Entertainment, Venue, Party;";
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
}
