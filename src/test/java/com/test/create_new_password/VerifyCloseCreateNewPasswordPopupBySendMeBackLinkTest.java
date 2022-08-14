package com.test.create_new_password;

import com.test.login.LoginCabinetPage;
import com.test.login.PrepareLoginTestData;
import com.test.forgot_password_mail.IncomingMailPage;
import com.test.forgot_password_mail.MainYopmailPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.url;

public class VerifyCloseCreateNewPasswordPopupBySendMeBackLinkTest extends PrepareLoginTestData {

    @Test
    void verifyCloseCreateNewPasswordPopupBySendMeBackLink(){
        new LoginCabinetPage()
                .clickForgotPasswordLink()
                .setEmailField(clientEmail)
                .clickSendButton();
        boolean isProd = new IncomingMailPage().isProductionDomainShown(url());
        openYopmailPage();
        new MainYopmailPage()
                .setLoginField(clientEmail)
                .clickLoginButton();
        sleep(2000);
        new IncomingMailPage().clickRefreshButton()
                .switchIframe();
        if(isProd){
            openAnyLink(new IncomingMailPage().getProductionForgetPasswordToken());
        }
        else {
            openAnyLink(new IncomingMailPage().getStagingForgetPasswordToken());
        }
        sleep(2000);
        LoginCabinetPage loginCabinetPage = new CreateNewPasswordOverlay()
                .clickSendMeBackLink();
        sleep(2000);
        Assertions.assertFalse(loginCabinetPage.isForgotPasswordPopupShown(),
                "Create new password popup should not be displayed");
    }
}
