package main;

import entity.Contact;
import service.ContactService;
import validation.InputHandler;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactService contactService = new ContactService();

//        contactService.addContact(new Contact("0123456789", "Bạn bè", "Nguyễn Văn A", "Nam", "Hà Nội", LocalDate.of(1990, 5, 20), "a@example.com"));
//        contactService.addContact(new Contact("0987654321", "Công việc", "Trần Thị B", "Nữ", "Hồ Chí Minh", LocalDate.of(1985, 3, 15), "b@example.com"));

        while (true) {
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

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    contactService.viewContacts(scanner);
                    break;
                case 2:
                    contactService.addContact(scanner);
                    break;
                case 3:
                    System.out.print("Nhập số điện thoại của liên hệ cần cập nhật: ");
                    String updatePhone = scanner.nextLine();

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

                    contactService.updateContact(updatePhone, updatedContact);
                    break;
                case 4:
                    System.out.print("Nhập số điện thoại của liên hệ cần xóa: ");
                    String deletePhone = scanner.nextLine();
                    contactService.deleteContact(deletePhone);
                    break;
                case 5:
                    System.out.print("Nhập từ khóa tìm kiếm (số điện thoại, tên hoặc nhóm): ");
                    String query = scanner.nextLine();

                    contactService.searchContact(query);
                    break;
                case 6:
                    contactService.readFromFile();
                    break;
                case 7:
                    contactService.writeToFile();
                    break;
                case 8:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
