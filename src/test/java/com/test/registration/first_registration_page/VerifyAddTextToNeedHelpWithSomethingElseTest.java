package com.test.registration.first_registration_page;

import com.github.javafaker.Faker;
import com.test.registration.PrepareRegistrationTestData;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Owner(value = PrepareRegistrationTestData.)
public class VerifyAddTextToNeedHelpWithSomethingElseTest extends PrepareRegistrationTestData {

    @Test
    @Epic(value = "First registration page")
    void verifyAddedTextNeedHelpWithSomethingElse() {
        String needHelpWithSomething = new Faker().name().fullName();
        CreateCustomRequestOverlay createCustomRequestOverlay = new FirstRegistrationPage()
                .clickNeedHelpWithSomethingElseButton()
                .setNeedHelpWithSomethingElse(needHelpWithSomething);
        Assertions.assertEquals(needHelpWithSomething, createCustomRequestOverlay.getNeedHelpWithSomethingElseText(),
                String.format("'%s' should be shown in ", needHelpWithSomething));
    }
}
