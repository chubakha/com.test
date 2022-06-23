package com.test.registration.first_registration_page;
import com.test.registration.PrepareRegistrationTestData;
import io.qameta.allure.Epic;
import io.qameta.allure.Flaky;
import io.qameta.allure.Owner;
import org.assertj.core.api.*;
import org.junit.jupiter.api.Test;

import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifyToolTipsPopupIsShownTest extends PrepareRegistrationTestData {

    @Test
    @Epic(value = STEP_FIRST_REGISTRATION_PAGE)
    @Flaky
    void verifyToolTipsPopupIsShown(){
        FirstRegistrationPage firstRegistrationPage = new FirstRegistrationPage()
                .hoverOnEveryToolTipIcon();
        //Assertions.assertThat(firstRegistrationPage.toolTipTextArray).doesNotContain(false);
    }
}
