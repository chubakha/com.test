package com.test.login;

import com.test.cabinet.client_cabinet_page.ClientKanbanPage;
import com.test.cabinet.manager_cabinet_page.ManagerKanbanPage;
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
        sleep(3000);
        Assertions.assertTrue(clientKanbanPage.isTaskRequestButtonShown(),
                String.format("'%s' button should be shown", clientKanbanPage.getTaskRequestButtonText()));
    }

    @AfterAll
    static void logOutManagerCabinet(){
        new ManagerKanbanPage()
                .clickLogOutLink();
    }

}
