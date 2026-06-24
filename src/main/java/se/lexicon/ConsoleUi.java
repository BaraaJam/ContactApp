package se.lexicon;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleUi {
    private final ContactManager manager = new ContactManager();

    public void start() {
        Scanner input = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n--- Contact Manager ---");
            System.out.println("1. Add a contact");
            System.out.println("2. Display all contacts");
            System.out.println("3. Exit");
            System.out.print("Enter your option: ");

            String userInput = input.nextLine();

            switch (userInput){
                case "1":
                    System.out.println("\n--- Add a contact ---");

                    System.out.print("Enter contact name: ");
                    String contactName = input.nextLine();

                    System.out.print("Enter contact phone number: ");
                    String contactPhoneNumber = input.nextLine();

                    manager.addContact(contactName, contactPhoneNumber);

                    break;
                case "2":
                    System.out.println("\n--- Your contact list ---");
                    ArrayList<Contact> contacts = manager.getAllContacts();
                    System.out.println("-- You have "+ contacts.size() + " contacts --");

                    for (Contact currentContact : contacts) {
                        System.out.println("Name: " + currentContact.getContactName());
                        System.out.println("Phone: " + currentContact.getContactPhoneNumber());
                        System.out.println("--------------------");
                    }

                    break;
                case "3":
                    System.out.println("Goodbye!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

    }

}
