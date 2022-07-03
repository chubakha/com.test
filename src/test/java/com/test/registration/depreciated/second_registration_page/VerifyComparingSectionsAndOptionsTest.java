package com.test.registration.depreciated.second_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifyComparingSectionsAndOptionsTest extends PrepareRegistrationTestData {

    @Test
    @Epic(value = STEP_SECOND_REGISTRATION_PAGE)
    void verifyComparingSectionsAndOptions(){
     /*   SecondRegistrationPage secondRegistrationPage = new FirstRegistrationPage()
                .selectOneRandomOption()
                .clickEnabledNextButton();
        Assertions.assertTrue(new Functions().compareSectionAndOption(secondRegistrationPage.getOneChosenOption(),
                secondRegistrationPage.getOneChosenSection()),
                "chosen option on first registration page should be correspond to section");*/
    }
}
