package com.test.registration.fourth_registration_page;

import com.github.javafaker.Faker;
import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.RegistrationSteps;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifySendFormWithoutIveReadAndAcceptedCheckboxTest extends PrepareRegistrationTestData {

    @Test
    @Epic(value = STEP_FOURTH_REGISTRATION_PAGE)
    void verifySendingFormWithoutIveReadAndAcceptedCheckbox() {
        Faker userData = new Faker();
        String currentPassword = userData.internet().password(8,30);
        FourthRegistrationPage fourthRegistrationPage = new FirstRegistrationPage()
                .selectOneRandomOption()
                .clickEnabledNextButton()
                .clickNextButton()
                .clickConnectButton()
                .setFirstNameField(userData.name().firstName())
                .setLastNameField(userData.name().lastName())
                .setCompanyNameField(userData.company().name())
                .setEmailField(userData.internet().emailAddress())
                .setPasswordField(currentPassword)
                .setRepeatPasswordField(currentPassword)
                .clickInactiveCreateAccountButton();
        Assertions.assertEquals(RegistrationSteps.REGISTRATION_STEP4.getValue(), fourthRegistrationPage.getStepNumber(),
                "'" + RegistrationSteps.REGISTRATION_STEP4.getValue() + "' should be shown");
    }
}
