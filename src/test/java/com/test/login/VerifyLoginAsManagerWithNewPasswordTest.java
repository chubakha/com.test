package com.test.login;

import com.test.kanban.manager_kanban.ManagerKanbanPage;
import com.test.create_new_password.CreateNewPasswordOverlay;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class VerifyLoginAsManagerWithNewPasswordTest extends PrepareLoginTestData {

    @Test
    void verifyLoginAsManagerWithNewPassword(){

        String password = faker.internet().password(8, 15);
        new LoginCabinetPage()
                .clickForgotPasswordLink()
                .setEmailField(dataGenerationManagerEmail)
                .clickSendButton();
        redirectToLinkFromEmail(dataGenerationManagerEmail);
        ManagerKanbanPage managerKanbanPage = new CreateNewPasswordOverlay()
                .setPasswordField(password)
                .setRetypePasswordField(password)
                .clickSendButton()
                .clickCloseButton()
                .setEmailField(dataGenerationManagerEmail)
                .setPasswordField(password)
                .loginAsManager();
        Assertions.assertTrue(managerKanbanPage.isNewOfferButtonShown(),
                String.format("'%s' button should be shown", managerKanbanPage.getNewOfferButtonText()));
    }

    @AfterAll
    static void resetPasswordToDefault(){
        resetDefaultManagerPassword(dataGenerationManagerEmail);
    }
}
