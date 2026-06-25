package se.lexicon;

import java.util.ArrayList;

public class ContactManager {
    public final ArrayList<Contact> contacts = new ArrayList<>();
    private int nextAvailableId = 1;

    public void contactAdd(String contactName, String contactPhoneNumber){
        int contactId = nextAvailableId;
        Contact newContact = new Contact(contactId, contactName, contactPhoneNumber);

        contacts.add(newContact);
        nextAvailableId++;
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

    public Contact getContactById(int contactId) {
        for (Contact contact : contacts) {
            if (contact.getContactId() == contactId){
                return contact;
            }
        }
        return null;
    }

    public void contactRemove (int exactID){
        Contact contactToRemove = getContactById(exactID);

        if (contactToRemove != null){
            contacts.remove(contactToRemove);
            System.out.println("\nContact " + contactToRemove.getContactName() + " removed successfully.");
        } else {
            System.out.println("\nContact not found, make sure to enter the full name.");
        }
    }

    private void foundMessage(Contact contact){
        System.out.println("\n--- Contact Found ---");
        System.out.println("[ID: " + contact.getContactId() +
                "] Name: " + contact.getContactName() +
                " - Phone: " + contact.getContactPhoneNumber());
        System.out.println("---------------------");
    }
}
