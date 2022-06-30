package com.test.registration.depreciated.first_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifyToolTipsTextTest extends PrepareRegistrationTestData {

    @Disabled
    @Test
    @Epic(value = STEP_FIRST_REGISTRATION_PAGE)
    void verifyToolTipsText() {
        String[] actualTipText = new FirstRegistrationPage()
                .getAllToolTipsText();
        String[] expectedTipText = WhatDoYouNeedLegallySolvedInfoTexts.getAllValues();
        Assertions.assertArrayEquals(expectedTipText, actualTipText,
                "Tips from 'enum WhatDoYouNeedLegallySolvedInfoTexts' enum file should be on page");
    }
}