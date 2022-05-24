package com.test.registration;

import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class PrepareRegistrationTestData {
    @BeforeEach
    void openPage(){
        open("https://signup.legalnodes.com/registration");
    }

    public String FIRST_NAME_REGISTRATION_TEST_CLIENT = "TestClientFirstName";
    public String LAST_NAME_REGISTRATION_TEST_CLIENT = "TestClientLastName";
    public String COMPANY_REGISTRATION_TEST_CLIENT = "Test-company";
    public String EMAIL_REGISTRATION_TEST_CLIENT = "client-yop-test@yopmail.com";
    public String PASSWORD_REGISTRATION_TEST_CLIENT = "12345678";
    public String REPEAT_PASSWORD_REGISTRATION_TEST_CLIENT = "12345678";
}
