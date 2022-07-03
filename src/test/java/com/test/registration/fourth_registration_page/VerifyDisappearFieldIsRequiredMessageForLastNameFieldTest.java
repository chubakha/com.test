package com.test.registration.fourth_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifyDisappearFieldIsRequiredMessageForLastNameFieldTest extends PrepareRegistrationTestData {

    @Test
    void verifyDisappearFieldIsRequiredMessageForLastNameField() {
        FourthRegistrationPage fourthRegistrationPage = new FourthRegistrationPage()
                .clickInactiveIveReadAndAcceptedTermsConditionsAndPrivacyPolicy()
                .clickInactiveCreateAccountButton()
                .setLastNameField(faker.name().lastName())
                .clickInactiveCreateAccountButton();
        Assertions.assertFalse(fourthRegistrationPage.isFieldIsRequiredForLastNameFieldShown(),
                String.format("'%s' should not be shown next to LastName field", ValidationErrorMessagesType.FIELD_IS_REQUIRED.getValue()));
    }
}
