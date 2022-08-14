package com.test;

import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.localStorage;
import static com.codeborne.selenide.Selenide.open;

public class PrepareOverallTestData {

    @BeforeAll
    static void overallLinksInitialization() {
        faker = new Faker();
    }

    public static Faker faker;

    public static void openAnyLink(String link){
        open(link);
    }

    /*@AfterEach
    void clearCookiesTest(){
        Selenide.clearBrowserCookies();
        localStorage().clear();
    }

    @AfterAll
    static void clearCookiesClass(){
        localStorage().clear();
    }*/


}
