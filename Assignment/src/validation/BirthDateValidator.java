package validation;

import java.time.LocalDate;

public class BirthDateValidator {
    public static boolean isValid(String birthDateStr) {
        try {
            LocalDate.parse(birthDateStr);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
