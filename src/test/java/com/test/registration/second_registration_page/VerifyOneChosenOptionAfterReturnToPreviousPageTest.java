package com.test.registration.second_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class VerifyOneChosenOptionAfterReturnToPreviousPageTest extends PrepareRegistrationTestData {
    @Test
    void verifyChosenOneOptionAfterReturnToPreviousPage() {
        SecondRegistrationPage secondRegistrationPage = new FirstRegistrationPage()
                .selectOneRandomOption()
                .clickEnabledNextButton();
        String[] chosenOptionOnSecond = secondRegistrationPage
                .getSelectedOptions();
        secondRegistrationPage
                .clickBackButton();
        Assertions.assertArrayEquals(chosenOptionOnSecond, secondRegistrationPage.getSelectedOptions(), "chosen list on first page registrations should be equal to a list option on second page registration");

    }
}
