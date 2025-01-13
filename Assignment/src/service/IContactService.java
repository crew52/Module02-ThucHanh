package service;

import entity.Contact;

import java.util.List;
import java.util.Scanner;

public interface IContactService {
    void addContact(Scanner scanner);

    void updateContact(String phoneNumber, Contact updatedContact);

    void deleteContact(String phoneNumber);

    void searchContact(String query);

    void viewContacts(Scanner scanner);

    void readFromFile();

    void writeToFile();

    List<Contact> getContactList();
}
