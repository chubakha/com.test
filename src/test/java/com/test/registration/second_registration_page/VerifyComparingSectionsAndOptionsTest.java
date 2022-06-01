package com.test.registration.second_registration_page;

import com.test.registration.Functions;
import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyComparingSectionsAndOptionsTest extends PrepareRegistrationTestData {
    @Test
    void verifyComparingSectionsAndOptions(){
        new FirstRegistrationPage().selectOneRandomOptionAndRedirectOnSecondRegistrationPage();
        //sleep(3000);
        String chosenOption = new SecondRegistrationPage().getOneChosenOption();
        String chosenSection = new SecondRegistrationPage().getOneChosenSection();
        boolean sectionIsRight = new Functions().compareSectionAndOption(chosenOption, chosenSection);
        Assertions.assertTrue(sectionIsRight, "chosen option on first registration page should be correspond to section");
    }
}
