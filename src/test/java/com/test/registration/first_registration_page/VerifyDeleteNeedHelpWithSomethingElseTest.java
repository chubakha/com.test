package com.test.registration.first_registration_page;

import com.github.javafaker.Faker;
import com.test.registration.PrepareRegistrationTestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyDeleteNeedHelpWithSomethingElseTest extends PrepareRegistrationTestData {
    @Test
    void verifyDeleteNeedHelpWithSomethingElse() {
        Faker faker = new Faker();
        FirstRegistrationPage firstRegistrationPage = new FirstRegistrationPage()
                .clickNeedHelpWithSomethingElseButton()
                .setNeedHelpWithSomethingElseText(faker.name().fullName())
                .clickNeedHelpWithSomethingElseSendButton()
                .deleteNeedHelpWithSomethingElse();
        Assertions.assertEquals(firstRegistrationPage.getNeedHelpWithSomethingElseTitle(), "NEED HELP WITH SOMETHING ELSE?", "'NEED HELP WITH SOMETHING ELSE?' should be shown");
    }
}
