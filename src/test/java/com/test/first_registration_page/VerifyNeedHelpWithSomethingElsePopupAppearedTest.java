package com.test.first_registration_page;

import com.test.registration.first_registration_page.CreateCustomRequestOverlay;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyNeedHelpWithSomethingElsePopupAppearedTest extends PrepareFirstRegistrationPageTestData {
    @Test
    void verifyNeedHelpWithSomethingElsePopupAppeared() {
        CreateCustomRequestOverlay createCustomRequestOverlay =
                new FirstRegistrationPage()
                        .clickNeedHelpWithSomethingElseButton();
        Assertions.assertTrue(createCustomRequestOverlay.isNeedHelpWithSomethingElse(),"'Create Custom Request' should be shown");
    }
}
