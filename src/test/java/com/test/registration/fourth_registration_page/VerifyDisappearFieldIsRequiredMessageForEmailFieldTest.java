package com.test.registration.fourth_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifyDisappearFieldIsRequiredMessageForEmailFieldTest extends PrepareRegistrationTestData {

    @Test
    void verifyDisappearFieldIsRequiredMessageForEmailField() {
        FourthRegistrationPage fourthRegistrationPage = new FourthRegistrationPage()
                .clickInactiveIveReadAndAcceptedTermsConditionsAndPrivacyPolicy()
                .clickInactiveCreateAccountButton()
                .setEmailField(faker.internet().emailAddress())
                .clickInactiveCreateAccountButton();
        Assertions.assertFalse(fourthRegistrationPage.isFieldIsRequiredForEmailFieldShown(),
                String.format("'%s' should not be shown next to Email field", ValidationErrorMessagesType.FIELD_IS_REQUIRED.getValue()));
    }
}
