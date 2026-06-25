package se.lexicon;


public class Contact {
    private String contactName;
    private String contactPhoneNumber;

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

    public void setContactName(String contactName){
        this.contactName = contactName;
    }

    public void setPhoneNumber(String contactPhoneNumber){
        this.contactPhoneNumber = contactPhoneNumber;
    }
}