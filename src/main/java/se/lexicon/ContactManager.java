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
                foundMessage(contact);
                isFound = true;

            }
        }

        if (!isFound){
            System.out.println("\nNo contact contains '" + contactSearch + "'.");
        }
    }

    public Contact getContactByName(String searchName) {
        for (Contact contact : contacts) {
            if (contact.getContactName().equalsIgnoreCase(searchName)) {
                foundMessage(contact);
                return contact;
            }
        }
        return null;
    }

    public void contactRemove (String exactName){
        Contact contactToRemove = getContactByName(exactName);

        if (contactToRemove != null){
            contacts.remove(contactToRemove);
            System.out.println("\nContact " + contactToRemove.getContactName() + " removed successfully.");
        } else {
            System.out.println("\nContact not found, make sure to enter the full name.");
        }
    }

    private void foundMessage(Contact contact){
        System.out.println("\n--- Contact Found ---");
        System.out.println("Name: " + contact.getContactName());
        System.out.println("Phone: " + contact.getContactPhoneNumber());
        System.out.println("---------------------");
    }
}
