package com.test.registration.fourth_registration_page;

import com.test.ScreenshotExtension;
import com.test.registration.PrepareRegistrationTestData;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
@ExtendWith(ScreenshotExtension.class)
public class VerifyDisappearFieldIsRequiredMessageForRepeatPasswordFieldTest extends PrepareRegistrationTestData {

    @Test
    void verifyDisappearFieldIsRequiredMessageForRepeatPasswordField() {
        String password = faker.internet().password(8,15);
        FourthRegistrationPage fourthRegistrationPage = new FourthRegistrationPage()
                .clickInactiveIveReadAndAcceptedTermsConditionsAndPrivacyPolicy()
                .clickInactiveCreateAccountButton()
                .setPasswordField(password)
                .setRepeatPasswordField(password)
                .clickInactiveCreateAccountButton();
        Assertions.assertFalse(fourthRegistrationPage.isFieldIsRequiredForRepeatPasswordFieldShown(),
                String.format("'%s' should not be shown next to Password field", ValidationErrorMessagesType.PASSWORDS_MISMATCH.getValue()));
    }
}
