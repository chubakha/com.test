package com.test.registration.second_registration_page;

import com.test.registration.first_registration_page.FirstRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyAddedOptionsTest extends PrepareSecondRegistrationPageTestData {
    @Test
    void verifyAddedOptions(){
        String[] chosenListFirstPage = new FirstRegistrationPage().selectRandomOptionsForCompareOnSecondRegistrationPage();
        String[] chosenListSecondPage = new SecondRegistrationPage().getChosenOptions();
        Assertions.assertArrayEquals(chosenListFirstPage, chosenListSecondPage, "chosen list on first page registrations should be equal to a list option on second page registration");
    }
}
