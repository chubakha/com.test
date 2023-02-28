package com.test.mailers;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MailHogDeleteAllMessageOverlayPage {

    private final SelenideElement deleteAllMessageLink = $x("//button[contains(text(), 'Delete all messages')]");

    public MailHogMainPage clickDeleteAllMessageLink(){
        deleteAllMessageLink.click();
        return new MailHogMainPage();
    }
}
