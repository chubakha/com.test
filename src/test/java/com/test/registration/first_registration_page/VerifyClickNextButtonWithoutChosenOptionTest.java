package com.test.registration.first_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyClickNextButtonWithoutChosenOptionTest extends PrepareRegistrationTestData {

    @Test
    @Epic(value = "First registration page")
    @Owner(value = "Alex Chu")
    void verifyClickNextButtonWithoutChosenOption() {
        FirstRegistrationPage firstRegistrationPage = new FirstRegistrationPage()
                .clickDisabledNextButton();
        Assertions.assertEquals("1/4", firstRegistrationPage.getStepNumber(), "1/4 should be shown");
    }
}
