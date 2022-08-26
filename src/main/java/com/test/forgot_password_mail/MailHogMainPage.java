package com.test.forgot_password_mail;

import static com.codeborne.selenide.Selenide.$x;

public class MailHogMainPage {

    public MailHogIncomingPage clickIncomingEmail(String email){
        $x("//div[contains(text(), '" + email + "')]").click();
        return new MailHogIncomingPage();
    }
}
