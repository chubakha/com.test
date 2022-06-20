package com.test.registration.fourth_registration_page;

import com.github.javafaker.Faker;
import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class VerifyHideTextIsRequiredForRepeatPasswordFieldTest extends PrepareRegistrationTestData {

    @Test
    void verifyHideTextIsRequiredForRepeatPasswordField() {
        Faker faker = new Faker();
        FourthRegistrationPage fourthRegistrationPage = new FirstRegistrationPage()
                .selectOneRandomOption()
                .clickEnabledNextButton()
                .clickNextButton()
                .clickConnectButton()
                .clickInactiveIveReadAndAcceptedTermsConditionsAndPrivacyPolicy()
                .clickInactiveCreateAccountButton()
                .setRepeatPasswordField(faker.internet().password(8,30))
                .clickInactiveCreateAccountButton();
        Assertions.assertEquals("Passwords mismatch", fourthRegistrationPage.getFieldIsRequiredForRepeatPasswordField(),
                "'Passwords mismatch' should be shown below Repeat Password field");
    }
}
