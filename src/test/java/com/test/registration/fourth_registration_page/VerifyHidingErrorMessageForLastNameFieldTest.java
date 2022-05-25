package com.test.registration.fourth_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import com.test.registration.second_registration_page.SecondRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class VerifyHidingErrorMessageForLastNameFieldTest extends PrepareRegistrationTestData {
    @Test
    void verifyHidingErrorMessageForLastNameField() {
        new FirstRegistrationPage()
                .choiceOneRandomCheckbox();
        sleep(2000);
        boolean isFieldIsRequiredForLastNameField =
                new SecondRegistrationPage()
                        .clickNextButton()
                        .clickConnectButton()
                        .clickIveReadAndAcceptedTermsConditionsAndPrivacyPolicy()
                        .clickInactiveCreateAccountButton()
                        .setLastNameField(LAST_NAME_REGISTRATION_TEST_CLIENT)
                        .clickInactiveCreateAccountButton()
                        .isFieldIsRequiredForLastNameField();
        Assertions.assertFalse(isFieldIsRequiredForLastNameField, "'field is required' should not be shown below LastName field");
    }
}
