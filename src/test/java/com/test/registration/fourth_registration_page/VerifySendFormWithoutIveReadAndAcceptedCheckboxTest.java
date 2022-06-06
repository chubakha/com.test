package com.test.registration.fourth_registration_page;

import com.github.javafaker.Faker;
import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import com.test.registration.second_registration_page.SecondRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class VerifySendFormWithoutIveReadAndAcceptedCheckboxTest extends PrepareRegistrationTestData {
    @Test
    void verifySendingFormWithoutIveReadAndAcceptedCheckbox() {
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
                .clickInactiveCreateAccountButton();
        Assertions.assertEquals("4/4", fourthRegistrationPage.getStepNumber(), "'4/4' should be shown");
    }
}
