package com.test.registration.third_registration_page;

import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class PrepareThirdRegistrationPageTestData {
    @BeforeEach
    void openPage(){
        open("https://signup.legalnodes.com/registration");
    }
}
