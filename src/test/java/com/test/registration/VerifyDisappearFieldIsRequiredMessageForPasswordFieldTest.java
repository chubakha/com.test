package com.test.registration;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.fourth_registration_page.FourthRegistrationPage;
import com.test.registration.fourth_registration_page.ValidationErrorMessagesType;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifyDisappearFieldIsRequiredMessageForPasswordFieldTest extends PrepareRegistrationTestData {

    @Test
    void verifyDisappearFieldIsRequiredMessageForPasswordField() {
        String password = faker.internet().password(8,15);
        FourthRegistrationPage fourthRegistrationPage = new FourthRegistrationPage()
                .clickInactiveIveReadAndAcceptedTermsConditionsAndPrivacyPolicy()
                .clickInactiveCreateAccountButton()
                .setPasswordField(password)
                .setRepeatPasswordField(password)
                .clickInactiveCreateAccountButton();
        Assertions.assertFalse(fourthRegistrationPage.isValidationMessageForPasswordFieldShown(),
                String.format("'%s' should not be shown next to Password field", ValidationErrorMessagesType.FIELD_IS_REQUIRED.getValue()));
    }
}
