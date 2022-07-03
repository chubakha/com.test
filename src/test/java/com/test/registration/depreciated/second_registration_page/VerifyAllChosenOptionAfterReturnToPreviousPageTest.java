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
public class VerifyAllChosenOptionAfterReturnToPreviousPageTest extends PrepareRegistrationTestData {

    @Test
    @Epic(value = STEP_SECOND_REGISTRATION_PAGE)
    void verifyChosenAllOptionAfterReturnToPreviousPage() {
        FirstRegistrationPage firstRegistrationPage = new FirstRegistrationPage()
                .selectAllCheckboxInEverySection();
        String[] chosenOptionBeforeRedirectToSecondRegistrationPage = firstRegistrationPage.getSelectedOptions();
        firstRegistrationPage
                .clickEnabledNextButton()
                .clickBackButton();
        Assertions.assertArrayEquals(chosenOptionBeforeRedirectToSecondRegistrationPage, firstRegistrationPage.getSelectedOptions(),
                "chosen list on first page registrations should be the same as " +
                        "after come back from second registration page on first registration page");

    }
}
