package com.test.registration.second_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class VerifyDeleteOneChosenOptionFromFewTest extends PrepareRegistrationTestData {

    @Test
    void verifyDeleteChosenOptionFromFew() {
        SecondRegistrationPage secondRegistrationPage = new FirstRegistrationPage()
                .selectOneCheckboxInEverySection()
                .clickEnabledNextButton();
        String deletedLeadValue = secondRegistrationPage.getRandomLead();
        secondRegistrationPage.deleteLead(deletedLeadValue);
        Assertions.assertFalse(Arrays.asList(secondRegistrationPage.getSelectedOptions()).contains(deletedLeadValue),
                String.format("deletingElement '%s' shouldn't be in the chosen list", deletedLeadValue));
    }
}
