package com.test.forgot_password_mail;

import com.codeborne.selenide.SelenideElement;

import java.util.Random;

import static com.codeborne.selenide.Selenide.*;

public class IncomingMailPage {
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

    public IncomingMailPage switchIframe(){
        switchTo().frame(incomingMailIframe);
        return this;
    }

    public String getProductionForgetPasswordToken(){
        String[] link = mailSubject.getText().split("https://")[1].split("\n");
        return "https://" + link[0];
    }

    public String getStagingForgetPasswordToken(){
        String[] link = mailSubject.getText().split("https://")[1].split("\n");
        String output = link[0].replace("cabinet.legalnodes.com", "stag.cabinet.legalnodes.co");
        return "https://" + output;
    }

    public String getProductionForgetPasswordTokenMinusOneSymbol(){
        return getProductionForgetPasswordToken().substring(0, getProductionForgetPasswordToken().length() - 1);
    }

    public String getStagingForgetPasswordTokenMinusOneSymbol(){
        return getStagingForgetPasswordToken().substring(0, getStagingForgetPasswordToken().length() - 1);
    }

    public String getProductionForgetPasswordTokenPlusOneSymbol(){
        Random r = new Random();
        char c = (char)(r.nextInt(26) + 'a');
        return getProductionForgetPasswordToken() + c;
    }

    public String getStagingForgetPasswordTokenPlusOneSymbol(){
        Random r = new Random();
        char c = (char)(r.nextInt(26) + 'a');
        return getStagingForgetPasswordToken() + c;
    }

    public boolean isProductionDomainShown(String url){
        boolean isProd;
        if (url.equals("https://stag.cabinet.legalnodes.co/")){
            isProd = false;
        }
        else{
            isProd = true;
        }
        return isProd;
    }

    public IncomingMailPage clickRefreshButton(){
        refreshButton.click();
        return this;
    }
}
