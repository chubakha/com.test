package com.test.registration.second_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class VerifyAllChosenOptionAfterReturnToPreviousPageTest extends PrepareRegistrationTestData {
    @Test
    void verifyChosenAllOptionAfterReturnToPreviousPage() {
        FirstRegistrationPage firstRegistrationPage = new FirstRegistrationPage()
                .selectAllCheckboxInEverySection();
        String[] chosenOptionBeforeRedirectToSecondRegistrationPage = firstRegistrationPage.getSelectedOptions();
        firstRegistrationPage
                .clickEnabledNextButton()
                .clickBackButton();
        sleep(2000);
        String[] chosenOptionAfterRedirectToSecondRegistrationPage = new SecondRegistrationPage().getSelectedOptions();
        Assertions.assertArrayEquals(chosenOptionBeforeRedirectToSecondRegistrationPage, chosenOptionAfterRedirectToSecondRegistrationPage,
                "chosen list on first page registrations should be the same after come back from second registration page on first registration page");

    }
}
