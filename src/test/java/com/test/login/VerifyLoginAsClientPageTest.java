package com.test.login;

import com.test.cabinet.client_cabinet_page.ClientCabinetPage;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Selenide.sleep;
import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifyLoginAsClientPageTest extends PrepareLoginTestData {

    @Test
    @Order(1)
    void loginAsClientPage() {
        ClientCabinetPage clientCabinetPage = new LoginCabinetPage()
                .setEmailField(clientEmail)
                .setPasswordField(clientPassword)
                .loginAsClient();
        sleep(3000);
        Assertions.assertTrue(clientCabinetPage.isTaskRequestButtonShown(),
                String.format("'%s' button should be shown", clientCabinetPage.getTaskRequestButtonText()));
    }

    @Test
    @Order(2)
    void logOutClientCabinet(){
        LoginCabinetPage loginCabinetPage = new ClientCabinetPage()
                .clickLogOutLink();
        Assertions.assertEquals("Sign in to access your Legal Nodes workspace and communicate with your " +
                        "Virtual Legal Officer",
        loginCabinetPage.getPageTitle());
    }

}
