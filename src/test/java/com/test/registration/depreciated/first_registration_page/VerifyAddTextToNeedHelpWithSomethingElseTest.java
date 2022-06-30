package com.test.registration.depreciated.first_registration_page;

import com.github.javafaker.Faker;
import com.test.registration.PrepareRegistrationTestData;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.test.registration.PrepareRegistrationTestData.*;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifyAddTextToNeedHelpWithSomethingElseTest extends PrepareRegistrationTestData {

    @Test
    @Epic(value = STEP_FIRST_REGISTRATION_PAGE)
    void verifyAddedTextNeedHelpWithSomethingElse() {
        String needHelpWithSomething = faker.name().fullName();
        CreateCustomRequestOverlay createCustomRequestOverlay = new FirstRegistrationPage()
                .clickNeedHelpWithSomethingElseButton()
                .setNeedHelpWithSomethingElse(needHelpWithSomething);
        Assertions.assertEquals(needHelpWithSomething, createCustomRequestOverlay.getNeedHelpWithSomethingElseText(),
                String.format("'%s' should be shown", needHelpWithSomething));
    }
}
