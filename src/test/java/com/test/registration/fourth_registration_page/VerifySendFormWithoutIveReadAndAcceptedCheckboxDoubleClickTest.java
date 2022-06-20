package com.test.registration.fourth_registration_page;

import com.github.javafaker.Faker;
import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class VerifySendFormWithoutIveReadAndAcceptedCheckboxDoubleClickTest extends PrepareRegistrationTestData {

    @Test
    void verifySendingFormWithoutIveReadAndAcceptedCheckboxDoubleClick() {
        Faker faker = new Faker();
        String currentPassword = faker.internet().password(8,30);
        FourthRegistrationPage fourthRegistrationPage = new FirstRegistrationPage()
                .selectOneRandomOption()
                .clickEnabledNextButton()
                .clickNextButton()
                .clickConnectButton()
                .setFirstNameField(faker.name().firstName())
                .setLastNameField(faker.name().lastName())
                .setCompanyNameField(faker.company().name())
                .setEmailField(faker.internet().emailAddress())
                .setPasswordField(currentPassword)
                .setRepeatPasswordField(currentPassword)
                .clickInactiveIveReadAndAcceptedTermsConditionsAndPrivacyPolicy()
                .clickActiveIveReadAndAcceptedTermsConditionsAndPrivacyPolicy()
                .clickInactiveCreateAccountButton();
        Assertions.assertEquals("4/4", fourthRegistrationPage.getStepNumber(), "'4/4' should be shown");
    }
}
