package com.test.login;

import com.test.GenericPage;
import com.test.forgot_password_mail.MailHogRecoveryPasswordMailPage;
import com.test.forgot_password_mail.YopmailInboxMailPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class VerifyTokenPlusOneSymbolTest extends PrepareLoginTestData {

    @Test
    void verifyTokenPlusOneSymbol(){

        new LoginCabinetPage()
                .clickForgotPasswordLink()
                .setEmailField(clientEmail)
                .clickSendButton();
        boolean isProd = isProductionDomainShown(url());
        if(isProd){
            GenericPage
                    .openYopmailPage()
                    .setLoginField(clientEmail)
                    .clickLoginButton();
            sleep(2000);
            new YopmailInboxMailPage()
                    .clickRefreshButton()
                    .switchEmailIframe();
            sleep(2000);
            GenericPage.openAnyLink(new YopmailInboxMailPage().getForgetPasswordTokenPlusOneSymbol());
        }
        else {
            GenericPage
                    .openMailHogPage()
                    .clickRecoveryPasswordEmail(clientEmail);
            GenericPage.openAnyLink(new MailHogRecoveryPasswordMailPage().getForgetPasswordTokenPlusOneSymbol());
        }
        sleep(2000);
        Assertions.assertFalse(new LoginCabinetPage().isForgotPasswordPopupShown(),
                "Create new password popup should not be displayed");
    }

    @AfterAll
    static void resetPasswordToDefault(){
        resetDefaultClientPassword(clientEmail);
    }
}
