package part1;
import java.sql.*;
import javax.sql.*;

public class DatabaseCreator {
    /*
     * Create Menu table method
     */
    public static boolean createMenuTable(Connection dbConn) {
        String createTableStatement = "CREATE TABLE Menu (" +
                "mid            INTEGER," +
                "description    CHAR(100)," +
                "costprice      INTEGER" +
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
    public static boolean createEntertainmentTable(Connection dbConn) {
        String createTableStatement = "CREATE TABLE Entertainment (" +
                "eid            INTEGER," +
                "description    CHAR(100)," +
                "costprice      INTEGER" +
                ")";
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
    public static boolean createVenueTable(Connection dbConn) {
        String createTableStatement = "CREATE TABLE Venue (" +
                "vid            INTEGER," +
                "description    CHAR(100)," +
                "costprice      INTEGER" +
                ")";
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
    public static boolean createPartyTable(Connection dbConn) {
        String createTableStatement = "CREATE TABLE Party (" +
                "pid            INTEGER," +
                "name           CHAR(20)," +
                "mid            INTEGER," +
                "vid            INTEGER," +
                "eid            INTEGER," +
                "price          INTEGER," +
                "timing         TIMESTAMP," +
                "numberofguests INTEGER" +
                ")";
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
