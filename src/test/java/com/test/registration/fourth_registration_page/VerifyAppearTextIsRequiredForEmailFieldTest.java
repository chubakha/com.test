package com.test.registration.fourth_registration_page;

import com.github.javafaker.Faker;
import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.depreciated.first_registration_page.FirstRegistrationPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifyAppearTextIsRequiredForEmailFieldTest extends PrepareRegistrationTestData {

    @Test
    @Epic(value = STEP_FOURTH_REGISTRATION_PAGE)
    void verifyAppearTextIsRequiredForEmailField() {
        String currentPassword = faker.internet().password(8, 30);
        FourthRegistrationPage fourthRegistrationPage = new FirstRegistrationPage()
                .selectOneRandomOption()
                .clickEnabledNextButton()
                .clickNextButton()
                .clickConnectButton()
                .setFirstNameField(faker.name().firstName())
                .setLastNameField(faker.name().lastName())
                .setCompanyNameField(faker.company().name())
                .setPasswordField(currentPassword)
                .setRepeatPasswordField(currentPassword)
                .clickInactiveIveReadAndAcceptedTermsConditionsAndPrivacyPolicy()
                .clickInactiveCreateAccountButton();
        Assertions.assertEquals("field is required", fourthRegistrationPage.getFieldIsRequiredForEmailField(),
                "'field is required' should be shown below Email field");
    }
}
