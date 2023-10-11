package be.ucll.backend.users.domain;

import org.junit.jupiter.api.Test;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

class UserTest {
    private static ValidatorFactory validatorFactory;
    private static Validator validator;

    // given
    private String validNameAmelia = "Amelia";
    private int validAgeAmelia = 44;
    private String validEmailAmelia = "amelia.anderson@ucll.be";
    private String validPasswordAmelia = "ikgahetnietvertellenhoor9";

    @BeforeAll
    public static void createValidator() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @AfterAll
    public static void close() {
        validatorFactory.close();
    }

//    // constructor
//    // happy case
//    @Test
//    void givenValidValues_whenCreatingUser_thenUserIsCreatedWithThoseValues() {
//        // when
//        User amelia = new User(validNameAmelia, validAgeAmelia, validEmailAmelia,
//                validPasswordAmelia);
//
//        // then
//        assertNotNull(amelia);
//        assertEquals(validNameAmelia, amelia.getName());
//        assertEquals(validAgeAmelia, amelia.getAge());
//        assertEquals(0, amelia.countYearsOfMembership());
//        assertEquals(validEmailAmelia, amelia.getEmail());
//        assertEquals("@$-" + validPasswordAmelia + "&%#", amelia.getPassword());
//        Set<ConstraintViolation<User>> violations = validator.validate(amelia);
//        assertTrue(violations.isEmpty());
//    }
//
//    // constructor
//    // unhappy case
//    // invalid negative age
//    @Test
//    void givenInvalidNegativeAge_whenCreatingUser_thenAgeViolationMessageIsThrown() {
//        // when
//        User amelia = new User(validNameAmelia, -5, validEmailAmelia,
//                validPasswordAmelia);
//
//        // then
//        Set<ConstraintViolation<User>> violations = validator.validate(amelia);
//        assertEquals(1, violations.size());
//        ConstraintViolation<User> violation = violations.iterator().next();
//        assertEquals("age may not be negative", violation.getMessage());
//    }
//
//    // constructor
//    // unhappy case
//    // invalid empty name (" ")
//    @Test
//    void givenInvalidEmptyName_whenCreatingUser_thenNameViolationMessageIsThrown() {
//        // when
//        User amelia = new User("     ", validAgeAmelia, validEmailAmelia,
//                validPasswordAmelia);
//
//        // then
//        Set<ConstraintViolation<User>> violations = validator.validate(amelia);
//        assertEquals(1, violations.size());
//        ConstraintViolation<User> violation = violations.iterator().next();
//        assertEquals("name may not be empty", violation.getMessage());
//    }
//
//    // constructor
//    // unhappy case
//    // invalid empty name ("")
//    @Test
//    void givenInvalidNoName_whenCreatingUser_thenNameViolationMessageIsThrown() {
//        // when
//        User amelia = new User("", validAgeAmelia, validEmailAmelia,
//                validPasswordAmelia);
//        // then
//        Set<ConstraintViolation<User>> violations = validator.validate(amelia);
//        assertEquals(1, violations.size());
//        ConstraintViolation<User> violation = violations.iterator().next();
//        assertEquals("name may not be empty", violation.getMessage());
//    }
//
//    // constructor
//    // unhappy case
//    // invalid email (no @)
//    @Test
//    void givenInvalidEmailNoAt_whenCreatingUser_thenEmailViolationMessageIsThrown() {
//        // when
//        User amelia = new User(validNameAmelia, validAgeAmelia, "amelia.anderson.ucll.be",
//                validPasswordAmelia);
//
//        // then
//        Set<ConstraintViolation<User>> violations = validator.validate(amelia);
//        assertEquals(1, violations.size());
//        ConstraintViolation<User> violation = violations.iterator().next();
//        assertEquals("no valid email", violation.getMessage());
//    }
//
//    /**
//     * constructor
//     * unhappy case
//     * invalid password (white spaces)
//     * TIP: have a look at
//     * -
//     * https://www.geeksforgeeks.org/how-to-validate-a-password-using-regular-expressions-in-java/
//     * - https://www.tabnine.com/code/java/classes/org.hibernate.validator.Pattern
//     **/
//    @Test
//    void givenInvalidPasswordNotMin4Chars_whenCreatingUser_thenPasswordViolationMessageIsThrown() {
//        // when
//        User amelia = new User(validNameAmelia, validAgeAmelia, validEmailAmelia,
//                "alp");
//
//        // then
//        Set<ConstraintViolation<User>> violations = validator.validate(amelia);
//        assertEquals(1, violations.size());
//        List<String> errors = new ArrayList<String>();
//        for (ConstraintViolation<User> violation : violations) {
//            errors.add(violation.getMessage());
//        }
//        assertTrue(errors.contains("password must be minimum 4 characters"));
//    }
//
//    // countMembershipYearsAfter1999
//    // happy case
//    @Test
//    void givenUserWithMemberschipYearsAfter1999_whenAskForMembershipYearsAfter1999_thenCorrectNumberIsReturned() {
//        // given
//        User amelia = new User(validNameAmelia, validAgeAmelia, validEmailAmelia,
//                validPasswordAmelia);
//        amelia.addMembershipYear(2003);
//        amelia.addMembershipYear(1999);
//        amelia.addMembershipYear(2000);
//
//        // when
//        int result = amelia.countMembershipYearsAfter1999();
//
//        // then
//        assertEquals(2, result);
//    }
//
//    // countMembershipYearsAfter1999
//    // unhappy case
//    // no membership years after 1999
//    @Test
//    void givenUserWithNoMemberschipYearsAfter1999_whenAskForMembershipYearsAfter1999_then0IsReturned() {
//        // given
//        User amelia = new User(validNameAmelia, validAgeAmelia, validEmailAmelia,
//                validPasswordAmelia);
//        amelia.addMembershipYear(1999);
//        amelia.addMembershipYear(1978);
//
//        // when
//        int result = amelia.countMembershipYearsAfter1999();
//
//        // then
//        assertEquals(0, result);
//    }
//
//    // constructor
//    // unhappy case
//    // invalid email (no @)
//    // TIP: go to the Java API to the String class and use the method contains
//    @Test
//    void givenInvalidEmail_whenCreatingUser_thenEmailViolationMessageIsThrown() {
//        // when
//        User amelia = new User(validNameAmelia, validAgeAmelia,
//                "amelia.anderson.ucll.be", validPasswordAmelia);
//
//        // then
//        Set<ConstraintViolation<User>> violations = validator.validate(amelia);
//        assertEquals(1, violations.size());
//        ConstraintViolation<User> violation = violations.iterator().next();
//        assertEquals("no valid email", violation.getMessage());
//    }
//
//    // constructor
//    // unhappy case
//    // invalid password (empty string)
//    // TIP: go to the Java API to the String class and use the method isBlank
//    @Test
//    void givenInvalidEmptyPassword_whenCreatingUser_thenPasswordViolationMessageIsThrown() {
//        // when
//        String empty = "        ";
//        User amelia = new User(validNameAmelia, validAgeAmelia, validEmailAmelia, empty);
//
//        // then
//        Set<ConstraintViolation<User>> violations = validator.validate(amelia);
//        assertEquals(1, violations.size());
//        ConstraintViolation<User> violation = violations.iterator().next();
//        assertEquals("password must be minimum 4 characters", violation.getMessage());
//    }
//
//    // getFirstmembershipYear
//    // happy case
//    // TIP: go to the Java API to the ArrayList class and search for some methods
//    // that you can use
//
//    @Test
//    void givenUserWithMemberschipYears_whenAskForFirstMembershipYear_thenYearTheFarestInThePastIsReturned() {
//        // given
//        User amelia = new User(validNameAmelia, validAgeAmelia, validEmailAmelia,
//                validPasswordAmelia);
//        amelia.addMembershipYear(2003);
//        amelia.addMembershipYear(1999);
//        amelia.addMembershipYear(2000);
//
//        // when
//        int firstMembershipYear = amelia.getFirstMembershipYear();
//
//        // then
//        assertEquals(1999, firstMembershipYear);
//    }
//
//    // getFirstmembershipYear
//    // unhappy case
//    // TIP: go to the Java API to the ArrayList class and search for some methods
//    // that you can use
//
//    // no membership years
//    @Test
//    void givenUserWithNoMemberschipYears_whenAskForFirstMembershipYear_then0IsReturned() {
//        // given
//        User amelia = new User(validNameAmelia, validAgeAmelia, validEmailAmelia,
//                validPasswordAmelia);
//
//        // when
//        int firstMembershipYear = amelia.getFirstMembershipYear();
//
//        // then
//        assertEquals(0, firstMembershipYear);
//    }
//
//    // toString
//    // happy case
//    @Test
//    void givenValidUser_whenToString_thenUserObjectisReturnedInStringRepresentation() {
//        // given
//        User amelia = new User(validNameAmelia, validAgeAmelia, validEmailAmelia,
//                validPasswordAmelia);
//
//        // when
//        String result = amelia.toString();
//
//        // then
//        String expected = "Amelia is 44 years old and has as email amelia.anderson@ucll.be";
//
//        assertEquals(expected, result);
//    }
//
//    // getNumberOfMembershipYearsBetween2000And2999
//    // happy case
//    @Test
//    void givenUserWithMemberschipYearsBetween2000And2999_whenAskForNumberOfMembershipYearsBetween2000And2999_thenCorrectNumberIsReturned() {
//        // given
//        User amelia = new User(validNameAmelia, validAgeAmelia, validEmailAmelia,
//                validPasswordAmelia);
//        amelia.addMembershipYear(2003);
//        amelia.addMembershipYear(1999);
//        amelia.addMembershipYear(2000);
//        amelia.addMembershipYear(1978);
//        amelia.addMembershipYear(2023);
//
//        // when
//        int numberOfMembershipBetween2000And2999 = amelia.getNumberOfMembershipYearsBetween2000And2999();
//
//        // then
//        assertEquals(3, numberOfMembershipBetween2000And2999);
//    }
//
//    // getNumberOfMembershipYearsBetween2000And2999
//    // unhappy case
//    @Test
//    void givenUserWithNoMemberschipYearsBetween2000And2999_whenAskForNumberOfMembershipYearsBetween2000And2999_then0IsReturned() {
//        // given
//        User amelia = new User(validNameAmelia, validAgeAmelia, validEmailAmelia,
//                validPasswordAmelia);
//        amelia.addMembershipYear(1980);
//        amelia.addMembershipYear(1999);
//        amelia.addMembershipYear(1978);
//        amelia.addMembershipYear(3000);
//
//        // when
//        int numberOfMembershipBetween2000And2999 = amelia.getNumberOfMembershipYearsBetween2000And2999();
//
//        // then
//        assertEquals(0, numberOfMembershipBetween2000And2999);
//    }
//
//    // isPasswordCorrect
//    // happy case
//    @Test
//    void givenValidUser_whenCheckingPasswordWithCorrectPassword_thenTrueIsReturned() {
//        // given
//        User amelia = new User(validNameAmelia, validAgeAmelia, validEmailAmelia,
//                validPasswordAmelia);
//
//        // when
//        boolean correctPassword = amelia.isPasswordCorrect("ikgahetnietvertellenhoor9");
//
//        // then
//        assertTrue(correctPassword);
//    }
//
//    // isPasswordCorrect
//    // unhappy case
//    @Test
//    void givenValidUser_whenCheckingPasswordWithIncorrectPassword_thenFalseIsReturned() {
//        // given
//        User amelia = new User(validNameAmelia, validAgeAmelia, validEmailAmelia,
//                validPasswordAmelia);
//
//        // when
//        boolean correctPassword = amelia.isPasswordCorrect("rararaaikgahet");
//
//        // then
//        assertFalse(correctPassword);
//    }
//
//    @Test
//    void givenValidUserWithMembershipIn2000_whenCheckingMembership_thenTrueIsReturned() {
//        // given
//        User amelia = new User(validNameAmelia, validAgeAmelia, validEmailAmelia,
//                validPasswordAmelia);
//        amelia.addMembershipYear(2000);
//
//        // then
//        assertTrue(amelia.hasMembershipInYear(2000));
//    }
//
//    @Test
//    void givenValidUserWithoutMembershipIn2000_whenCheckingMembership_thenFalseIsReturned() {
//        // given
//        User amelia = new User(validNameAmelia, validAgeAmelia, validEmailAmelia,
//                validPasswordAmelia);
//        amelia.addMembershipYear(1999);
//
//        // then
//        assertFalse(amelia.hasMembershipInYear(2000));
//    }
}