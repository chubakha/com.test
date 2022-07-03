package com.test.registration.depreciated.second_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.depreciated.first_registration_page.FirstRegistrationPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifyChosenOptionsTest extends PrepareRegistrationTestData {

    @Test
    @Epic(value = STEP_SECOND_REGISTRATION_PAGE)
    void verifyAddedOptions(){
        FirstRegistrationPage firstRegistrationPage = new FirstRegistrationPage()
                .selectOneCheckboxInEverySection();
        String[] chosenOptionBeforeRedirectToSecondRegistrationPage = firstRegistrationPage.getSelectedOptions();
        firstRegistrationPage.clickEnabledNextButton();
        Assertions.assertArrayEquals(chosenOptionBeforeRedirectToSecondRegistrationPage, new SecondRegistrationPage().getSelectedOptions(),
                "chosen list on first page registrations should be equal to a list option on second page registration");

    }

}
