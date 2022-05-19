package com.test.registration.second_registration_page;

import com.test.registration.first_registration_page.FirstRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyCompareOneOptionAfterReturnToPreviousPageTest extends PrepareSecondRegistrationPageTestData {
    @Test
    void verifyChosenOneOptionAfterReturnToPreviousPage() {
        String[] chosenOptionSecond =
                new FirstRegistrationPage()
                        .choiceOneRandomCheckbox()
                        .getAllChosenOptions();
        String[] chosenOptionFirst  =
                new SecondRegistrationPage()
                        .clickBackButton()
                        .getAllChosenOptions();
        Assertions.assertArrayEquals(chosenOptionSecond, chosenOptionFirst, "chosen list on first page registrations should be equal to a list option on second page registration");

    }
}
