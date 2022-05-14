package com.test.registration.first_registration_page;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class VerifyToolTipsPopupIsShownTest extends PrepareFirstRegistrationPageTestData {
    @Test
    void verifyToolTipsPopupIsShown(){
        boolean textHintArray[] = new FirstRegistrationPage().hoverAllInfoIcon();
        boolean trueArray[] = new boolean[textHintArray.length];
        Arrays.fill(trueArray, true);
        Assertions.assertArrayEquals(trueArray, textHintArray, "Every text hint should be shown after hovering");
    }
}
