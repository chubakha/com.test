package com.test.registration.fourth_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import com.test.registration.second_registration_page.SecondRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class VerifyShowingErrorMessageForRepeatPasswordFieldTest extends PrepareRegistrationTestData {
    @Test
    void verifyShowingErrorMessageForRepeatPasswordField() {
        new FirstRegistrationPage()
                .selectOneRandomOptionAndRedirectOnSecondRegistrationPage();
        sleep(2000);
        FourthRegistrationPage fourthRegistrationPage =
                new SecondRegistrationPage()
                        .clickNextButton()
                        .clickConnectButton()
                        .setFirstNameField(FIRST_NAME_REGISTRATION_TEST_CLIENT)
                        .setLastNameField(LAST_NAME_REGISTRATION_TEST_CLIENT)
                        .setEmailField(EMAIL_REGISTRATION_TEST_CLIENT)
                        .setCompanyNameField(COMPANY_REGISTRATION_TEST_CLIENT)
                        .setPasswordField(PASSWORD_REGISTRATION_TEST_CLIENT)
                        .clickIveReadAndAcceptedTermsConditionsAndPrivacyPolicy()
                        .clickInactiveCreateAccountButton();
        Assertions.assertEquals("Passwords mismatch", fourthRegistrationPage.getFieldIsRequiredForPasswordField(), "'Passwords mismatch' should be shown below Repeat Password");
    }
}
