package com.test.login;

import com.test.GenericPage;
import com.test.mailers.MailHogRecoveryPasswordMailPage;
import com.test.mailers.YopmailInboxMailPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
            new YopmailInboxMailPage()
                    .clickRefreshButton()
                    .switchEmailIframe();
            GenericPage.openAnyLink(new YopmailInboxMailPage().getForgetPasswordTokenPlusOneSymbol());
        }
        else {
            GenericPage
                    .openMailHogPage()
                    .clickRecoveryPasswordEmail(clientEmail);
            GenericPage.openAnyLink(new MailHogRecoveryPasswordMailPage().getForgetPasswordTokenPlusOneSymbol());
        }
        Assertions.assertFalse(new LoginCabinetPage().isForgotPasswordPopupShown(),
                "Create new password popup should not be displayed");
    }

    @AfterAll
    static void resetPasswordToDefault(){
        resetDefaultClientPassword(clientEmail);
    }
}
