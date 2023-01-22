package com.test.forgot_password_mail;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class YopmailMainPage {
    private final SelenideElement loginField = $x("//input[@name='login']");
    private final SelenideElement loginButton = $x("//button[contains(@title, '@yopmail.com')]");
    private final SelenideElement cookiesAcceptButton = $x("//button[contains(@id, 'accept')]");

    public YopmailMainPage setLoginField(String login){
        loginField.val(login);
        return this;
    }

    public YopmailInboxMailPage clickLoginButton(){
        sleep(8000);
        loginButton.click();
        return new YopmailInboxMailPage();
    }

    public YopmailMainPage clickCookiesAcceptButton(){
        cookiesAcceptButton.click();
        return this;
    }

}
