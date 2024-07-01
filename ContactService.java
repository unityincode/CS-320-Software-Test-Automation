package org.snhu.cs320.contact;

import java.util.HashMap;
import java.util.Map;
import org.snhu.cs320.exceptions.ValidationException;

public class ContactService {
    public static final Map<String, Contact> CONTACT_DATABASE = new HashMap<>();

    public static void add(Contact contact) throws ValidationException {
        if (CONTACT_DATABASE.containsKey(contact.getContactId())) {
            throw new ValidationException("Contact ID already exists");
        }
        CONTACT_DATABASE.put(contact.getContactId(), contact);
    }

    public static void delete(String contactId) {
        CONTACT_DATABASE.remove(contactId);
    }

    public static boolean update(String contactId, Contact updatedContact) throws ValidationException {
        if (!CONTACT_DATABASE.containsKey(contactId)) {
            return false;
        }
        if (updatedContact.getContactId() == null || !updatedContact.getContactId().equals(contactId)) {
            throw new ValidationException("Contact ID mismatch");
        }
        CONTACT_DATABASE.put(contactId, updatedContact);
        return true;
    }
}