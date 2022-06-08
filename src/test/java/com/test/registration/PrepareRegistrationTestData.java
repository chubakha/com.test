package com.test.registration;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class PrepareRegistrationTestData {
    @BeforeEach
    void openPage(){
        //setUp();
        open("https://stag.legalnodes.co/registration");
    }

    public void setUp() {
        Configuration.headless = true;
    }
}
