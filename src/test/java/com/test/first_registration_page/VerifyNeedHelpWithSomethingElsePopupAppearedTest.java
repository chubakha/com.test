package com.test.first_registration_page;

import com.test.registration.first_registration_page.CreateCustomRequestOverlay;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class VerifyNeedHelpWithSomethingElsePopupAppearedTest extends PrepareFirstRegistrationPageTestData {
    @Test
    void verifyNeedHelpWithSomethingElsePopupAppeared() {
        CreateCustomRequestOverlay createCustomRequestOverlay =
                new FirstRegistrationPage()
                        .clickNeedHelpWithSomethingElseButton();
        sleep(3000);
        Assertions.assertTrue(createCustomRequestOverlay.isNeedHelpWithSomethingElse(),"'Create Custom Request' should be shown");
    }
}
