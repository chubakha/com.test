package com.test.registration.second_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyOneChosenOptionAfterReturnToPreviousPageTest extends PrepareRegistrationTestData {
    @Test
    void verifyChosenOneOptionAfterReturnToPreviousPage() {
        String[] chosenOptionSecond =
                new FirstRegistrationPage()
                        .selectOneRandomOptionAndRedirectOnSecondRegistrationPage()
                        .getSelectedOptions();
        String[] chosenOptionFirst  =
                new SecondRegistrationPage()
                        .clickBackButton()
                        .getSelectedOptions();
        Assertions.assertArrayEquals(chosenOptionSecond, chosenOptionFirst, "chosen list on first page registrations should be equal to a list option on second page registration");

    }
}
