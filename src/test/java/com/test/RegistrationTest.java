package com.test;

import com.test.registration.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Selenide.*;

public class RegistrationTest extends BaseTest {

    @BeforeEach
    void openPage(){
        open("https://signup.legalnodes.com/registration");
    }

    @Test //positive tests
    void testTest(){
        new FirstRegistrationPage().clickRandomIncorporationCheckBox();
        sleep(1000);
    }



/*    private static void allSteps(){
        RegistrationPage registration = new RegistrationPage();
        registration.clickRegistrationOptionCheckBox();
        registration.clickRegistrationNextBtn();
        sleep(1000);
        registration.clickRegistrationNextBtn();
        sleep(1000);
        registration.clickRegistrationNextBtn();
        sleep(1000);
    }

    private static boolean companyRegistrationEnteringData(String first_name, String last_name, String company, String email, String password1, String password2){
        $("[placeholder='First name']").val(first_name);
        $("[placeholder='Last name']").val(last_name);
        $("[placeholder='Company']").val(company);
        $("[placeholder='Email']").val(email);
        $("[placeholder='Password']").val(password1);
        $("[placeholder='Repeat password']").val(password2);
        RegistrationPage registration = new RegistrationPage();
        registration.clickRegistrationPrivacyPolicy();
        registration.clickRegistrationNextBtn();
        sleep(3000);
        return $(".FinishStep_container_heading__NWuvW").exists();
    }

    @Test //positive tests
    void positiveTests(){
        allSteps();
        Assertions.assertTrue(companyRegistrationEnteringData(REGISTRATION_FIRST_NAME, REGISTRATION_LAST_NAME, REGISTRATION_COMPANY_NAME, REGISTRATION_EMAIL, REGISTRATION_PASSWORD1, REGISTRATION_PASSWORD2));
        ActivationClientTest.activateNewClient();
    }

    @Test //passwords don't match
    void checkPasswordDontMatch(){
        allSteps();
        Assertions.assertFalse(companyRegistrationEnteringData(REGISTRATION_FIRST_NAME, REGISTRATION_LAST_NAME, REGISTRATION_COMPANY_NAME, REGISTRATION_EMAIL, REGISTRATION_PASSWORD1,"1234567"));
    }
    @Test //password too short
    void checkPasswordTooShort(){
        allSteps();
        Assertions.assertFalse(companyRegistrationEnteringData(REGISTRATION_FIRST_NAME, REGISTRATION_LAST_NAME, REGISTRATION_COMPANY_NAME, REGISTRATION_EMAIL,"1234567","1234567"));
    }
    @Test //password is empty
    void checkPasswordIsEmpty(){
        allSteps();
        Assertions.assertFalse(companyRegistrationEnteringData(REGISTRATION_FIRST_NAME, REGISTRATION_LAST_NAME, REGISTRATION_COMPANY_NAME, REGISTRATION_EMAIL,"",""));
    }
    @Test //email without "@"
    void checkEmailWithoutAt(){
        allSteps();
        Assertions.assertFalse(companyRegistrationEnteringData(REGISTRATION_FIRST_NAME, REGISTRATION_LAST_NAME, REGISTRATION_COMPANY_NAME, "auto-test-clientyopmail.com", REGISTRATION_PASSWORD1, REGISTRATION_PASSWORD2));
    }
*/
}
