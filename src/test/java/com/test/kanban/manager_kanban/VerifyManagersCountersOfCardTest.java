package com.test.kanban.manager_kanban;

import com.test.cabinet.client_cabinet_page.ClientKanbanPage;
import com.test.cabinet.manager_cabinet_page.ManagerKanbanPage;
import com.test.kanban.PrepareKanbanTestData;
import com.test.login.LoginCabinetPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class VerifyManagersCountersOfCardTest extends PrepareKanbanTestData {
    @Test
    void verifyManagersCountersOfCard(){
        ManagerKanbanPage managerKanbanPage = new LoginCabinetPage()
                .setEmailField(managerEmail)
                .setPasswordField(managerPassword)
                .loginAsManager()
                .clickCompanyListDropdown()
                .clickCompanyInDropdown("DataGenerationCompany");
        sleep(3000);
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
