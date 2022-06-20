package com.test.registration.fourth_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class VerifyInactivateIveReadAndAcceptedTermsConditionsAndPrivacyPolicyTest extends PrepareRegistrationTestData {

    @Test
    void verifyInactivateIveReadAndAcceptedTermsConditionsAndPrivacyPolicy() {
        FourthRegistrationPage fourthRegistrationPage = new FirstRegistrationPage()
                .selectOneRandomOption()
                .clickEnabledNextButton()
                .clickNextButton()
                .clickConnectButton()
                .clickInactiveIveReadAndAcceptedTermsConditionsAndPrivacyPolicy()
                .clickActiveIveReadAndAcceptedTermsConditionsAndPrivacyPolicy();
        Assertions.assertEquals("true", fourthRegistrationPage.getDisabledCreateAccountButton(),
                "'CREATE ACCOUNT' button shouldn't be with attribute 'disabled'");
    }
}
