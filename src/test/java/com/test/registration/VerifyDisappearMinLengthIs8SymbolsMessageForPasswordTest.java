package com.test.registration;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.fourth_registration_page.FourthRegistrationPage;
import com.test.registration.fourth_registration_page.ValidationErrorMessagesType;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifyDisappearMinLengthIs8SymbolsMessageForPasswordTest extends PrepareRegistrationTestData{

    @Test
    void verifyDisappearMaxLengthIs14SymbolsMessageForPassword(){
        String password = faker.internet().password(8, 15);
        String shortPassword = faker.internet().password(1, 8);
        FourthRegistrationPage fourthRegistrationPage = new FourthRegistrationPage()
                .setPasswordField(shortPassword)
                .setRepeatPasswordField(shortPassword)
                .clickInactiveIveReadAndAcceptedTermsConditionsAndPrivacyPolicy()
                .clickInactiveCreateAccountButton()
                .setPasswordField(password)
                .setRepeatPasswordField(password)
                .clickInactiveCreateAccountButton();
        Assertions.assertAll("Validation message should have next:",
                () -> Assertions.assertFalse(fourthRegistrationPage.isValidationMessageForPasswordFieldShown(),
                        String.format("'%s' should not be shown next to Password Field",
                                String.format(ValidationErrorMessagesType.MIN_LENGTH_IS_8_SYMBOLS.getValue(), shortPassword.length()))),
                () -> Assertions.assertFalse(fourthRegistrationPage.isFieldIsRequiredForRepeatPasswordFieldShown(),
                        String.format("'%s' should not be shown next to Repeat Password Field",
                                String.format(ValidationErrorMessagesType.MIN_LENGTH_IS_8_SYMBOLS.getValue(), shortPassword.length())))
        );
    }

}
