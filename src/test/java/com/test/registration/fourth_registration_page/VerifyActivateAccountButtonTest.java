package com.test.registration.fourth_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import com.test.registration.second_registration_page.SecondRegistrationPage;

import com.test.registration.third_page_registration.ThirdRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class VerifyActivateAccountButtonTest extends PrepareRegistrationTestData {
    @Test
    void verifyActivateAccountButton() {
        FourthRegistrationPage fourthRegistrationPage = new FirstRegistrationPage()
                .selectOneRandomOption()
                .clickEnabledNextButton()
                .clickNextButton()
                .clickConnectButton()
                .clickIveReadAndAcceptedTermsConditionsAndPrivacyPolicy();
        Assertions.assertEquals(null, fourthRegistrationPage.getDisabledCreateAccountButton(), "'CREATE ACCOUNT' button shouldn't be with attribute 'disabled'");
    }
}
