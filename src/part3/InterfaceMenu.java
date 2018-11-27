package part3;

import java.io.IOException;
import java.util.Scanner;

public class InterfaceMenu {
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
    private static void printPartyReport(int partyNumber) {

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
    public static void start() {
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
                printPartyReport(partyNumber);

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
