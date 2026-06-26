package se.lexicon;

import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    private static final String FILE_NAME = "contacts.csv";

    public void saveToFile(ArrayList<Contact> contacts) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Contact contact : contacts){
                String contactsFormula = contact.getContactId() + "," +
                        contact.getContactName() + "," +
                        contact.getContactPhoneNumber();
                writer.write(contactsFormula);
                writer.newLine();
            }

            System.out.println("Contacts successfully saved to " + FILE_NAME);

        } catch (IOException e) {
            System.out.println("Error saving contacts to file: " + e.getMessage());
        }
    }

    public ArrayList<Contact> loadFromFile() {
        ArrayList<Contact> loadedContacts = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                String phone = parts[2];

                Contact newContact = new Contact(id, name, phone);
                loadedContacts.add(newContact);
            }
        } catch (IOException e) {
            System.out.println("No existing contacts found. Starting fresh!");
        }

        return loadedContacts;
    }
}