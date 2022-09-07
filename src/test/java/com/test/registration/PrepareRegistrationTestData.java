package com.test.registration;

import com.test.PrepareOverallTestData;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.open;

public class PrepareRegistrationTestData extends PrepareOverallTestData {

    public static WebDriver driver;

    @BeforeEach
    void openPage(){
        open("https://stag.cabinet.legalnodes.co/registration");
    }
}
