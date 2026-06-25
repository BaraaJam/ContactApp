package se.lexicon;


public class Contact {
    private final int contactId;
    private String contactName;
    private String contactPhoneNumber;

    public Contact (int contactId,String contactName, String contactPhoneNumber) {
        this.contactId = contactId;
        this.contactName = contactName;
        this.contactPhoneNumber = contactPhoneNumber;
    }

    public int getContactId() {
        return contactId;
    }

    public String getContactName() {
        return contactName;
    }

    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    public void setContactName(String contactName){
        this.contactName = contactName;
    }

    public void setPhoneNumber(String contactPhoneNumber){
        this.contactPhoneNumber = contactPhoneNumber;
    }
}