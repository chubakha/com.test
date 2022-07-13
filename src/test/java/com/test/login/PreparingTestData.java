package com.test.login;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class PreparingTestData {

    @BeforeEach
    void openPage(){
        //setUp();
        open("https://stag.cabinet.legalnodes.co/");
    }

    public void setUp() {
        Configuration.headless = true;
    }
}
