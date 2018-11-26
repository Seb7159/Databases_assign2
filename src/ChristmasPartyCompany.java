import part1.*;
import java.sql.*;
import javax.sql.*;

public class ChristmasPartyCompany {
    public static void main(String[] args) {
        // Part 1: Set up definition of the database (SQL DDL statements)
        // System.setProperty("jdbc.drivers", "org.postgresql.Driver");
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException ex) {
//            System.out.println("Driver not found! ");
//            return;
//        }
        System.out.println("PostgreSQL driver registered.");

        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://mod-intro-databases/cslibrary", "sxs1476", "DBpasswordLOL");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        if ( conn != null ) {
            System.out.println("Database accessed!");
        }
        else {
            System.out.println("Failed to make connection");
        }
    }
}
