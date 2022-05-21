package com.test.registration.first_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyToolTipsTextTest extends PrepareRegistrationTestData {
    @Test
    void verifyToolTipsText() {
        String[] tipText = new FirstRegistrationPage().getToolTipText();
        String[] trueTip = WhatDoYouNeedLegallySolvedInfoTexts.getAllValues();
        Assertions.assertArrayEquals(trueTip, tipText, "Tips from 'enum WhatDoYouNeedLegallySolvedInfoTexts' enum file should be on page");
    }
}