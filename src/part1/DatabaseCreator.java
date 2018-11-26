package part1;
import java.sql.*;
import javax.sql.*;

public class DatabaseCreator {
    /*
     * Create Menu table method
     */
    public boolean createMenuTable() {
        String createTableStatement = "CREATE TABLE Menu {" +
                "mid            INTEGER," +
                "description    CHAR(100)," +
                "costprice      INTEGER" +
                "}";

        // Return true to show that creation has been successful
        return true;
    }

    /*
     * Create Entertainment table method
     */
    public boolean createEntertainmentTable() {
        String createTableStatement = "CREATE TABLE Entertainment {" +
                "eid            INTEGER," +
                "description    CHAR(100)," +
                "costprice      INTEGER" +
                "}";

        // Return true to show that creation has been successful
        return true;
    }

    /*
     * Create Venue table method
     */
    public boolean createVenueTable() {
        String createTableStatement = "CREATE TABLE Venue {" +
                "vid            INTEGER," +
                "description    CHAR(100)," +
                "costprice      INTEGER" +
                "}";

        // Return true to show that creation has been successful
        return true;
    }

    /*
     * Create Party table method
     */
    public boolean createPartyTable() {
        String createTableStatement = "CREATE TABLE Party {" +
                "pid            INTEGER," +
                "name           CHAR(20)," +
                "mid            INTEGER," +
                "vid            INTEGER," +
                "eid            INTEGER," +
                "price          INTEGER," +
                "timing         TIMESTAMP," +
                "numberofguests INTEGER" +
                "}";

        // Return true to show that creation has been successful
        return true;
    }
}
