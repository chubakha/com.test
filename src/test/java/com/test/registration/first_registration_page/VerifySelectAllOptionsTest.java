package com.test.registration.first_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.second_registration_page.SecondRegistrationPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifySelectAllOptionsTest extends PrepareRegistrationTestData {

    @Test
    @Epic(value = "First registration page")
    @Owner(value = "Alex Chu")
    void verifyAllSelectedCheckboxes() {
        SecondRegistrationPage secondRegistrationPage = new FirstRegistrationPage()
                .selectAllCheckboxInEverySection()
                .clickEnabledNextButton();
        Assertions.assertEquals("2/4", secondRegistrationPage.getStepNumber(), "2/4 should be shown");
    }
}
