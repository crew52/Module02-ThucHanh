package service;

import entity.Contact;

import java.util.List;
import java.util.Scanner;

public interface IContactService {
    // Thêm mới một đối tượng Contact
    void addContact(Contact contact);

    // Cập nhật một đối tượng Contact
    void updateContact(String phoneNumber, Contact updatedContact);

    // Xóa một đối tượng Contact theo số điện thoại
    void deleteContact(String phoneNumber);

    // Tìm kiếm Contact theo tên hoặc thông tin khác
    Contact searchContact(String query);

    // Xem tất cả các liên hệ
    void viewContacts(Scanner scanner);

    // Đọc dữ liệu từ file
    void readFromFile();

    // Ghi dữ liệu vào file
    void writeToFile();

    // Lấy danh sách các liên hệ
    List<Contact> getContactList();
}
