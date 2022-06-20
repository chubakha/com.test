package com.test.registration.fourth_registration_page;

import com.github.javafaker.Faker;
import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyHideTextIsRequiredForLastNameFieldTest extends PrepareRegistrationTestData {

    @Test
    void verifyHideTextIsRequiredForLastNameField() {
        Faker faker = new Faker();
        FourthRegistrationPage fourthRegistrationPage = new FirstRegistrationPage()
                .selectOneRandomOption()
                .clickEnabledNextButton()
                .clickNextButton()
                .clickConnectButton()
                .clickInactiveIveReadAndAcceptedTermsConditionsAndPrivacyPolicy()
                .clickInactiveCreateAccountButton()
                .setLastNameField(faker.name().lastName())
                .clickInactiveCreateAccountButton();
        Assertions.assertFalse(fourthRegistrationPage.isFieldIsRequiredForLastNameFieldShown(),
                "'field is required' should not be shown below LastName field");
    }
}
