package com.test.registration.first_registration_page;
import com.test.registration.PrepareRegistrationTestData;
import org.assertj.core.api.*;
import org.junit.jupiter.api.Test;


public class VerifyToolTipsPopupIsShownTest extends PrepareRegistrationTestData {
    @Test
    void verifyToolTipsPopupIsShown(){
        FirstRegistrationPage firstRegistrationPage = new FirstRegistrationPage()
                .hoverOnEveryToolTipIcon();
        Assertions.assertThat(firstRegistrationPage.toolTipTextArray).doesNotContain(false);
    }
}
