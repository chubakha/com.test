package com.test.registration.depreciated.first_registration_page;

import com.github.javafaker.Faker;
import com.test.registration.PrepareRegistrationTestData;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifyDeleteNeedHelpWithSomethingElseTest extends PrepareRegistrationTestData {

    @Test
    @Epic(value = STEP_FIRST_REGISTRATION_PAGE)
    void verifyDeleteNeedHelpWithSomethingElse() {
        FirstRegistrationPage firstRegistrationPage = new FirstRegistrationPage()
                .clickNeedHelpWithSomethingElseButton()
                .setNeedHelpWithSomethingElse(faker.name().fullName())
                .clickNeedHelpWithSomethingElseSendButton()
                .deleteNeedHelpWithSomethingElse();
        Assertions.assertEquals("NEED HELP WITH SOMETHING ELSE?", firstRegistrationPage.getNeedHelpWithSomethingElseTitle(),
                "'NEED HELP WITH SOMETHING ELSE?' should be shown");
    }
}
