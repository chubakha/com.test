package com.test.registration.first_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyPageTitleTextTest extends PrepareRegistrationTestData {

    @Test
    @Epic(value = "First registration page")
    @Owner(value = "Alex Chu")
    void verifyWhatDoYouNeedLegallySolvedTitle(){
        String actualPageTitle = new FirstRegistrationPage().getPageTitle();
        Assertions.assertEquals("What do you need legally solved?", actualPageTitle,
                "'What do you need legally solved?' should be shown");
    }
}
