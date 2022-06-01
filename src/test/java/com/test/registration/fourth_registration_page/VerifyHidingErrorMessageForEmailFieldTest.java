package com.test.registration.fourth_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import com.test.registration.second_registration_page.SecondRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class VerifyHidingErrorMessageForEmailFieldTest extends PrepareRegistrationTestData {
    @Test
    void verifyHidingErrorMessageForEmailField() {
        new FirstRegistrationPage()
                .selectOneRandomOptionAndRedirectOnSecondRegistrationPage();
        sleep(2000);
        boolean isFieldIsRequiredForEmailField =
                new SecondRegistrationPage()
                        .clickNextButton()
                        .clickConnectButton()
                        .clickIveReadAndAcceptedTermsConditionsAndPrivacyPolicy()
                        .clickInactiveCreateAccountButton()
                        .setEmailField(EMAIL_REGISTRATION_TEST_CLIENT)
                        .clickInactiveCreateAccountButton()
                        .isFieldIsRequiredForEmailField();
        Assertions.assertFalse(isFieldIsRequiredForEmailField, "'field is required' should not be shown below Email field");
    }
}
