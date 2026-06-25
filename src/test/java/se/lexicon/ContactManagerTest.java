package se.lexicon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactManagerTest {

    private ContactManager manager;

    @BeforeEach
    void setUp() {
        // Fresh manager before every single test
        manager = new ContactManager();
    }

    // --- ADD TESTS ---

    @Test
    @DisplayName("Add: Successfully add a valid contact (Happy Path)")
    void testContactAdd_Success() {
        // Arrange
        String testName = "Baraa Jamos";
        String testPhone = "0763007916";

        // Act
        manager.contactAdd(testName, testPhone);

        // Assert
        int actualSize = manager.getAllContacts().size();
        assertEquals(1, actualSize, "The list size should be 1 after adding a contact.");
    }

    @Test
    @DisplayName("Add: Throw exception for blank name (Negative Case)")
    void testContactAdd_InvalidName() {
        // Act & Assert: We expect an IllegalArgumentException when we pass a blank name
        assertThrows(IllegalArgumentException.class, () -> {
            manager.contactAdd("   ", "0763007916");
        }, "Adding a blank name should throw an exception.");

        // Prove the list is still empty!
        assertEquals(0, manager.getAllContacts().size());
    }

    // --- SEARCH / GET TESTS ---

    @Test
    @DisplayName("Search: Successfully find contact by ID (Happy Path)")
    void testGetContactById_Success() {
        // Arrange: Add a contact so the list isn't empty. It will be assigned ID 1.
        manager.contactAdd("Baraa Jamos", "0763007916");

        // Act
        Contact foundContact = manager.getContactById(1);

        // Assert
        assertNotNull(foundContact, "The contact should not be null.");
        assertEquals("Baraa Jamos", foundContact.getContactName(), "The retrieved name should match.");
    }

    @Test
    @DisplayName("Search: Return null for non-existent ID (Negative Case)")
    void testGetContactById_NotFound() {
        // Arrange: Add one contact (ID 1)
        manager.contactAdd("Baraa Jamos", "0763007916");

        // Act: Try to search for ID 99
        Contact foundContact = manager.getContactById(99);

        // Assert
        assertNull(foundContact, "Searching for a non-existent ID should return null.");
    }

    // --- REMOVE TESTS ---

    @Test
    @DisplayName("Remove: Successfully remove contact by ID (Happy Path)")
    void testContactRemove_Success() {
        // Arrange: Add a contact so we have something to delete
        manager.contactAdd("Baraa Jamos", "0763007916");
        assertEquals(1, manager.getAllContacts().size(), "Setup: List should start at size 1.");

        // Act: Remove the contact (ID 1)
        manager.contactRemove(1);

        // Assert
        int actualSize = manager.getAllContacts().size();
        assertEquals(0, actualSize, "The list size should be 0 after successful removal.");
    }

    @Test
    @DisplayName("Remove: Fail to remove with non-existent ID (Negative Case)")
    void testContactRemove_NotFound() {
        // Arrange: Add a contact
        manager.contactAdd("Baraa Jamos", "0763007916");

        // Act: Try to remove ID 99
        manager.contactRemove(99);

        // Assert: Prove the list was NOT altered
        int actualSize = manager.getAllContacts().size();
        assertEquals(1, actualSize, "The list size should remain 1 because ID 99 does not exist.");
    }

    // --- UPDATE TESTS ---

    @Test
    @DisplayName("Update: Successfully update a contact's fields (Happy Path)")
    void testContactUpdate_Success() {
        // Arrange: Add a contact and then retrieve it by ID
        manager.contactAdd("Baraa Jamos", "0763007916");
        Contact contactToUpdate = manager.getContactById(1);

        // Act: Use the setters to update the data (mimicking what your ConsoleUi does)
        contactToUpdate.setContactName("New Name");
        contactToUpdate.setPhoneNumber("111-222");

        // Assert: Pull the contact again and verify it changed
        Contact updatedContact = manager.getContactById(1);
        assertEquals("New Name", updatedContact.getContactName(), "Name should be updated.");
        assertEquals("111-222", updatedContact.getContactPhoneNumber(), "Phone should be updated.");
    }

    @Test
    @DisplayName("Update: Fail to update non-existent contact (Negative Case)")
    void testContactUpdate_NotFound() {
        // Arrange: Add one real contact
        manager.contactAdd("Baraa", "076");

        // Act: Try to grab a fake ID
        Contact fakeContact = manager.getContactById(99);

        // Assert: Prove it returned null, making an update impossible
        assertNull(fakeContact, "Cannot update a contact that doesn't exist.");
    }

    @Test
    @DisplayName("Update: Throw exception when updating to blank name (Negative Case)")
    void testContactUpdate_InvalidName() {
        // Arrange: Add a valid contact and retrieve it
        manager.contactAdd("Baraa", "076");
        Contact contactToUpdate = manager.getContactById(1);

        // Act & Assert: Prove the setter blocks the bad update
        assertThrows(IllegalArgumentException.class, () -> {
            contactToUpdate.setContactName("   ");
        }, "Updating to a blank name should throw an exception.");

        // Extra proof: The name should still be the original name!
        assertEquals("Baraa", contactToUpdate.getContactName());
    }
}