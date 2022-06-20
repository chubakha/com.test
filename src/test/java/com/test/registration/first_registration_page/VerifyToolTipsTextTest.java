package com.test.registration.first_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class VerifyToolTipsTextTest extends PrepareRegistrationTestData {

    @Disabled
    @Test
    @Epic(value = "First registration page")
    @Owner(value = "Alex Chu")
    void verifyToolTipsText() {
        String[] actualTipText = new FirstRegistrationPage()
                .getAllToolTipsText();
        String[] expectedTipText = WhatDoYouNeedLegallySolvedInfoTexts.getAllValues();
        Assertions.assertArrayEquals(expectedTipText, actualTipText,
                "Tips from 'enum WhatDoYouNeedLegallySolvedInfoTexts' enum file should be on page");
    }
}