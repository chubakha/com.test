package com.test.registration.fourth_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.first_registration_page.FirstRegistrationPage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class VerifyActivateAccountButtonTest extends PrepareRegistrationTestData {

    @Test
    void verifyActivateAccountButton() {
        FourthRegistrationPage fourthRegistrationPage = new FirstRegistrationPage()
                .selectOneRandomOption()
                .clickEnabledNextButton()
                .clickNextButton()
                .clickConnectButton()
                .clickInactiveIveReadAndAcceptedTermsConditionsAndPrivacyPolicy();
        Assertions.assertEquals(null, fourthRegistrationPage.getDisabledCreateAccountButton(),
                "'CREATE ACCOUNT' button shouldn't be with attribute 'disabled'");
    }
}
