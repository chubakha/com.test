package com.test.registration.first_registration_page;
import com.test.registration.PrepareRegistrationTestData;
import io.qameta.allure.Epic;
import io.qameta.allure.Flaky;
import io.qameta.allure.Owner;
import org.assertj.core.api.*;
import org.junit.jupiter.api.Test;


public class VerifyToolTipsPopupIsShownTest extends PrepareRegistrationTestData {

    @Test
    @Epic(value = "First registration page")
    @Owner(value = "Alex Chu")
    @Flaky
    void verifyToolTipsPopupIsShown(){
        FirstRegistrationPage firstRegistrationPage = new FirstRegistrationPage()
                .hoverOnEveryToolTipIcon();
        //Assertions.assertThat(firstRegistrationPage.toolTipTextArray).doesNotContain(false);
    }
}
