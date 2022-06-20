package com.test.registration.first_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyCloseCreateCustomRequestPopupTest extends PrepareRegistrationTestData {

    @Test
    @Epic(value = "First registration page")
    @Owner(value = "Alex Chu")
    void verifyCloseCreateCustomRequestPopup() {
        FirstRegistrationPage firstRegistrationPage = new FirstRegistrationPage()
                .clickNeedHelpWithSomethingElseButton()
                .clickNeedHelpWithSomethingElseClosePopup();
        Assertions.assertFalse(firstRegistrationPage.isNotNeedHelpWithSomethingElsePopupShown(), "'Create Custom Request' should not be shown");
    }
}
