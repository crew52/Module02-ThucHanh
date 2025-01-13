package service;

import entity.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactService implements IContactService {
    private List<Contact> contactList = new ArrayList<>();

    @Override
    public void addContact(Contact contact) {
        contactList.add(contact);
        System.out.println("Đã thêm liên hệ: " + contact.getPhoneNumber());
    }

    @Override
    public void updateContact(String phoneNumber, Contact updatedContact) {

    }

    @Override
    public void deleteContact(String phoneNumber) {

    }

    @Override
    public Contact searchContact(String query) {
        return null;
    }

    @Override
    public void viewContacts(Scanner scanner) {
        if (contactList.isEmpty()) {
            System.out.println("Danh bạ trống!");
            return;
        }

        int count = 0;
        for (int i = 0; i < contactList.size(); i++) {
            Contact contact = contactList.get(i);
            // Hiển thị thông tin của từng liên hệ
            System.out.println("Số điện thoại: " + contact.getPhoneNumber());
            System.out.println("Nhóm: " + contact.getGroup());
            System.out.println("Họ tên: " + contact.getFullName());
            System.out.println("Giới tính: " + contact.getGender());
            System.out.println("Địa chỉ: " + contact.getAddress());
            System.out.println("Ngày sinh: " + contact.getBirthDate());
            System.out.println("Email: " + contact.getEmail());
            System.out.println("--------------------");

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

    }

    @Override
    public void writeToFile() {

    }

    @Override
    public List<Contact> getContactList() {
        return contactList;  // Trả về danh sách liên hệ
    }
}
