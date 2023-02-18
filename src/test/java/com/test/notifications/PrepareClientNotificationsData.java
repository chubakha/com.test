package com.test.notifications;

import com.test.PrepareOverallTestData;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.clearBrowserCookies;

public class PrepareClientNotificationsData extends PrepareOverallTestData {

    @BeforeAll
    static void openPage(){
        open(domainCabinet);
    }

    @AfterAll
    static void closeBrowser(){
        clearBrowserLocalStorage();
        localStorage().clear();
        clearBrowserCookies();
    }
}
