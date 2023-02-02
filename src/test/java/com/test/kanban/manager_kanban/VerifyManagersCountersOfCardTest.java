package com.test.kanban.manager_kanban;

import com.test.kanban.PrepareKanbanTestData;
import com.test.login.LoginCabinetPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class VerifyManagersCountersOfCardTest extends PrepareKanbanTestData {
    @Test
    void verifyManagersCountersOfCard(){
        ManagerKanbanPage managerKanbanPage = new LoginCabinetPage()
                .setEmailField(dataGenerationManagerEmail)
                .setPasswordField(dataGenerationManagerPassword)
                .loginAsManager()
                .clickCompanyListDropdown()
                .clickCompanyInDropdown("DataGenerationCompany");
        Assertions.assertAll(
                () -> Assertions.assertEquals("1", managerKanbanPage.getAmountOfRequest(),
                        "Amount of requests should be equal to '1'"),
                () -> Assertions.assertEquals("4", managerKanbanPage.getAmountOfNewOffers(),
                        "Amount of new offers should be equal to '4'"),
                () -> Assertions.assertEquals("1", managerKanbanPage.getAmountOfTasksInProgress(),
                        "Amount of tasks in progress should be equal to '1'"),
                () -> Assertions.assertEquals("1", managerKanbanPage.getAmountOfTasksComplete(),
                        "Amount of tasks complete should be equal to '1'")
        );
    }
}
