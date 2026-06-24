package se.lexicon;

import java.util.Scanner;

public class ConsoleUi {
    private final ContactManager ContactManager = new ContactManager();

    public void start() {
        Scanner input = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n--- Contact Manager ---");
            System.out.println("1. Add a contact");
            System.out.println("2. Exit");
            System.out.print("Enter your option: ");

            String userInput = input.nextLine();

            switch (userInput){
                case "1":
                    System.out.println("\n--- Add a contact ---");

                    System.out.print("Enter contact name: ");
                    String contactName = input.nextLine();

                    System.out.print("Enter contact phone number: ");
                    String contactPhoneNumber = input.nextLine();

                    ContactManager.addContact(contactName, contactPhoneNumber);

                    break;
                case "2":
                    System.out.println("Goodbye!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

    }

}
