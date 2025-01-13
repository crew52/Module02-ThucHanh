package service;

import entity.Contact;
import validation.InputHandler;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactService implements IContactService {
    private List<Contact> contactList = new ArrayList<>();

    @Override
    public void addContact(Scanner scanner) {
        String phoneNumber = InputHandler.getPhoneNumber(scanner);
        String group = InputHandler.getGroup(scanner);
        String fullName = InputHandler.getFullName(scanner);
        String gender = InputHandler.getGender(scanner);
        String address = InputHandler.getAddress(scanner);
        LocalDate birthDate = InputHandler.getBirthDate(scanner);
        String email = InputHandler.getEmail(scanner);

        Contact contact = new Contact(phoneNumber, group, fullName, gender, address, birthDate, email);
        contactList.add(contact);
        System.out.println("Contact added: " + contact.getPhoneNumber());
    }

    @Override
    public void updateContact(String phoneNumber, Contact updatedContact) {
        for (Contact contact : contactList) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                contact.setGroup(updatedContact.getGroup());
                contact.setFullName(updatedContact.getFullName());
                contact.setGender(updatedContact.getGender());
                contact.setAddress(updatedContact.getAddress());
                contact.setBirthDate(updatedContact.getBirthDate());
                contact.setEmail(updatedContact.getEmail());

                System.out.println("Successfully updated contact: " + phoneNumber);
                return;
            }
        }

        System.out.println("No contact found with phone number: " + phoneNumber);
    }

    @Override
    public void deleteContact(String phoneNumber) {
        for (int i = 0; i < contactList.size(); i++) {
            Contact contact = contactList.get(i);
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                contactList.remove(i);
                System.out.println("Contact has been deleted: " + phoneNumber);
                return;
            }
        }

        System.out.println("No contact found with phone number: " + phoneNumber);
    }

    @Override
    public void searchContact(String query) {
        for (Contact contact : contactList) {
            if (contact.getPhoneNumber().contains(query) || contact.getFullName().contains(query) || contact.getGroup().contains(query)) {
                System.out.println("Contact found: " + contact.getFullName());
                contact.displayContactInfo();
                return;
            }
        }
        System.out.println("No contact found with the keyword: " + query);
    }

    @Override
    public void viewContacts(Scanner scanner) {
        if (contactList.isEmpty()) {
            System.out.println("The contact list is empty!");
            return;
        }

        int count = 0;
        for (Contact contact : contactList) {
            contact.displayContactInfo();
            System.out.println("-------");

            count++;

            if (count % 5 == 0) {
                System.out.print("Press Enter to continue...");
                scanner.nextLine();
            }
        }

        System.out.println("All contacts have been displayed.");
    }

    @Override
    public void readFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("contacts.dat"))) {
            contactList = (List<Contact>) ois.readObject();  // Read the contact list from the file
            System.out.println("Contacts have been read from the file.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }

    @Override
    public void writeToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("contacts.dat"))) {
            oos.writeObject(contactList);
            System.out.println("Contacts have been saved to the file.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    @Override
    public List<Contact> getContactList() {
        return contactList;
    }

    public void addContact(Contact contact) {
        contactList.add(contact);
        System.out.println("Contact added: " + contact.getPhoneNumber());
    }
}
