package com.test;

import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class BaseTest {
    static {
        WebDriverManager.chromedriver().setup();
        Configuration.baseUrl = "https://cabinet.legalnodes.com";
        Configuration.assertionMode = AssertionMode.STRICT;
    }

    //test data
    static final String REGISTRATION_EMAIL = "auto-test-client@yopmail.com";
    static final String REGISTRATION_COMPANY_NAME = "Chubsung";
    static final String REGISTRATION_FIRST_NAME = "Alex";
    static final String REGISTRATION_LAST_NAME = "Chu";
    static final String REGISTRATION_PASSWORD1 = "12345678";
    static final String REGISTRATION_PASSWORD2 = "12345678";

    static final String STABLE_CLIENT_EMAIL = "client-yop@yopmail.com";
    static final String STABLE_CLIENT_PASSWORD = "12345678";
    static final String STABLE_MANAGER_EMAIL = "man-yop@yopmail.com";
    static final String STABLE_MANAGER_PASSWORD = "12345678";
    static final String STABLE_PROVIDER_EMAIL = "prov-yop@yopmail.com";
    static final String STABLE_PROVIDER_PASSWORD = "12345678";


}
