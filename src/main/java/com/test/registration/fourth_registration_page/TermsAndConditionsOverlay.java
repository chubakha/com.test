package com.test.registration.fourth_registration_page;

import com.codeborne.selenide.Selenide;

import com.codeborne.selenide.Condition;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class TermsAndConditionsOverlay {
    public String getTermsAndConditionsTitle (){
        $("title").shouldHave(Condition.text("terms-and-conditions.pdf - Google"), Duration.ofMillis(15000));
        return Selenide.title();
    }
}
