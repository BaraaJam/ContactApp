package se.lexicon;


public class Contact {
    private final String contactName;
    private final String contactPhoneNumber;

    public Contact (String contactName, String contactPhoneNumber) {
        this.contactName = contactName;
        this.contactPhoneNumber = contactPhoneNumber;
    }

    public String getContactName() {
        return contactName;
    }

    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }
}
