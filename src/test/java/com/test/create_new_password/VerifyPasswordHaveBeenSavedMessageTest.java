package com.test.create_new_password;

import com.test.login.LoginCabinetPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class VerifyPasswordHaveBeenSavedMessageTest extends PrepareCreateNewPasswordData {

    @Test
    void verifyPasswordHaveBeenSavedMessage(){
        new LoginCabinetPage()
                .clickForgotPasswordLink()
                .setEmailField(clientEmail)
                .clickSendButton();
        redirectToLinkFromEmail(clientEmail);
        String password = faker.internet().password(8, 15);
        CreateNewPasswordOverlay createNewPasswordOverlay = new CreateNewPasswordOverlay()
                .setPasswordField(password)
                .setRetypePasswordField(password)
                .clickSendButton();
        Assertions.assertEquals("Password have been saved", createNewPasswordOverlay.getPasswordHaveBeenSavedTitle(),
                "'Password have been saved' should be shown");
    }

    @AfterAll
    static void resetPasswordToDefault(){
        resetDefaultClientPassword(clientEmail);
    }

}
