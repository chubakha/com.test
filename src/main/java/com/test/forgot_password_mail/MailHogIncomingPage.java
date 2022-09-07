package com.test.forgot_password_mail;

import com.codeborne.selenide.SelenideElement;
import com.test.GenericPage;

import java.util.Random;

import static com.codeborne.selenide.Selenide.$x;

public class MailHogIncomingPage extends GenericPage {

    private final SelenideElement mailSubject = $x("//div[contains(@id, 'preview-plain')]");
    private final SelenideElement mailHeader = $x("//strong[contains(@class, 'ng-binding')]");

    public String getForgetPasswordToken(){
        String[] link = mailSubject.getText().split("https://")[1].split("Best");
        String output = link[0].replace("cabinet.legalnodes.com", "stag.cabinet.legalnodes.co");
        return "https://" + output;
    }

    public String getForgetPasswordTokenMinusOneSymbol(){
        return getForgetPasswordToken().substring(0, getForgetPasswordToken().length() - 2);
    }

    public String getForgetPasswordTokenPlusOneSymbol(){
        Random r = new Random();
        char c = (char)(r.nextInt(26) + 'a');
        return getForgetPasswordToken() + c;
    }

    public String getMailHeader(){
        return mailHeader.getText();
    }

    public String getMailSubject(){
        return mailSubject.getText();
    }
}
