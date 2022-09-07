package com.test.forgot_password_mail;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class YopmailIncomingMailPage {
    private final SelenideElement mailHeader = $x("//div[contains(@class, 'ellipsis')]");
    private final SelenideElement mailSubject = $x("//pre");
    private final SelenideElement incomingMailIframe = $x("//iframe[@id='ifmail']");
    private final SelenideElement refreshButton = $x("//button[@id='refresh']");

    public String getMailHeader(){
        return mailHeader.getText();
    }

    public String getMailSubject(){
        return mailSubject.getText();
    }

    public YopmailIncomingMailPage switchIframe(){
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
}
