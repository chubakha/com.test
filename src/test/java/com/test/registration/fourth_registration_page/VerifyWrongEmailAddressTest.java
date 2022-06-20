package com.test.registration.fourth_registration_page;

import com.github.javafaker.Faker;
import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class VerifyWrongEmailAddressTest extends PrepareRegistrationTestData {

    @Disabled
    @ParameterizedTest
    @ValueSource(strings = {"testgmail.com", "test@@gmail.com", "test@gmailcom", "test@gmail", "test@gmail,com", "gmail.com", "test@.com", "test@com", "test@gmail.c", "test@gmail.comcom", "test@gmail.com.com", "почта@gmail.com", "test@гмаил.com", ".test@gmail.com", "test.@gmail.com", "test!@gmail.com", "test?@gmail.com"})
    void verifyWrongEmailAddress(String email) {
        Faker faker = new Faker();
        String password = faker.internet().password(8, 15);
        FourthRegistrationPage fourthRegistrationPage = new FirstRegistrationPage()
                .selectOneRandomOption()
                .clickEnabledNextButton()
                .clickNextButton()
                .clickConnectButton()
                .setFirstNameField(faker.name().firstName())
                .setLastNameField(faker.name().lastName())
                .setCompanyNameField(faker.company().name())
                .setEmailField(email)
                .setPasswordField(password)
                .setRepeatPasswordField(password)
                .clickInactiveIveReadAndAcceptedTermsConditionsAndPrivacyPolicy()
                .clickActiveCreateAccountButton();
        Assertions.assertTrue(fourthRegistrationPage.isFieldIsRequiredForEmailFieldShown());

    }
}
