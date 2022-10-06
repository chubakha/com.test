package com.test.forgot_password_mail;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class YopmailMainPage {
    private final SelenideElement loginField = $x("//input[@name='login']");
    private final SelenideElement loginButton = $x("//button[contains(@title, '@yopmail.com')]");
    private final SelenideElement cookiesAcceptButton = $x("//button[contains(@id, 'accept')]");

    public YopmailMainPage setLoginField(String login){
        loginField.val(login);
        return this;
    }

    public YopmailIncomingMailPage clickLoginButton(){
        loginButton.click();
        return new YopmailIncomingMailPage();
    }

    public YopmailMainPage clickCookiesAcceptButton(){
        cookiesAcceptButton.click();
        return this;
    }
}
