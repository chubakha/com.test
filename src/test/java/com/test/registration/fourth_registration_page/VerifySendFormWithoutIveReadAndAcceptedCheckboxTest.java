package com.test.registration.fourth_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.RegistrationStepsType;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifySendFormWithoutIveReadAndAcceptedCheckboxTest extends PrepareRegistrationTestData {

    @Test
    void verifySendingFormWithoutIveReadAndAcceptedCheckbox() {
        String currentPassword = faker.internet().password(8,30);
        FourthRegistrationPage fourthRegistrationPage = new FourthRegistrationPage()
                .setFirstNameField(faker.name().firstName())
                .setLastNameField(faker.name().lastName())
                .setCompanyNameField(faker.company().name())
                .setEmailField(faker.internet().emailAddress())
                .setPasswordField(currentPassword)
                .setRepeatPasswordField(currentPassword)
                .clickInactiveCreateAccountButton();
        Assertions.assertEquals(RegistrationStepsType.REGISTRATION_STEP4.getValue(), fourthRegistrationPage.getPageTitle(),
                String.format("'%s' should be shown", RegistrationStepsType.REGISTRATION_STEP4.getValue()));
    }
}
