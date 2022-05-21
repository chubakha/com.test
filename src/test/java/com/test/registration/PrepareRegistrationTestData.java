package com.test.registration;

import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class PrepareRegistrationTestData {
    @BeforeEach
    void openPage(){
        open("https://signup.legalnodes.com/registration");
    }
}
