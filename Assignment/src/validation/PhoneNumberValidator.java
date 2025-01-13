package validation;

public class PhoneNumberValidator {
    public static boolean isValid(String phoneNumber) {
        return phoneNumber != null && phoneNumber.matches("\\d{10}");
    }
}
