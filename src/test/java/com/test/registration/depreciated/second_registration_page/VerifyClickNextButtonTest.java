package com.test.registration.depreciated.second_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.RegistrationStepsType;
import com.test.registration.depreciated.first_registration_page.FirstRegistrationPage;
import com.test.registration.depreciated.third_page_registration.ThirdRegistrationPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifyClickNextButtonTest extends PrepareRegistrationTestData {

    @Test
    @Epic(value = STEP_SECOND_REGISTRATION_PAGE)
    void verifyClickNextButton(){
        ThirdRegistrationPage thirdRegistrationPage = new FirstRegistrationPage()
                .selectOneRandomOption()
                .clickEnabledNextButton()
                .clickNextButton();
        Assertions.assertEquals(RegistrationStepsType.REGISTRATION_STEP3.getValue(), thirdRegistrationPage.getStepNumber(),
                String.format("'%s' should be shown", RegistrationStepsType.REGISTRATION_STEP3.getValue()));
    }
}
