package com.test.registration.fourth_registration_page;

import com.github.javafaker.Faker;
import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class VerifyAppearTextIsRequiredForPasswordFieldTest extends PrepareRegistrationTestData {

    @Test
    void verifyAppearTextIsRequiredForPasswordField() {
        Faker faker = new Faker();
        FourthRegistrationPage fourthRegistrationPage = new FirstRegistrationPage()
                .selectOneRandomOption()
                .clickEnabledNextButton()
                .clickNextButton()
                .clickConnectButton()
                .setFirstNameField(faker.name().firstName())
                .setLastNameField(faker.name().lastName())
                .setCompanyNameField(faker.company().name())
                .setEmailField(faker.internet().emailAddress())
                .setRepeatPasswordField(faker.internet().password(8, 30))
                .clickInactiveIveReadAndAcceptedTermsConditionsAndPrivacyPolicy()
                .clickInactiveCreateAccountButton();
        Assertions.assertEquals("Passwords mismatch", fourthRegistrationPage.getFieldIsRequiredForPasswordField(),
                "'Passwords mismatch' should be shown below Password field");
    }
}
