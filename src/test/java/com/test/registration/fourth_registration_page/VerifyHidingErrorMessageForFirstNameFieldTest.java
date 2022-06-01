package com.test.registration.fourth_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import com.test.registration.second_registration_page.SecondRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class VerifyHidingErrorMessageForFirstNameFieldTest extends PrepareRegistrationTestData {
    @Test
    void verifyHidingErrorMessageForFirstNameField() {
        new FirstRegistrationPage()
                .selectOneRandomOptionAndRedirectOnSecondRegistrationPage();
        sleep(2000);
        boolean isFieldIsRequiredForFirstNameField =
                new SecondRegistrationPage()
                        .clickNextButton()
                        .clickConnectButton()
                        .clickIveReadAndAcceptedTermsConditionsAndPrivacyPolicy()
                        .clickInactiveCreateAccountButton()
                        .setFirstNameField(FIRST_NAME_REGISTRATION_TEST_CLIENT)
                        .clickInactiveCreateAccountButton()
                .isFieldIsRequiredForFirstNameField();
        Assertions.assertFalse(isFieldIsRequiredForFirstNameField, "'field is required' should not be shown below FirstName field");
    }
}
