package com.test.forgot_password_mail;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainYopmailPage {
    private final SelenideElement loginField = $x("//input[@name='login']");
    private final SelenideElement loginButton = $x("//button[contains(@title, '@yopmail.com')]");

    public MainYopmailPage setLoginField(String login){
        loginField.val(login);
        return this;
    }

    public IncomingMailPage clickLoginButton(){
        loginButton.click();
        return new IncomingMailPage();
    }
}
