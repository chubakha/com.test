package com.test.registration.fourth_registration_page;

import com.github.javafaker.Faker;
import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class VerifyAppearTextIsRequiredForEmailFieldTest extends PrepareRegistrationTestData {

    @Test
    void verifyAppearTextIsRequiredForEmailField() {
        Faker faker = new Faker();
        String currentPassword = faker.internet().password(8, 30);
        FourthRegistrationPage fourthRegistrationPage = new FirstRegistrationPage()
                .selectOneRandomOption()
                .clickEnabledNextButton()
                .clickNextButton()
                .clickConnectButton()
                .setFirstNameField(faker.name().firstName())
                .setLastNameField(faker.name().lastName())
                .setCompanyNameField(faker.company().name())
                .setPasswordField(currentPassword)
                .setRepeatPasswordField(currentPassword)
                .clickInactiveIveReadAndAcceptedTermsConditionsAndPrivacyPolicy()
                .clickInactiveCreateAccountButton();
        Assertions.assertEquals("field is required", fourthRegistrationPage.getFieldIsRequiredForEmailField(),
                "'field is required' should be shown below Email field");
    }
}
