package com.test.registration.fourth_registration_page;

import com.test.registration.PrepareRegistrationTestData;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifyActivateCreateAccountButtonTest extends PrepareRegistrationTestData {

    @Test
    @Epic("Эпик")
    @Description("Activate button 'Create a account' after click on 'I’ve read and accepted Terms & Conditions and Privacy Policy.' checkbox")
    void verifyActivateCreateAccountButton() {
        FourthRegistrationPage fourthRegistrationPage = new FourthRegistrationPage()
                .clickInactiveIveReadAndAcceptedTermsConditionsAndPrivacyPolicy();
        Assertions.assertEquals(null, fourthRegistrationPage.getDisabledCreateAccountButton(),
                "'CREATE ACCOUNT' button shouldn't be with attribute 'disabled'");
    }
}
