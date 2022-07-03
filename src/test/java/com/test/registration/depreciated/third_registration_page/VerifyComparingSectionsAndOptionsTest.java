package com.test.registration.depreciated.third_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifyComparingSectionsAndOptionsTest extends PrepareRegistrationTestData {

    @Test
    @Epic(value = STEP_THIRD_REGISTRATION_PAGE)
    void verifyComparingSectionsAndOptions(){
        /*ThirdRegistrationPage thirdRegistrationPage = new FirstRegistrationPage()
                .selectOneRandomOption()
                .clickEnabledNextButton()
                .clickNextButton();
        Assertions.assertTrue(new Functions().compareSectionAndOption(thirdRegistrationPage.getOneChosenOption(),
                thirdRegistrationPage.getSectionForChosenOption()),
                "chosen option on first registration page should be correspond to section");*/
    }
}
