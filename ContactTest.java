
package org.snhu.cs320.contact;

import org.junit.jupiter.api.Test;
import org.snhu.cs320.exceptions.ValidationException;

import static org.junit.jupiter.api.Assertions.*;

class ContactTest {

    // this test checks if a contact is created successfully
    @Test
    void createContactSuccess() throws ValidationException {
        Contact contact = new Contact("12345", "First", "Last", "5553334444", "1234 Loblolly Lane");
        assertEquals("12345", contact.getContactId());
        assertEquals("First", contact.getFirstName());
        assertEquals("Last", contact.getLastName());
        assertEquals("5553334444", contact.getPhone());
        assertEquals("1234 Loblolly Lane", contact.getAddress());
    }

    // this test expects a failure when creating a contact with invalid data
    @Test
    void createContactFailure() {
        assertThrows(ValidationException.class, () -> {
            new Contact("", "First", "Last", "5553334444", "1234 Loblolly Lane");
        });
    }

    // this test checks for a null first name, which should fail
    @Test
    void createContactWithNullFirstName() {
        assertThrows(ValidationException.class, () -> {
            new Contact("12345", null, "Last", "5553334444", "1234 Loblolly Lane");
        });
    }

    // this test checks for an invalid phone number, which should fail
    @Test
    void createContactWithInvalidPhone() {
        assertThrows(ValidationException.class, () -> {
            new Contact("12345", "First", "Last", "123", "1234 Loblolly Lane");
        });
    }

    // this test checks for an overly long address, which should fail
    @Test
    void createContactWithLongAddress() {
        assertThrows(ValidationException.class, () -> {
            new Contact("12345", "First", "Last", "5553334444", "this address is way too long to be valid");
        });
    }
}
