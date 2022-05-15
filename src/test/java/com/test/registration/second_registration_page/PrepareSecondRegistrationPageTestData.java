package com.test.registration.second_registration_page;

import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class PrepareSecondRegistrationPageTestData {
    @BeforeEach
    void openPage(){
        open("https://signup.legalnodes.com/registration");
    }
}