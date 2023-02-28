package com.test.mailers;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class MailHogNewRequestHasCreatedMailNotificationPage {

    private final SelenideElement mailSubject = $x("//*[contains(@id, 'preview-html')]");

    public String getMailContent(){
        sleep(1000);
        return mailSubject.getAttribute("srcdoc");
    }

}
