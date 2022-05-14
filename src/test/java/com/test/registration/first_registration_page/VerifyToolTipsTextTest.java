package com.test.registration.first_registration_page;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyToolTipsTextTest extends PrepareFirstRegistrationPageTestData {
    @Test
    void verifyToolTipsText() {
        String[] tipText = new FirstRegistrationPage().getToolTipText();
        String[] trueTip = WhatDoYouNeedLegallySolvedInfoTexts.getAllValues();
        for (int i = 0; i < 9; i++){
            System.out.println(trueTip[i]);
        }
        Assertions.assertArrayEquals(trueTip, tipText, "Tips from 'enum WhatDoYouNeedLegallySolvedInfoTexts' enum file should be on page");
    }
}