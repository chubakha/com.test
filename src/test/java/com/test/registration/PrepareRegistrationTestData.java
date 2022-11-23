package com.test.registration;

import com.test.PrepareOverallTestData;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.clearBrowserCookies;

public class PrepareRegistrationTestData extends PrepareOverallTestData {

    public static WebDriver driver;

    @BeforeEach
    void openPage(){
        //setUp();
        open(domainCabinet + "/registration");
    }

    @AfterEach
    void closeBrowser(){
        clearBrowserLocalStorage();
        localStorage().clear();
    }
}
