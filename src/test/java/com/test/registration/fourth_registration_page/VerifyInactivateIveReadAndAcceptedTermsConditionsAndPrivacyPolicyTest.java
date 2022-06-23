package com.test.registration.fourth_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifyInactivateIveReadAndAcceptedTermsConditionsAndPrivacyPolicyTest extends PrepareRegistrationTestData {

    @Test
    @Epic(value = STEP_FOURTH_REGISTRATION_PAGE)
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
