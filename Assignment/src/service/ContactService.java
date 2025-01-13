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
        System.out.println("Đã thêm liên hệ: " + contact.getPhoneNumber());
    }

    @Override
    public void updateContact(String phoneNumber, Contact updatedContact) {
        for (int i = 0; i < contactList.size(); i++) {
            Contact contact = contactList.get(i);
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                contact.setGroup(updatedContact.getGroup());
                contact.setFullName(updatedContact.getFullName());
                contact.setGender(updatedContact.getGender());
                contact.setAddress(updatedContact.getAddress());
                contact.setBirthDate(updatedContact.getBirthDate());
                contact.setEmail(updatedContact.getEmail());

                System.out.println("Cập nhật thành công liên hệ: " + phoneNumber);
                return;
            }
        }

        System.out.println("Không tìm thấy liên hệ với số điện thoại: " + phoneNumber);
    }

    @Override
    public void deleteContact(String phoneNumber) {
        for (int i = 0; i < contactList.size(); i++) {
            Contact contact = contactList.get(i);
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                contactList.remove(i);
                System.out.println("Đã xóa liên hệ: " + phoneNumber);
                return;
            }
        }

        System.out.println("Không tìm thấy liên hệ với số điện thoại: " + phoneNumber);
    }

    @Override
    public void searchContact(String query) {
        for (Contact contact : contactList) {
            if (contact.getPhoneNumber().contains(query) || contact.getFullName().contains(query) || contact.getGroup().contains(query)) {
                System.out.println("Tìm thấy liên hệ: " + contact.getFullName());
                contact.displayContactInfo();
                return;
            }
        }
        System.out.println("Không tìm thấy liên hệ với từ khóa: " + query);
    }

    @Override
    public void viewContacts(Scanner scanner) {
        if (contactList.isEmpty()) {
            System.out.println("Danh bạ trống!");
            return;
        }

        int count = 0;
        for (Contact contact : contactList) {
            contact.displayContactInfo();
            System.out.println("-------");

            count++;

            // Hiển thị 5 mục một lần, sau đó yêu cầu nhấn phím Enter để tiếp tục
            if (count % 5 == 0) {
                System.out.print("Nhấn Enter để tiếp tục...");
                scanner.nextLine();  // Đợi người dùng nhấn Enter
            }
        }

        // Sau khi hết danh sách, quay lại menu chính
        System.out.println("Đã hiển thị hết danh bạ.");
    }

    @Override
    public void readFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("contacts.dat"))) {
            contactList = (List<Contact>) ois.readObject();  // Đọc danh sách liên hệ từ tệp
            System.out.println("Đã đọc danh bạ từ tệp.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Lỗi khi đọc từ tệp: " + e.getMessage());
        }
    }

    @Override
    public void writeToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("contacts.dat"))) {
            oos.writeObject(contactList);
            System.out.println("Đã lưu danh bạ vào tệp.");
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi vào tệp: " + e.getMessage());
        }
    }

    @Override
    public List<Contact> getContactList() {
        return contactList;
    }

    public void addContact(Contact contact) {
        contactList.add(contact);
        System.out.println("Đã thêm liên hệ: " + contact.getPhoneNumber());
    }
}
