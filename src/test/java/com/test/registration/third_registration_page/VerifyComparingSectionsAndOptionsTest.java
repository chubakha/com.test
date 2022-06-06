package com.test.registration.third_registration_page;

import com.test.registration.Functions;
import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import com.test.registration.third_page_registration.ThirdRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyComparingSectionsAndOptionsTest extends PrepareRegistrationTestData {
    @Test
    void verifyComparingSectionsAndOptions(){
        ThirdRegistrationPage thirdRegistrationPage = new FirstRegistrationPage()
                .selectOneRandomOption()
                .clickEnabledNextButton()
                .clickNextButton();
        Assertions.assertTrue(new Functions().compareSectionAndOption(thirdRegistrationPage.getOneChosenOption(),
                thirdRegistrationPage.getSectionForChosenOption()),
                "chosen option on first registration page should be correspond to section");
    }
}
