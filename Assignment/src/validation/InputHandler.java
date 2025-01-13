package validation;

import java.time.LocalDate;
import java.util.Scanner;

public class InputHandler {

    public static String getPhoneNumber(Scanner scanner) {
        String phoneNumber;
        while (true) {
            System.out.print("Enter phone number: ");
            phoneNumber = scanner.nextLine();
            if (!RequiredFieldValidator.isNotEmpty(phoneNumber)) {
                System.out.println("Phone number is required.");
                continue;
            }
            if (!PhoneNumberValidator.isValid(phoneNumber)) {
                System.out.println("Invalid phone number, it must contain 10 digits.");
                continue;
            }
            break;
        }
        return phoneNumber;
    }

    public static String getGroup(Scanner scanner) {
        String group;
        while (true) {
            System.out.print("Enter group: ");
            group = scanner.nextLine();
            if (!RequiredFieldValidator.isNotEmpty(group)) {
                System.out.println("Group is required.");
                continue;
            }
            break;
        }
        return group;
    }

    public static String getFullName(Scanner scanner) {
        String fullName;
        while (true) {
            System.out.print("Enter full name: ");
            fullName = scanner.nextLine();
            if (!RequiredFieldValidator.isNotEmpty(fullName)) {
                System.out.println("Full name is required.");
                continue;
            }
            break;
        }
        return fullName;
    }

    public static String getGender(Scanner scanner) {
        String gender;
        while (true) {
            System.out.print("Enter gender: ");
            gender = scanner.nextLine();
            if (!RequiredFieldValidator.isNotEmpty(gender)) {
                System.out.println("Gender is required.");
                continue;
            }
            break;
        }
        return gender;
    }

    public static String getAddress(Scanner scanner) {
        String address;
        while (true) {
            System.out.print("Enter address: ");
            address = scanner.nextLine();
            if (!RequiredFieldValidator.isNotEmpty(address)) {
                System.out.println("Address is required.");
                continue;
            }
            break;
        }
        return address;
    }

    public static LocalDate getBirthDate(Scanner scanner) {
        LocalDate birthDate = null;
        while (true) {
            System.out.print("Enter birthdate (yyyy-MM-dd): ");
            String birthDateStr = scanner.nextLine();
            if (!RequiredFieldValidator.isNotEmpty(birthDateStr)) {
                System.out.println("Birthdate is required.");
                continue;
            }
            if (!BirthDateValidator.isValid(birthDateStr)) {
                System.out.println("Invalid birthdate. The correct format is yyyy-MM-dd.");
                continue;
            }
            birthDate = LocalDate.parse(birthDateStr);
            break;
        }
        return birthDate;
    }

    public static String getEmail(Scanner scanner) {
        String email;
        while (true) {
            System.out.print("Enter email: ");
            email = scanner.nextLine();
            if (!RequiredFieldValidator.isNotEmpty(email)) {
                System.out.println("Email is required.");
                continue;
            }
            if (!EmailValidator.isValid(email)) {
                System.out.println("Invalid email.");
                continue;
            }
            break;
        }
        return email;
    }
}
