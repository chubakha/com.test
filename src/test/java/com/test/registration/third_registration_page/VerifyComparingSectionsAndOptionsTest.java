package com.test.registration.third_registration_page;

import com.test.registration.Functions;
import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import com.test.registration.second_registration_page.SecondRegistrationPage;
import com.test.registration.third_page_registration.ThirdRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class VerifyComparingSectionsAndOptionsTest extends PrepareRegistrationTestData {
    @Test
    void verifyComparingSectionsAndOptions(){
        new FirstRegistrationPage()
                .selectOneRandomOption()
                .clickEnabledNextButton();
        sleep(1000);
        new SecondRegistrationPage().clickNextButton();
        String chosenOption = new ThirdRegistrationPage().getOneChosenOption();
        String chosenSection = new ThirdRegistrationPage().getOneChosenSection();
        boolean sectionIsRight = new Functions().compareSectionAndOption(chosenOption, chosenSection);
        Assertions.assertTrue(sectionIsRight, "chosen option on first registration page should be correspond to section");
    }
}
