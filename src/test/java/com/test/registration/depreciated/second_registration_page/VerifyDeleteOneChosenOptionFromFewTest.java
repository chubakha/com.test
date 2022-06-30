package com.test.registration.depreciated.second_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.depreciated.first_registration_page.FirstRegistrationPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifyDeleteOneChosenOptionFromFewTest extends PrepareRegistrationTestData {

    @Test
    @Epic(value = STEP_SECOND_REGISTRATION_PAGE)
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
