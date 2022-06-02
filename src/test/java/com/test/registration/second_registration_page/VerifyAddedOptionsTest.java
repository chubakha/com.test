package com.test.registration.second_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class VerifyAddedOptionsTest extends PrepareRegistrationTestData {
    @Test
    void verifyAddedOptions(){
        FirstRegistrationPage firstRegistrationPage = new FirstRegistrationPage()
                .selectOneCheckboxInEverySection();
        String[] chosenOptionBeforeRedirectToSecondRegistrationPage = firstRegistrationPage.getSelectedOptions();
        firstRegistrationPage.clickEnabledNextButton();
        sleep(2000);
        String[] chosenOptionAfterRedirectToSecondRegistrationPage = new SecondRegistrationPage()
                .getSelectedOptions();
        Assertions.assertArrayEquals(chosenOptionBeforeRedirectToSecondRegistrationPage, chosenOptionAfterRedirectToSecondRegistrationPage, "chosen list on first page registrations should be equal to a list option on second page registration");

    }

}
