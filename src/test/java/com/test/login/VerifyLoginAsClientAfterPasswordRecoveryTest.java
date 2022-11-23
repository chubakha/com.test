package com.test.login;

import com.test.GenericPage;
import com.test.admin_panel.MainAdminPage;
import com.test.kanban.client_kanban.ClientKanbanPage;
import com.test.create_new_password.CreateNewPasswordOverlay;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class VerifyLoginAsClientAfterPasswordRecoveryTest extends PrepareLoginTestData{

    public static String password = faker.internet().password(8, 15);

    @Test
    void verifyLoginAsClientAfterPasswordRecovery(){
        new LoginCabinetPage()
                .clickForgotPasswordLink()
                .setEmailField(clientEmail)
                .clickSendButton();
        redirectToForgetPasswordToken(clientEmail);
        sleep(2000);

        new CreateNewPasswordOverlay()
                .setPasswordField(password)
                .setRetypePasswordField(password)
                .clickSendButton()
                .clickCloseButton();
        ClientKanbanPage clientKanbanPage = new LoginCabinetPage()
                .setEmailField(clientEmail)
                .setPasswordField(password)
                .loginAsClient();
        sleep(3000);
        Assertions.assertTrue(clientKanbanPage.isTaskRequestButtonShown(),
                String.format("'%s' button should be shown", clientKanbanPage.getTaskRequestButtonText()));
    }

    @AfterAll
    static void resetPasswordToDefault(){
        resetDefaultClientPassword(clientEmail);
    }

}
