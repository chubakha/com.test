package com.test.registration.fourth_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import com.test.registration.second_registration_page.SecondRegistrationPage;
import com.test.registration.third_page_registration.ThirdRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class VerifyInactivateIveReadAndAcceptedTermsConditionsAndPrivacyPolicyTest extends PrepareRegistrationTestData {
    @Test
    void verifyInactivateIveReadAndAcceptedTermsConditionsAndPrivacyPolicy() {
        new FirstRegistrationPage()
                .choiceOneRandomCheckbox();
        sleep(1000);
        new SecondRegistrationPage()
                .clickNextButton();
        sleep(1000);
        new ThirdRegistrationPage()
                .clickConnectButton();
        FourthRegistrationPage fourthRegistrationPage = new FourthRegistrationPage()
                .clickIveReadAndAcceptedTermsConditionsAndPrivacyPolicy()
                .clickIveReadAndAcceptedTermsConditionsAndPrivacyPolicy();
        Assertions.assertEquals("true", fourthRegistrationPage.getDisabledCreateAccountButton(), "'CREATE ACCOUNT' button shouldn't be with attribute 'disabled'");
    }
}
