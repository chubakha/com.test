package com.test.forgot_password_mail;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class MailHogMainPage {

    private final SelenideElement deleteAllMessageLink = $x("//a[@ng-click = 'deleteAll()']");

    public MailHogRecoveryPasswordMailPage clickRecoveryPasswordEmail(String email){
        $x("//div[contains(text(), '" + email + "')]").click();
        return new MailHogRecoveryPasswordMailPage();
    }

    public MailHogInvoiceMailPage clickInvoiceEmail(String email){
        $x("//div[contains(text(), '" + email + "')]").click();
        return new MailHogInvoiceMailPage();
    }

    public MailHogDeleteAllMessageOverlayPage clickDeleteAllMessageLink(){
        deleteAllMessageLink.click();
        return new MailHogDeleteAllMessageOverlayPage();
    }
}
