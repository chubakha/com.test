package com.test.login;

import com.test.kanban.manager_kanban.ManagerKanbanPage;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;
import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifyLoginAsManagerTest extends PrepareLoginTestData {

    @Test
    void loginAsManager() {
        ManagerKanbanPage managerKanbanPage = new LoginCabinetPage()
                .setEmailField(managerEmail)
                .setPasswordField(managerPassword)
                .loginAsManager();
        sleep(3000);
        Assertions.assertTrue(managerKanbanPage.isNewOfferButtonShown(),
                String.format("'%s' button should be shown", managerKanbanPage.getNewOfferButtonText()));
    }
}
