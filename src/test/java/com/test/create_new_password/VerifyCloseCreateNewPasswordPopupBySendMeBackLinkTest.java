package com.test.create_new_password;

import com.test.login.LoginCabinetPage;
import com.test.login.PrepareLoginTestData;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.sleep;

public class VerifyCloseCreateNewPasswordPopupBySendMeBackLinkTest extends PrepareLoginTestData {

    @Test
    void verifyCloseCreateNewPasswordPopupBySendMeBackLink(){
        new LoginCabinetPage()
                .clickForgotPasswordLink()
                .setEmailField(clientEmail)
                .clickSendButton();
        redirectToForgetPasswordToken(clientEmail);
        System.out.println("2");
        sleep(2000);
        LoginCabinetPage loginCabinetPage = new CreateNewPasswordOverlay()
                .clickSendMeBackLink();
        sleep(2000);
        Assertions.assertFalse(loginCabinetPage.isForgotPasswordPopupShown(),
                "Create new password popup should not be displayed");
    }

    @AfterAll
    static void closeBrowser(){
        closeWindow();
    }
}
