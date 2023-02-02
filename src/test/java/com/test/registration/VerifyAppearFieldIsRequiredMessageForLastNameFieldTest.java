package com.test.registration;

import com.test.registration.fourth_registration_page.FourthRegistrationPage;
import com.test.registration.fourth_registration_page.ValidationErrorMessagesType;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifyAppearFieldIsRequiredMessageForLastNameFieldTest extends PrepareRegistrationTestData {

    @Test
    void verifyAppearFieldIsRequiredMessageForLastNameField() {
        String currentPassword = faker.internet().password(8, 30);
        FourthRegistrationPage fourthRegistrationPage = new FourthRegistrationPage()
                .setFirstNameField(faker.name().firstName())
                .setCompanyNameField(faker.company().name())
                .setEmailField(faker.internet().emailAddress())
                .setPasswordField(currentPassword)
                .setRepeatPasswordField(currentPassword)
                .clickInactiveIveReadAndAcceptedTermsConditionsAndPrivacyPolicy()
                .clickInactiveCreateAccountButton();
        Assertions.assertEquals(ValidationErrorMessagesType.FIELD_IS_REQUIRED.getValue(),
                fourthRegistrationPage.getFieldIsRequiredForLastNameField(),
                String.format("'%s' should be shown next to LastName field", ValidationErrorMessagesType.FIELD_IS_REQUIRED.getValue()));
    }
}
