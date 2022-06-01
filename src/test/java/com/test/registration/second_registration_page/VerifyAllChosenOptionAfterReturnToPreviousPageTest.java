package com.test.registration.second_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyAllChosenOptionAfterReturnToPreviousPageTest extends PrepareRegistrationTestData {
    @Test
    void verifyChosenAllOptionAfterReturnToPreviousPage() {
        FirstRegistrationPage firstRegistrationPage = new FirstRegistrationPage()
                .selectAllCheckboxInEverySection();
        String[] chosenOptionBeforeRedirectToSecondRegistrationPage = firstRegistrationPage.getSelectedOptions();
        firstRegistrationPage
                .clickEnabledNextButton()
                .clickBackButton();
        String[] chosenOptionAfterRedirectToSecondRegistrationPage = firstRegistrationPage.getSelectedOptions();
        Assertions.assertArrayEquals(chosenOptionBeforeRedirectToSecondRegistrationPage, chosenOptionAfterRedirectToSecondRegistrationPage,
                "chosen list on first page registrations should be the same after come back from second registration page on first registration page");

    }
}
