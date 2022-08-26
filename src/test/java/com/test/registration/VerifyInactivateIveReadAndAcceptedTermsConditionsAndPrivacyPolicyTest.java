package com.test.registration;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.fourth_registration_page.FourthRegistrationPage;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifyInactivateIveReadAndAcceptedTermsConditionsAndPrivacyPolicyTest extends PrepareRegistrationTestData {

    @Test
    void verifyInactivateIveReadAndAcceptedTermsConditionsAndPrivacyPolicy() {
        FourthRegistrationPage fourthRegistrationPage = new FourthRegistrationPage()
                .clickInactiveIveReadAndAcceptedTermsConditionsAndPrivacyPolicy()
                .clickActiveIveReadAndAcceptedTermsConditionsAndPrivacyPolicy();
        Assertions.assertEquals("true", fourthRegistrationPage.getDisabledCreateAccountButton(),
                "'CREATE ACCOUNT' button should not has attribute 'disabled'");
    }
}
