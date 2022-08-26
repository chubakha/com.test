package com.test.registration;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.fourth_registration_page.FourthRegistrationPage;
import com.test.registration.fourth_registration_page.ValidationErrorMessagesType;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifyAppearPasswordsMismatchMessageForPasswordFieldsWithEmptyRepeatPasswordFieldTest extends PrepareRegistrationTestData {

    @Test
    void verifyAppearPasswordsMismatchMessageForPasswordFieldsWithEmptyRepeatFieldPasswordField(){
        FourthRegistrationPage fourthRegistrationPage = new FourthRegistrationPage()
                .setPasswordField(faker.internet().password(8, 15))
                .clickInactiveIveReadAndAcceptedTermsConditionsAndPrivacyPolicy()
                .clickInactiveCreateAccountButton();
        Assertions.assertEquals(ValidationErrorMessagesType.PASSWORDS_MISMATCH.getValue(),
                fourthRegistrationPage.getValidationMessageForPasswordField(),
                String.format("'%s' should be shown", ValidationErrorMessagesType.PASSWORDS_MISMATCH.getValue()));
        Assertions.assertEquals(ValidationErrorMessagesType.PASSWORDS_MISMATCH.getValue(),
                fourthRegistrationPage.getValidationMessageForRepeatPasswordField(),
                String.format("'%s' should be shown", ValidationErrorMessagesType.PASSWORDS_MISMATCH.getValue()));

    }
}
