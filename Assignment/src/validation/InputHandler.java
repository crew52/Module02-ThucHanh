package validation;

import java.time.LocalDate;
import java.util.Scanner;

public class InputHandler {

    public static String getPhoneNumber(Scanner scanner) {
        String phoneNumber;
        while (true) {
            System.out.print("Nhập số điện thoại: ");
            phoneNumber = scanner.nextLine();
            if (!RequiredFieldValidator.isNotEmpty(phoneNumber)) {
                System.out.println("Số điện thoại là bắt buộc.");
                continue;
            }
            if (!PhoneNumberValidator.isValid(phoneNumber)) {
                System.out.println("Số điện thoại không hợp lệ, phải có 10 chữ số.");
                continue;
            }
            break;
        }
        return phoneNumber;
    }

    // Nhập nhóm và kiểm tra
    public static String getGroup(Scanner scanner) {
        String group;
        while (true) {
            System.out.print("Nhập nhóm: ");
            group = scanner.nextLine();
            if (!RequiredFieldValidator.isNotEmpty(group)) {
                System.out.println("Nhóm là bắt buộc.");
                continue;
            }
            break;
        }
        return group;
    }

    // Nhập họ tên và kiểm tra
    public static String getFullName(Scanner scanner) {
        String fullName;
        while (true) {
            System.out.print("Nhập họ tên: ");
            fullName = scanner.nextLine();
            if (!RequiredFieldValidator.isNotEmpty(fullName)) {
                System.out.println("Họ tên là bắt buộc.");
                continue;
            }
            break;
        }
        return fullName;
    }

    // Nhập giới tính và kiểm tra
    public static String getGender(Scanner scanner) {
        String gender;
        while (true) {
            System.out.print("Nhập giới tính: ");
            gender = scanner.nextLine();
            if (!RequiredFieldValidator.isNotEmpty(gender)) {
                System.out.println("Giới tính là bắt buộc.");
                continue;
            }
            break;
        }
        return gender;
    }

    // Nhập địa chỉ và kiểm tra
    public static String getAddress(Scanner scanner) {
        String address;
        while (true) {
            System.out.print("Nhập địa chỉ: ");
            address = scanner.nextLine();
            if (!RequiredFieldValidator.isNotEmpty(address)) {
                System.out.println("Địa chỉ là bắt buộc.");
                continue;
            }
            break;
        }
        return address;
    }

    // Nhập ngày sinh và kiểm tra
    public static LocalDate getBirthDate(Scanner scanner) {
        LocalDate birthDate = null;
        while (true) {
            System.out.print("Nhập ngày sinh (yyyy-MM-dd): ");
            String birthDateStr = scanner.nextLine();
            if (!RequiredFieldValidator.isNotEmpty(birthDateStr)) {
                System.out.println("Ngày sinh là bắt buộc.");
                continue;
            }
            if (!BirthDateValidator.isValid(birthDateStr)) {
                System.out.println("Ngày sinh không hợp lệ. Định dạng đúng là yyyy-MM-dd.");
                continue;
            }
            birthDate = LocalDate.parse(birthDateStr);
            break;
        }
        return birthDate;
    }

    // Nhập email và kiểm tra
    public static String getEmail(Scanner scanner) {
        String email;
        while (true) {
            System.out.print("Nhập email: ");
            email = scanner.nextLine();
            if (!RequiredFieldValidator.isNotEmpty(email)) {
                System.out.println("Email là bắt buộc.");
                continue;
            }
            if (!EmailValidator.isValid(email)) {
                System.out.println("Email không hợp lệ.");
                continue;
            }
            break;
        }
        return email;
    }
}
