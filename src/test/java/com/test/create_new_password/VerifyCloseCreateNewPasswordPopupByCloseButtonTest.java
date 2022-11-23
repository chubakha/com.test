package com.test.create_new_password;

import com.test.GenericPage;
import com.test.login.LoginCabinetPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class VerifyCloseCreateNewPasswordPopupByCloseButtonTest extends PrepareCreateNewPasswordData {

    @Test
    void verifyCloseCreateNewPasswordPopupByCloseButton(){
        new LoginCabinetPage()
                .clickForgotPasswordLink()
                .setEmailField(clientEmail)
                .clickSendButton();
        redirectToForgetPasswordToken(clientEmail);
        sleep(2000);
        String password = faker.internet().password(8, 15);
        LoginCabinetPage loginCabinetPage = new CreateNewPasswordOverlay()
                .setPasswordField(password)
                .setRetypePasswordField(password)
                .clickSendButton()
                .clickCloseButton();
        sleep(500);
        Assertions.assertFalse(loginCabinetPage.isForgotPasswordPopupShown(),
                "Create new password popup should not be displayed");
    }

    @AfterAll
    static void resetPasswordToDefault(){
        resetDefaultClientPassword(clientEmail);
    }
}
