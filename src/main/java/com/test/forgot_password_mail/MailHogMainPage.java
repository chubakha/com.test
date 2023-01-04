package com.test.forgot_password_mail;

import static com.codeborne.selenide.Selenide.$x;

public class MailHogMainPage {

    public MailHogRecoveryPasswordMailPage clickRecoveryPasswordEmail(String email){
        $x("//div[contains(text(), '" + email + "')]").click();
        return new MailHogRecoveryPasswordMailPage();
    }

    public MailHogInvoiceMailPage clickInvoiceEmail(String email){
        $x("//div[contains(text(), '" + email + "')]").click();
        return new MailHogInvoiceMailPage();
    }
}
