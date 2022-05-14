package com.test.registration.first_registration_page;

import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class PrepareFirstRegistrationPageTestData {
    @BeforeEach
    void openPage(){
        open("https://signup.legalnodes.com/registration");
    }
}
