package com.test.registration.second_registration_page;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimap;
import com.test.registration.Functions;
import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class VerifyComparingSectionsAndOptionsTest extends PrepareRegistrationTestData {
    @Test
    void verifyComparingSectionsAndOptions(){
        new FirstRegistrationPage().choiceOneRandomCheckbox();
        //sleep(3000);
        String chosenOption = new SecondRegistrationPage().getOneChosenOption();
        String chosenSection = new SecondRegistrationPage().getOneChosenSection();
        boolean sectionIsRight = new Functions().compareSectionAndOption(chosenOption, chosenSection);
        Assertions.assertTrue(sectionIsRight, "chosen option on first registration page should be correspond to section");
    }
}
