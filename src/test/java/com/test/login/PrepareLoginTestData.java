package com.test.login;

import com.codeborne.selenide.Configuration;
import com.test.PrepareOverallTestData;
import com.test.forgot_password_mail.MailHogIncomingPage;
import com.test.forgot_password_mail.MailHogMainPage;
import com.test.forgot_password_mail.YopmailIncomingMailPage;
import com.test.forgot_password_mail.YopmailMainPage;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.url;

public class PrepareLoginTestData extends PrepareOverallTestData {

    @BeforeEach
    void openPage() {
        //setUp();
        open("https://stag.cabinet.legalnodes.co/");
    }

    public static void openLoginPage(){
        open("https://stag.cabinet.legalnodes.co/");
    }

    public static void openYopmailPage(){
        open("https://yopmail.com/ru/");
    }

    public static void redirectToForgetPasswordToken(String email){
        boolean isProd = new YopmailIncomingMailPage().isProductionDomainShown(url());
        if(isProd){
            openYopmailPage();
            new YopmailMainPage()
                    .setLoginField(email)
                    .clickLoginButton();
            sleep(2000);
            new YopmailIncomingMailPage()
                    .clickRefreshButton()
                    .switchIframe();
            sleep(2000);
            openAnyLink(new YopmailIncomingMailPage().getForgetPasswordToken());
        }
        else {
            openMailHogPage();
            new MailHogMainPage().
                    clickIncomingEmail(email);
            openAnyLink(new MailHogIncomingPage().getForgetPasswordToken());
        }
    }

    public static void openMailHogPage(){
        open("https://stag.mailer.legalnodes.co/");
    }

    public void setUp() {
        Configuration.headless = true;
    }

}
