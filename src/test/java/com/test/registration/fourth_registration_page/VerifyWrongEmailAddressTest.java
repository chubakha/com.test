package com.test.registration.fourth_registration_page;

import com.github.javafaker.Faker;
import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifyWrongEmailAddressTest extends PrepareRegistrationTestData {

    @Disabled
    @ParameterizedTest
    @ValueSource(strings = {"testgmail.com", "test@@gmail.com", "test@gmailcom", "test@gmail", "test@gmail,com", "gmail.com", "test@.com", "test@com", "test@gmail.c", "test@gmail.comcom", "test@gmail.com.com", "почта@gmail.com", "test@гмаил.com", ".test@gmail.com", "test.@gmail.com", "test!@gmail.com", "test?@gmail.com"})
    @Epic(value = STEP_FOURTH_REGISTRATION_PAGE)
    void verifyWrongEmailAddress(String email) {
        Faker userData = new Faker();
        String password = userData.internet().password(8, 15);
        FourthRegistrationPage fourthRegistrationPage = new FirstRegistrationPage()
                .selectOneRandomOption()
                .clickEnabledNextButton()
                .clickNextButton()
                .clickConnectButton()
                .setFirstNameField(userData.name().firstName())
                .setLastNameField(userData.name().lastName())
                .setCompanyNameField(userData.company().name())
                .setEmailField(email)
                .setPasswordField(password)
                .setRepeatPasswordField(password)
                .clickInactiveIveReadAndAcceptedTermsConditionsAndPrivacyPolicy()
                .clickActiveCreateAccountButton();
        Assertions.assertTrue(fourthRegistrationPage.isFieldIsRequiredForEmailFieldShown());

    }
}
