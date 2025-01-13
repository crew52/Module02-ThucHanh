package main;

import entity.Contact;
import service.ContactService;
import validation.InputHandler;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactService contactService = new ContactService();

        contactService.addContact(new Contact("0123456789", "Bạn bè", "Nguyễn Văn A", "Nam", "Hà Nội", LocalDate.of(1990, 5, 20), "a@example.com"));
        contactService.addContact(new Contact("0987654321", "Công việc", "Trần Thị B", "Nữ", "Hồ Chí Minh", LocalDate.of(1985, 3, 15), "b@example.com"));

        while (true) {
            // Hiển thị menu
            System.out.println("--- Contact Management Program ---");
            System.out.println("1. View contact list");
            System.out.println("2. Add new contact");
            System.out.println("3. Update contact");
            System.out.println("4. Delete contact");
            System.out.println("5. Search contact");
            System.out.println("6. Read from file");
            System.out.println("7. Write to file");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();  // Nhập lựa chọn của người dùng
            scanner.nextLine();  // Đọc dòng còn lại sau khi nhập số

            switch (choice) {
                case 1:
                    contactService.viewContacts(scanner);
                    break;
                case 2:
                    contactService.addContact(scanner);
                    break;
                case 3:
                    // Nhập thông tin để cập nhật liên hệ
                    System.out.print("Nhập số điện thoại của liên hệ cần cập nhật: ");
                    String updatePhone = scanner.nextLine(); // Nhập số điện thoại cần cập nhật

                    // Nhập thông tin mới cho liên hệ
                    System.out.println("Nhập thông tin mới cho liên hệ:");
                    Contact updatedContact = new Contact(
                            updatePhone,
                            InputHandler.getGroup(scanner),
                            InputHandler.getFullName(scanner),
                            InputHandler.getGender(scanner),
                            InputHandler.getAddress(scanner),
                            InputHandler.getBirthDate(scanner),
                            InputHandler.getEmail(scanner)
                    );

                    contactService.updateContact(updatePhone, updatedContact);  // Gọi phương thức updateContact
                    break;
                case 4:
                    System.out.print("Nhập số điện thoại của liên hệ cần xóa: ");
                    String deletePhone = scanner.nextLine();
                    contactService.deleteContact(deletePhone);  // Gọi phương thức deleteContact
                    break;
                case 5:
                    System.out.print("Nhập từ khóa tìm kiếm (số điện thoại, tên hoặc nhóm): ");
                    String query = scanner.nextLine();  // Đọc từ khóa tìm kiếm

                    // Gọi phương thức tìm kiếm trong ContactService
                    contactService.searchContact(query);  // Tìm kiếm theo từ khóa nhập vào
                    break;
                case 6:
//                readFromFile();
                    break;
                case 7:
//                writeToFile();
                    break;
                case 8:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    return;  // Exit the program
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
