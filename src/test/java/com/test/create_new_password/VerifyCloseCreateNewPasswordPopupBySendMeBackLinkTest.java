package com.test.create_new_password;

import com.test.login.LoginCabinetPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class VerifyCloseCreateNewPasswordPopupBySendMeBackLinkTest extends PrepareCreateNewPasswordData {

    @Test
    void verifyCloseCreateNewPasswordPopupBySendMeBackLink(){
        new LoginCabinetPage()
                .clickForgotPasswordLink()
                .setEmailField(clientEmail)
                .clickSendButton();
        redirectToLinkFromEmail(clientEmail);
        LoginCabinetPage loginCabinetPage = new CreateNewPasswordOverlay()
                .clickSendMeBackLink();
        Assertions.assertFalse(loginCabinetPage.isForgotPasswordPopupShown(),
                "Create new password popup should not be displayed");
    }
}
