package com.test.registration.fourth_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import com.test.registration.second_registration_page.SecondRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class VerifyShowingErrorMessageForLastNameFieldTest extends PrepareRegistrationTestData {
    @Test
    void verifyShowingErrorMessageForLastNameField() {
        new FirstRegistrationPage()
                .choiceOneRandomCheckbox();
        sleep(2000);
        FourthRegistrationPage fourthRegistrationPage =
                new SecondRegistrationPage()
                        .clickNextButton()
                        .clickConnectButton()
                        .setFirstNameField(FIRST_NAME_REGISTRATION_TEST_CLIENT)
                        .setCompanyNameField(COMPANY_REGISTRATION_TEST_CLIENT)
                        .setEmailField(EMAIL_REGISTRATION_TEST_CLIENT)
                        .setPasswordField(PASSWORD_REGISTRATION_TEST_CLIENT)
                        .setRepeatPasswordField(REPEAT_PASSWORD_REGISTRATION_TEST_CLIENT)
                        .clickIveReadAndAcceptedTermsConditionsAndPrivacyPolicy()
                        .clickInactiveCreateAccountButton();
        Assertions.assertEquals("field is required", fourthRegistrationPage.getFieldIsRequiredForLastNameField(), "'field is required' should be shown below LastName field");
    }
}
