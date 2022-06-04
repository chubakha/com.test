package com.test.registration.fourth_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import com.test.registration.second_registration_page.SecondRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class VerifyHidingErrorMessageForCompanyFieldTest extends PrepareRegistrationTestData {
    @Test
    void verifyHidingErrorMessageForCompanyField() {
        new FirstRegistrationPage()
                .selectOneRandomOption()
                .clickEnabledNextButton();
        sleep(2000);
        boolean isFieldIsRequiredForCompanyNameField =
                new SecondRegistrationPage()
                        .clickNextButton()
                        .clickConnectButton()
                        .clickIveReadAndAcceptedTermsConditionsAndPrivacyPolicy()
                        .clickInactiveCreateAccountButton()
                        .setCompanyNameField(COMPANY_REGISTRATION_TEST_CLIENT)
                        .clickInactiveCreateAccountButton()
                .isFieldIsRequiredForCompanyNameField();
        Assertions.assertFalse(isFieldIsRequiredForCompanyNameField, "'field is required' should not be shown below CompanyName field");
    }
}
