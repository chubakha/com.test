package com.test.offer;

import com.codeborne.selenide.Configuration;
import com.test.PrepareOverallTestData;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;

public class PrepareOfferTestData extends PrepareOverallTestData {

    @BeforeEach
    void openPage() {
        //System.setProperty("webdriver.gecko.driver", "C:\\Users\\chuba\\Downloads\\geckodriver-v0.32.0-win64\\geckodriver.exe");
        //Configuration.browser = "firefox";
        open(domainCabinet);
    }

    @AfterEach
    void closeBrowser(){
        clearBrowserLocalStorage();
        localStorage().clear();
        clearBrowserCookies();
    }
}
