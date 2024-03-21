package com.robotdreams.JavaSpringEduClass.unittest;

import com.robotdreams.JavaSpringEduClass.RDMarketPlace.utils.CommunicationValidation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommunicationValidationUnitTest {

    @Test
    public void whenPhoneNumberIsValid_thenTrueShouldBeReturned() {
        assertTrue(CommunicationValidation.isValidPhoneNumber("01234567890"));
    }

    @Test
    public void whenPhoneNumberIsNull_thenFalseShouldBeReturned() {
        assertFalse(CommunicationValidation.isValidPhoneNumber(null));
    }

    @Test
    public void whenPhoneNumberIsEmpty_thenFalseShouldBeReturned() {
        assertFalse(CommunicationValidation.isValidPhoneNumber(""));
    }

    @Test
    public void whenPhoneNumberDoesNotStartWithZero_thenFalseShouldBeReturned() {
        assertFalse(CommunicationValidation.isValidPhoneNumber("11234567890"));
    }

    @Test
    public void whenPhoneNumberIsNot11Digits_thenFalseShouldBeReturned() {
        assertFalse(CommunicationValidation.isValidPhoneNumber("0123456789"));
        assertFalse(CommunicationValidation.isValidPhoneNumber("012345678901"));
    }

    @Test
    public void whenPhoneNumberContainsNonDigits_thenFalseShouldBeReturned() {
        assertFalse(CommunicationValidation.isValidPhoneNumber("0123456789a"));
    }

    @Test
    public void testIsValidEmail_withValidEmails() {
        Assertions.assertTrue(CommunicationValidation.isValidEmail("email@example.com"));
        Assertions.assertTrue(CommunicationValidation.isValidEmail("firstname.lastname@example.com"));
        Assertions.assertTrue(CommunicationValidation.isValidEmail("email@subdomain.example.com"));
        Assertions.assertTrue(CommunicationValidation.isValidEmail("firstname+lastname@example.com"));
        Assertions.assertTrue(CommunicationValidation.isValidEmail("1234567890@example.com"));
        Assertions.assertTrue(CommunicationValidation.isValidEmail("email@example-one.com"));
        Assertions.assertTrue(CommunicationValidation.isValidEmail("_______@example.com"));
        Assertions.assertTrue(CommunicationValidation.isValidEmail("email@example.name"));
        Assertions.assertTrue(CommunicationValidation.isValidEmail("email@example.museum"));
        Assertions.assertTrue(CommunicationValidation.isValidEmail("email@example.co.jp"));
        Assertions.assertTrue(CommunicationValidation.isValidEmail("firstname-lastname@example.com"));
    }

    @Test
    public void testIsValidEmail_withInvalidEmails() {
        Assertions.assertFalse(CommunicationValidation.isValidEmail(null));
        Assertions.assertFalse(CommunicationValidation.isValidEmail(""));
        Assertions.assertFalse(CommunicationValidation.isValidEmail("plainaddress"));
        Assertions.assertFalse(CommunicationValidation.isValidEmail("@no-local-part.com"));
        Assertions.assertFalse(CommunicationValidation.isValidEmail("Outlook User<outlookuser@example.com>"));
        Assertions.assertFalse(CommunicationValidation.isValidEmail("no-at-sign.com"));
        Assertions.assertFalse(CommunicationValidation.isValidEmail("no-tld@domain"));
        Assertions.assertFalse(CommunicationValidation.isValidEmail(".email@domain.com"));
        Assertions.assertFalse(CommunicationValidation.isValidEmail("email@domain@domain.com"));
        Assertions.assertFalse(CommunicationValidation.isValidEmail("あいうえお@example.com"));
        Assertions.assertFalse(CommunicationValidation.isValidEmail("email@domain..com"));
    }

}
