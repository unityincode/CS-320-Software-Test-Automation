package org.snhu.cs320.contact;

import org.snhu.cs320.exceptions.ValidationException;
import org.snhu.cs320.validation.Validation;

public class Contact {
    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public Contact(String contactId, String firstName, String lastName, String phone, String address) throws ValidationException {
        Validation.validateNotBlank(contactId, "id");
        Validation.validateLength(contactId, "id", 1, 10);
        Validation.validateNotBlank(firstName, "firstName");
        Validation.validateLength(firstName, "firstName", 1, 10);
        Validation.validateNotBlank(lastName, "lastName");
        Validation.validateLength(lastName, "lastName", 1, 10);
        Validation.validateNotBlank(phone, "phone");
        Validation.validateLength(phone, "phone", 10, 10);
        Validation.validateNumeric(phone, "phone");
        Validation.validateNotBlank(address, "address");
        Validation.validateLength(address, "address", 1, 30);

        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws ValidationException {
        Validation.validateNotBlank(firstName, "firstName");
        Validation.validateLength(firstName, "firstName", 1, 10);
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws ValidationException {
        Validation.validateNotBlank(lastName, "lastName");
        Validation.validateLength(lastName, "lastName", 1, 10);
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) throws ValidationException {
        Validation.validateNotBlank(phone, "phone");
        Validation.validateLength(phone, "phone", 10, 10);
        Validation.validateNumeric(phone, "phone");
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) throws ValidationException {
        Validation.validateNotBlank(address, "address");
        Validation.validateLength(address, "address", 1, 30);
        this.address = address;
    }
}