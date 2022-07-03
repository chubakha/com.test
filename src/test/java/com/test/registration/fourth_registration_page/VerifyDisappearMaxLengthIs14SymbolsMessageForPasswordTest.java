package com.test.registration.fourth_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifyDisappearMaxLengthIs14SymbolsMessageForPasswordTest extends PrepareRegistrationTestData{

    @Test
    void verifyDisappearMaxLengthIs14SymbolsMessageForPassword(){
        String password = faker.internet().password(8, 15);
        String longPassword = faker.internet().password(15, 24);
        FourthRegistrationPage fourthRegistrationPage = new FourthRegistrationPage()
                .setPasswordField(longPassword)
                .setRepeatPasswordField(longPassword)
                .clickInactiveIveReadAndAcceptedTermsConditionsAndPrivacyPolicy()
                .clickInactiveCreateAccountButton()
                .setPasswordField(password)
                .setRepeatPasswordField(password)
                .clickInactiveCreateAccountButton();
        Assertions.assertFalse(fourthRegistrationPage.isValidationMessageForPasswordFieldShown(),
                String.format("'%s' should not be shown next to Password Field",
                        String.format(ValidationErrorMessagesType.MAX_LENGTH_IS_14_SYMBOLS.getValue(), longPassword.length())));
        Assertions.assertFalse(fourthRegistrationPage.isFieldIsRequiredForRepeatPasswordFieldShown(),
                String.format("'%s' should not be shown next to Repeat Password Field",
                        String.format(ValidationErrorMessagesType.MAX_LENGTH_IS_14_SYMBOLS.getValue(), longPassword.length())));
    }

}
