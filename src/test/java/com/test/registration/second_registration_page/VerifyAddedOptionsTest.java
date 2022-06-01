package com.test.registration.second_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyAddedOptionsTest extends PrepareRegistrationTestData {
    @Test
    void verifyAddedOptions(){
        FirstRegistrationPage firstRegistrationPage = new FirstRegistrationPage().selectOneCheckboxInEverySection();
        String[] needListFirst = firstRegistrationPage.getSelectedOptions();
        firstRegistrationPage.clickEnabledNextButton();
        String[] needListSecond = firstRegistrationPage.getSelectedOptions();
        Assertions.assertArrayEquals(needListFirst, needListSecond, "chosen list on first page registrations should be equal to a list option on second page registration");

    }

}
