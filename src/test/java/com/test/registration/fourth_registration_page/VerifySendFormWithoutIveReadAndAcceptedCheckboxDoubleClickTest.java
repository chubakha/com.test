package com.test.registration.fourth_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import com.test.registration.RegistrationStepsType;

import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifySendFormWithoutIveReadAndAcceptedCheckboxDoubleClickTest extends PrepareRegistrationTestData {

    @Test
    void verifySendingFormWithoutIveReadAndAcceptedCheckboxDoubleClick() {
        String currentPassword = faker.internet().password(8,30);
        FourthRegistrationPage fourthRegistrationPage = new FourthRegistrationPage()
                .setFirstNameField(faker.name().firstName())
                .setLastNameField(faker.name().lastName())
                .setCompanyNameField(faker.company().name())
                .setEmailField(faker.internet().emailAddress())
                .setPasswordField(currentPassword)
                .setRepeatPasswordField(currentPassword)
                .clickInactiveIveReadAndAcceptedTermsConditionsAndPrivacyPolicy()
                .clickActiveIveReadAndAcceptedTermsConditionsAndPrivacyPolicy()
                .clickInactiveCreateAccountButton();
        Assertions.assertEquals(RegistrationStepsType.REGISTRATION_STEP4.getValue(), fourthRegistrationPage.getPageTitle(),
                String.format("'%s' should be shown", RegistrationStepsType.REGISTRATION_STEP4.getValue()));
    }
}
