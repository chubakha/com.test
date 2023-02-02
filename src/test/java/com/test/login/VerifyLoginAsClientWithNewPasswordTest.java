package com.test.login;

import com.test.kanban.client_kanban.ClientKanbanPage;
import com.test.create_new_password.CreateNewPasswordOverlay;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class VerifyLoginAsClientWithNewPasswordTest extends PrepareLoginTestData {

    @Test
    void verifyLoginAsClientWithNewPassword(){

        String password = faker.internet().password(8, 15);
        new LoginCabinetPage()
                .clickForgotPasswordLink()
                .setEmailField(clientEmail)
                .clickSendButton();
        redirectToLinkFromEmail(clientEmail);
        ClientKanbanPage clientKanbanPage = new CreateNewPasswordOverlay()
                .setPasswordField(password)
                .setRetypePasswordField(password)
                .clickSendButton()
                .clickCloseButton()
                .setEmailField(clientEmail)
                .setPasswordField(password)
                .loginAsClient();
        Assertions.assertTrue(clientKanbanPage.isTaskRequestButtonShown(),
                String.format("'%s' button should be shown", clientKanbanPage.getTaskRequestButtonText()));
    }

    @AfterAll
    static void resetPasswordToDefault(){
        resetDefaultClientPassword(clientEmail);
    }
}
