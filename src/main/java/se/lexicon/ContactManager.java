package se.lexicon;

import java.util.ArrayList;

public class ContactManager {
    public final ArrayList<Contact> contacts = new ArrayList<>();

    public void addContact(String contactName, String contactPhoneNumber){
        Contact newContact = new Contact(contactName, contactPhoneNumber);

        contacts.add(newContact);

        System.out.println("Success! Contact added.");
    }

    public ArrayList<Contact> getAllContacts() {
        return contacts;
    }
}
