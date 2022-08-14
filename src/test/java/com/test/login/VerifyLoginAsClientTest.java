package com.test.login;

import com.test.cabinet.client_cabinet_page.ClientCabinetPage;
import com.test.cabinet.manager_cabinet_page.ManagerCabinetPage;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Selenide.localStorage;
import static com.codeborne.selenide.Selenide.sleep;
import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifyLoginAsClientTest extends PrepareLoginTestData {

    @Test
    void loginAsClient() {
        ClientCabinetPage clientCabinetPage = new LoginCabinetPage()
                .setEmailField(clientEmail)
                .setPasswordField(clientPassword)
                .loginAsClient();
        sleep(3000);
        Assertions.assertTrue(clientCabinetPage.isTaskRequestButtonShown(),
                String.format("'%s' button should be shown", clientCabinetPage.getTaskRequestButtonText()));
    }

    @AfterAll
    static void logOutManagerCabinet(){
        new ManagerCabinetPage()
                .clickLogOutLink();
    }

}
