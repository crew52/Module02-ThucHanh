package service;

import entity.Contact;
import validation.InputHandler;

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

        // Thêm liên hệ vào danh sách
        Contact contact = new Contact(phoneNumber, group, fullName, gender, address, birthDate, email);
        contactList.add(contact);
        System.out.println("Đã thêm liên hệ: " + contact.getPhoneNumber());
    }

    @Override
    public void updateContact(String phoneNumber, Contact updatedContact) {
        // Tìm liên hệ theo số điện thoại
        for (int i = 0; i < contactList.size(); i++) {
            Contact contact = contactList.get(i);
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                // Cập nhật thông tin của liên hệ
                contact.setGroup(updatedContact.getGroup());
                contact.setFullName(updatedContact.getFullName());
                contact.setGender(updatedContact.getGender());
                contact.setAddress(updatedContact.getAddress());
                contact.setBirthDate(updatedContact.getBirthDate());
                contact.setEmail(updatedContact.getEmail());

                System.out.println("Cập nhật thành công liên hệ: " + phoneNumber);
                return; // Kết thúc sau khi cập nhật
            }
        }

        System.out.println("Không tìm thấy liên hệ với số điện thoại: " + phoneNumber);
    }

    @Override
    public void deleteContact(String phoneNumber) {
        // Tìm và xóa liên hệ theo số điện thoại
        for (int i = 0; i < contactList.size(); i++) {
            Contact contact = contactList.get(i);
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                contactList.remove(i); // Xóa liên hệ khỏi danh sách
                System.out.println("Đã xóa liên hệ: " + phoneNumber);
                return; // Kết thúc sau khi xóa
            }
        }

        System.out.println("Không tìm thấy liên hệ với số điện thoại: " + phoneNumber);
    }

    @Override
    public Contact searchContact(String query) {
        // Tìm kiếm liên hệ theo số điện thoại, tên, hoặc nhóm
        for (Contact contact : contactList) {
            if (contact.getPhoneNumber().contains(query) || contact.getFullName().contains(query) || contact.getGroup().contains(query)) {
                System.out.println("Tìm thấy liên hệ: " + contact.getFullName());
                contact.displayContactInfo();
                return contact; // Trả về liên hệ tìm được
            }
        }

        System.out.println("Không tìm thấy liên hệ với từ khóa: " + query);
        return null; // Nếu không tìm thấy
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

    }

    @Override
    public void writeToFile() {

    }

    @Override
    public List<Contact> getContactList() {
        return contactList;  // Trả về danh sách liên hệ
    }

    public void addContact(Contact contact) {
        contactList.add(contact);
        System.out.println("Đã thêm liên hệ: " + contact.getPhoneNumber());
    }
}
