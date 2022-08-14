package com.test.forgot_password_mail;

import com.test.create_new_password.CreateNewPasswordOverlay;
import com.test.login.LoginCabinetPage;
import com.test.login.PrepareLoginTestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.url;

public class VerifyRedirectForgotPasswordLinkTest extends PrepareLoginTestData {

    @Test
    void verifyRedirectForgotPasswordLink(){
        new LoginCabinetPage()
                .clickForgotPasswordLink()
                .setEmailField(clientEmail)
                .clickSendButton();
        boolean isProd = new IncomingMailPage().isProductionDomainShown(url());
        openYopmailPage();
        new MainYopmailPage()
                .setLoginField(clientEmail)
                .clickLoginButton()
                .clickRefreshButton()
                .switchIframe();
        if(isProd == true){
            openAnyLink(new IncomingMailPage().getProductionForgetPasswordToken());
        }
        else {
            openAnyLink(new IncomingMailPage().getStagingForgetPasswordToken());
        }
        sleep(2000);
        Assertions.assertEquals("Reset Password",
                new CreateNewPasswordOverlay().getOverlayTitle(), "'Reset Password' should be shown on overlay");
    }
}
