package com.test.registration.fourth_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifyAppearFieldIsRequiredMessageForFirstNameFieldTest extends PrepareRegistrationTestData {

    @Test
    void verifyAppearFieldIsRequiredMessageForFirstNameField() {
        String password = faker.internet().password(8, 15);
        FourthRegistrationPage fourthRegistrationPage = new FourthRegistrationPage()
                .setLastNameField(faker.name().lastName())
                .setCompanyNameField(faker.company().name())
                .setEmailField(faker.internet().emailAddress())
                .setPasswordField(password)
                .setRepeatPasswordField(password)
                .clickInactiveIveReadAndAcceptedTermsConditionsAndPrivacyPolicy()
                .clickInactiveCreateAccountButton();
        Assertions.assertEquals(ValidationErrorMessagesType.FIELD_IS_REQUIRED.getValue(),
                fourthRegistrationPage.getFieldIsRequiredForFirstNameField(),
                String.format("'%s' should be shown next to FirstName field", ValidationErrorMessagesType.FIELD_IS_REQUIRED.getValue()));
    }
}
