package com.test.registration.second_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyAddedOptionsTest extends PrepareRegistrationTestData {
    @Test
    void verifyAddedOptions(){
        String[] chosenListFirstPage = new FirstRegistrationPage().choiceAndGetAllChosenOptions();
        String[] chosenListSecondPage = new SecondRegistrationPage().getAllChosenOptions();
        Assertions.assertArrayEquals(chosenListFirstPage, chosenListSecondPage, "chosen list on first page registrations should be equal to a list option on second page registration");
    }
}
