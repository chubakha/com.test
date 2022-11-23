package com.test.forgot_password_mail;

import com.codeborne.selenide.SelenideElement;
import com.test.onboarding.HelloSignOverlay;

import java.util.Random;

import static com.codeborne.selenide.Selenide.*;

public class YopmailIncomingMailPage {
    private final SelenideElement mailHeader = $x("//div[contains(@class, 'ellipsis')]");
    private final SelenideElement mailSubject = $x("//pre");
    private final SelenideElement incomingMailIframe = $x("//iframe[@id='ifmail']");
    private final SelenideElement refreshButton = $x("//button[@id='refresh']");
    private final SelenideElement viewHelloSignDocument = $x("//span[contains(@style, 'color: rgba(247, 251, 253, 1)')]");

    public String getMailHeader(){
        return mailHeader.getText();
    }

    public String getMailSubject(){
        return mailSubject.getText();
    }

    public YopmailIncomingMailPage switchEmailIframe(){
        switchTo().frame(incomingMailIframe);
        return this;
    }

    public String getForgetPasswordToken(){
        String[] link = mailSubject.getText().split("https://")[1].split("\n");
        return "https://" + link[0];
    }

    public boolean isProd;

    public boolean isProductionDomainShown(String url){

        if (url.equals("https://stag.cabinet.legalnodes.co/")){
            isProd = false;
        }
        else{
            isProd = true;
        }
        return isProd;
    }

    public YopmailIncomingMailPage clickRefreshButton(){
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
}
