package com.test.notifications;

import com.test.PrepareOverallTestData;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.clearBrowserCookies;

public class PrepareClientNotificationsData extends PrepareOverallTestData {

    @BeforeAll
    static void openPage(){
        open(domainCabinet);
    }

    @AfterEach
    void closeBrowser(){
        clearBrowserLocalStorage();
        localStorage().clear();
        clearBrowserCookies();
    }
}
