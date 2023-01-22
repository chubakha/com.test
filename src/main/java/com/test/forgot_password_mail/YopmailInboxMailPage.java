package com.test.forgot_password_mail;

import com.codeborne.selenide.SelenideElement;
import com.test.onboarding.HelloSignOverlay;

import java.util.Random;

import static com.codeborne.selenide.Selenide.*;

public class YopmailInboxMailPage {
    private final SelenideElement mailHeader = $x("//div[contains(@class, 'ellipsis')]");
    private final SelenideElement mailSubject = $x("//pre");
    private final SelenideElement incomingMailIframe = $x("//iframe[@id='ifmail']");
    private final SelenideElement refreshButton = $x("//button[@id='refresh']");
    private final SelenideElement viewHelloSignDocument = $x("//a[contains(@style, 'margin: 0; border: 0 solid rgba(30, 180, 228, 1)')]");
    private final SelenideElement invoiceMailSubject = $x("//table//table//table//p[2]");

    public String getMailHeader(){
        return mailHeader.getText();
    }

    public String getMailSubject(){
        return mailSubject.getText();
    }

    public YopmailInboxMailPage switchEmailIframe(){
        switchTo().frame(incomingMailIframe);
        return this;
    }

    public String getForgetPasswordToken(){
        String[] link = mailSubject.getText().split("https://")[1].split("\n");
        return "https://" + link[0];
    }

    public YopmailInboxMailPage clickRefreshButton(){
        refreshButton.click();
        return this;
    }

    public String getForgetPasswordTokenMinusOneSymbol(){
        return getForgetPasswordToken().substring(0, getForgetPasswordToken().length() - 2);
    }

    public String getForgetPasswordTokenPlusOneSymbol(){
        Random r = new Random();
        char c = (char)(r.nextInt(26) + 'a');
        return getForgetPasswordToken() + c;
    }

    public HelloSignOverlay clickViewHelloSignDocument(){
        viewHelloSignDocument.click();
        return new HelloSignOverlay();
    }

    public String getInvoiceCurrency(){
        sleep(2000);
        int startCurrencyPosition = invoiceMailSubject.getOwnText().indexOf("for ") + 4;
        return invoiceMailSubject.getOwnText().substring(startCurrencyPosition,
                startCurrencyPosition + 3);
    }
}
