package part3;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class InterfaceMenu {
    // Connection to database the interace is linked to
    private static Connection dbConn = null;

    /*
    * Display menu method
    */
    private static void displayMenu() {
        System.out.println("\n\n\n\n\n\n\n");
        System.out.println("1. Produce a report for a party ");
        System.out.println("2. Produce a report for a menu item ");
        System.out.println("3. Insert a new party into the database ");
        System.out.println("4. Exit \n\n");
        System.out.print("CHOOSE A NUMBER (1-4) TO SELECT THE ACTION: ");
    }


    /*
    * Print report for given party method
    */
    private static void printPartyReport(int partyNumber) throws SQLException {
        String getPartyStatement = "SELECT pid, name, vid, mid, eid, price, numberofguests FROM Party WHERE pid = " + partyNumber;

        PreparedStatement preparedStatementParty = dbConn.prepareStatement(getPartyStatement);
        ResultSet resultSet = preparedStatementParty.executeQuery();

        while(resultSet.next()) {
            String name = resultSet.getString(2);
            int vid = resultSet.getInt(3);
            int mid = resultSet.getInt(4);
            int eid = resultSet.getInt(5);
            int price = resultSet.getInt(6);
            int noOfG = resultSet.getInt(7);

            // Get menu name
            String menu_name = "";
            int menu_price = 0;
            PreparedStatement preparedStatementMenu = dbConn.prepareStatement("SELECT mid, name, costprice FROM Menu WHERE mid = " + vid);
            ResultSet resultSetMenu = preparedStatementMenu.executeQuery();
            while(resultSetMenu.next()) {
                menu_name = resultSetMenu.getString(2);
                menu_price = resultSetMenu.getInt(3);
            }

            // Get venu description
            String venue_description = "";
            int venue_price = 0;
            PreparedStatement preparedStatementVenue = dbConn.prepareStatement("SELECT vid, description, venueprice FROM Venue WHERE vid = " + vid);
            ResultSet resultSetVenue = preparedStatementVenue.executeQuery();
            while(resultSetVenue.next()) {
                venue_description = resultSetVenue.getString(2);
                venue_price = resultSetVenue.getInt(3);
            }

            // Get menu name
            String ent_description = "";
            int ent_price = 0;
            PreparedStatement preparedStatementEnt = dbConn.prepareStatement("SELECT eid, description, costprice FROM Entertainment WHERE eid = " + vid);
            ResultSet resultSetEnt = preparedStatementEnt.executeQuery();
            while(resultSetEnt.next()) {
                ent_description = resultSetEnt.getString(2);
                ent_price = resultSetEnt.getInt(3);
            }

            int total_cost_price = menu_price * noOfG + venue_price + ent_price;
            System.out.println(total_cost_price);

            // Display the data and return TODO 
        }
    }

    /*
     * Print report for given menu item method
     */
    private static void printMenuItemReport(int menuNumber) {

    }

    /*
    * Create new party method
    */
    private static void createParty() {

    }


    /*
    * Start the interface method
    */
    public static void start(Connection conn) {
        dbConn = conn;
        int optionMenu = 0;
        Scanner in = new Scanner(System.in);

        // Pause to get to menu
        System.out.print("\n\nPress ENTER to start the interface. ");
        in.nextLine();

        do {
            displayMenu();
            optionMenu = in.nextInt();
            System.out.println();

            // Treat all cases
            if ( optionMenu == 1 ) {
                // Request for party number
                System.out.print("Input the party number: ");
                int partyNumber = in.nextInt();

                // Call method
                try {
                    printPartyReport(partyNumber);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            } else if ( optionMenu == 2 ) {
                // Request for menu item number
                System.out.print("Input the menu item number: ");
                int menuNumber = in.nextInt();

                // Call method
                printMenuItemReport(menuNumber);

            } else if ( optionMenu == 3 ) {
                // Call method
                createParty();

            } else if ( optionMenu == 4 ) {
                // This will break the while loop
                break;
            } else {
                System.out.println("Option does not exist. ");
            }

            // Pause
            System.out.println("\n\nWrite anything then press ENTER to return to menu. ");
            in.nextInt();
        } while( optionMenu != 4 );
    }
}
