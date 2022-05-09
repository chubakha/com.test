package com.test.first_registration_page;

import com.test.registration.first_registration_page.CreateCustomRequestOverlay;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

///////////???????????

public class VerifyCloseNeedHelpWithSomethingElsePopupTest extends PrepareFirstRegistrationPageTestData {
    @Test
    void verifyCloseNeedHelpWithSomethingElsePopup(){
        CreateCustomRequestOverlay createCustomRequestOverlay =
                new FirstRegistrationPage()
                        .clickNeedHelpWithSomethingElseButton();
        FirstRegistrationPage firstRegistrationPage =
                new CreateCustomRequestOverlay()
                        .clickHelpWithSomethingElseClosePopup();
        Assertions.assertTrue(createCustomRequestOverlay.isNeedHelpWithSomethingElse(),"'Create Custom Request' should be shown");
    }
}
