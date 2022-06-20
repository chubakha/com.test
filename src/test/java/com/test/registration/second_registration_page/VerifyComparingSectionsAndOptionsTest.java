package com.test.registration.second_registration_page;

import com.test.registration.Functions;
import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class VerifyComparingSectionsAndOptionsTest extends PrepareRegistrationTestData {

    @Test
    void verifyComparingSectionsAndOptions(){
        SecondRegistrationPage secondRegistrationPage = new FirstRegistrationPage()
                .selectOneRandomOption()
                .clickEnabledNextButton();
        Assertions.assertTrue(new Functions().compareSectionAndOption(secondRegistrationPage.getOneChosenOption(),
                secondRegistrationPage.getOneChosenSection()),
                "chosen option on first registration page should be correspond to section");
    }
}
