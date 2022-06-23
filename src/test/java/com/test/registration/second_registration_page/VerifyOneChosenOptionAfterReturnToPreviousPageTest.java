package com.test.registration.second_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifyOneChosenOptionAfterReturnToPreviousPageTest extends PrepareRegistrationTestData {

    @Test
    @Epic(value = STEP_SECOND_REGISTRATION_PAGE)
    void verifyChosenOneOptionAfterReturnToPreviousPage() {
        SecondRegistrationPage secondRegistrationPage = new FirstRegistrationPage()
                .selectOneRandomOption()
                .clickEnabledNextButton();
        String[] chosenOptionOnSecond = secondRegistrationPage
                .getSelectedOptions();
        FirstRegistrationPage firstRegistrationPage = secondRegistrationPage
                .clickBackButton();
        Assertions.assertArrayEquals(chosenOptionOnSecond, firstRegistrationPage.getSelectedOptions(),
                "chosen list on first page registrations should be equal to a list option on second page registration");

    }
}
