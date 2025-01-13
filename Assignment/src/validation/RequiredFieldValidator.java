package validation;

public class RequiredFieldValidator {
    public static boolean isNotEmpty(String field) {
        return field != null && !field.trim().isEmpty();
    }
}
