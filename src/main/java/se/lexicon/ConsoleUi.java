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
            System.out.println("3. Search contacts");
            System.out.println("4. Remove a contact");
            System.out.println("5. Update a contact");
            System.out.println("6. Exit");
            System.out.println("--------------------");
            System.out.print("Enter your option: ");

            String userInput = input.nextLine();

            switch (userInput){
                case "1":
                    System.out.println("\n--- Add a contact ---");
                    String contactName = "";
                    while (contactName.isBlank()){
                        System.out.print("Enter contact name: ");
                        contactName = input.nextLine();
                        if (contactName.isBlank()){
                            System.out.println("Name cannot be blank!");
                        }
                    }

                    String contactPhoneNumber = "";
                    while (contactPhoneNumber.isBlank() || !isValidPhoneFormat(contactPhoneNumber)) {
                        System.out.print("Enter contact phone number: ");
                        contactPhoneNumber = input.nextLine();
                        if (contactPhoneNumber.isBlank() || !isValidPhoneFormat(contactPhoneNumber)) {
                            System.out.println("Invalid! Phone cannot be blank and must contain only numbers.");
                        }
                    }

                    manager.contactAdd(contactName, contactPhoneNumber);
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
                    System.out.println("\n--- Search a contact ---");

                    System.out.print("Enter contact name or phone number(supports partial search): ");
                    String toSearch = input.nextLine();
                    manager.contactSearch(toSearch);
                    break;

                case "4":
                    System.out.println("\n--- Remove a contact ---");

                    System.out.print("Enter the exact name: ");
                    String toRemove = input.nextLine();
                    manager.contactRemove(toRemove);

                    break;

                case "5":
                    System.out.println("\n--- Update a contact ---");

                    System.out.print("Enter the contact's full name: ");
                    String toUpdate = input.nextLine();

                    Contact contactToUpdate = manager.getContactByName(toUpdate);


                    if (contactToUpdate != null) {

                        boolean updating = true;

                        while (updating){

                            System.out.print("Which field do you wish to update? (Type 'Name', 'Phone', or 'Stop' to finish): ");
                            String fieldToUpdate = input.nextLine();

                            if (fieldToUpdate.equalsIgnoreCase("stop")) {
                                updating = false;
                                System.out.println("Finished updating " + contactToUpdate.getContactName() + ".");

                            } else if (fieldToUpdate.equalsIgnoreCase("name")) {
                                System.out.print("Enter new name (or press Enter to keep current): ");
                                String newName = input.nextLine();
                                String oldName = contactToUpdate.getContactName();

                                if (!newName.isBlank()) {
                                    contactToUpdate.setContactName(newName);

                                    System.out.print("Updated successfully. Old name '" +
                                            oldName + "' new name '" + newName + "'");
                                } else {
                                    System.out.print("Name preserved.");
                                }

                            } else if (fieldToUpdate.equalsIgnoreCase("phone")) {
                                System.out.print("Enter new Phone (or press Enter to keep current): ");
                                String newPhone = input.nextLine();
                                String oldPhone = contactToUpdate.getContactPhoneNumber();

                                if (!newPhone.isBlank() && isValidPhoneFormat(newPhone)) {
                                    contactToUpdate.setPhoneNumber(newPhone);
                                    System.out.print("Updated successfully. Old Phone '" +
                                            oldPhone + "' new Phone '" + newPhone + "'");
                                } else {
                                    System.out.print("Phone preserved.");
                                }
                            } else {
                                System.out.println("Invalid input. Please type 'Name', 'Phone', or 'Stop'.");
                            }
                        }
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;

                case "6":
                    System.out.println("Goodbye!");
                    isRunning = false;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

    }

    private boolean isValidPhoneFormat(String phone) {
        return phone.matches("[0-9\\-+ ]+");
    }

}
