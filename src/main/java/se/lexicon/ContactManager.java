package se.lexicon;

import java.util.ArrayList;

public class ContactManager {
    public final ArrayList<Contact> contacts = new ArrayList<>();

    public void contactAdd(String contactName, String contactPhoneNumber){
        Contact newContact = new Contact(contactName, contactPhoneNumber);

        contacts.add(newContact);

        System.out.println("Success! Contact added.");
    }

    public ArrayList<Contact> getAllContacts() {
        return contacts;
    }

    public void contactSearch (String contactSearch) {
        boolean isFound = false;
        String searchLower = contactSearch.toLowerCase();

        for (Contact contact : contacts ) {
            if (contact.getContactName().toLowerCase().contains(searchLower) ||
                    contact.getContactPhoneNumber().toLowerCase().contains(searchLower)) {

                System.out.println("\n--- Contact Found ---");
                System.out.println("Name: " + contact.getContactName());
                System.out.println("Phone: " + contact.getContactPhoneNumber());
                System.out.println("---------------------");
                isFound = true;

            }
        }

        if (!isFound){
            System.out.println("\nNo contact contains '" + contactSearch + "'.");
        }
    }

    public void contactRemove (String contactSearch){
        Contact contactToRemove = null;

        for (Contact contact : contacts ) {
            if (contact.getContactName().equalsIgnoreCase(contactSearch)){
                contactToRemove = contact;
                break;
            }
        }

        if (contactToRemove != null){
            contacts.remove(contactToRemove);
            System.out.println("\nContact " + contactToRemove.getContactName() + " removed successfully.");
        } else {
            System.out.println("\nContact not found, make sure to enter the full name.");
        }
    }
}
