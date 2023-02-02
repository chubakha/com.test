package com.test.create_new_password;

import com.test.login.LoginCabinetPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyCloseCreateNewPasswordPopupByCloseButtonTest extends PrepareCreateNewPasswordData {

    @Test
    void verifyCloseCreateNewPasswordPopupByCloseButton(){
        new LoginCabinetPage()
                .clickForgotPasswordLink()
                .setEmailField(clientEmail)
                .clickSendButton();
        redirectToLinkFromEmail(clientEmail);
        String password = faker.internet().password(8, 15);
        LoginCabinetPage loginCabinetPage = new CreateNewPasswordOverlay()
                .setPasswordField(password)
                .setRetypePasswordField(password)
                .clickSendButton()
                .clickCloseButton();
        Assertions.assertFalse(loginCabinetPage.isForgotPasswordPopupShown(),
                "Create new password popup should not be displayed");
    }

    @AfterAll
    static void resetPasswordToDefault(){
        resetDefaultClientPassword(clientEmail);
    }
}
