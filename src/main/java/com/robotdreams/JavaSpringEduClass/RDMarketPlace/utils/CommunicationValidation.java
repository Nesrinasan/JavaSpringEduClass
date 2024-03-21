package com.robotdreams.JavaSpringEduClass.RDMarketPlace.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommunicationValidation {

    public static boolean isValidPhoneNumber(String phoneNumber) {
        // Telefon numarasının null veya boş olup olmadığını kontrol eder
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            return false;
        }

        // Telefon numarasının 11 rakam uzunluğunda olup olmadığını ve 0 ile başlayıp başlamadığını kontrol eder
        if (phoneNumber.length() != 11 || !phoneNumber.startsWith("0")) {
            return false;
        }

        // Telefon numarasının sadece rakamlardan oluşup oluşmadığını kontrol eder
        for (int i = 0; i < phoneNumber.length(); i++) {
            if (!Character.isDigit(phoneNumber.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    private static final String EMAIL_PATTERN =
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                    "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    public static boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }

        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
