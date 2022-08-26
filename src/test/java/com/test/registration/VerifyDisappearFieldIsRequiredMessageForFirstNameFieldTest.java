package com.test.registration;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.fourth_registration_page.FourthRegistrationPage;
import com.test.registration.fourth_registration_page.ValidationErrorMessagesType;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifyDisappearFieldIsRequiredMessageForFirstNameFieldTest extends PrepareRegistrationTestData {

    @Test
    void verifyDisappearFieldIsRequiredMessageForFirstNameField() {
        FourthRegistrationPage fourthRegistrationPage = new FourthRegistrationPage()
                .clickInactiveIveReadAndAcceptedTermsConditionsAndPrivacyPolicy()
                .clickInactiveCreateAccountButton()
                .setFirstNameField(faker.name().firstName())
                .clickInactiveCreateAccountButton();
        Assertions.assertFalse(fourthRegistrationPage.isFieldIsRequiredForFirstNameFieldShown(),
                String.format("'%s' should not be shown next to FirstName field", ValidationErrorMessagesType.FIELD_IS_REQUIRED.getValue()));
    }
}
