package com.test.login;

import com.test.kanban.client_kanban.ClientKanbanPage;
import com.test.kanban.manager_kanban.ManagerKanbanPage;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Selenide.sleep;
import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifyLoginAsClientTest extends PrepareLoginTestData {

    @Test
    void loginAsClient() {
        ClientKanbanPage clientKanbanPage = new LoginCabinetPage()
                .setEmailField(clientEmail)
                .setPasswordField(clientPassword)
                .loginAsClient();
        Assertions.assertTrue(clientKanbanPage.isTaskRequestButtonShown(),
                String.format("'%s' button should be shown", clientKanbanPage.getTaskRequestButtonText()));
    }

}
