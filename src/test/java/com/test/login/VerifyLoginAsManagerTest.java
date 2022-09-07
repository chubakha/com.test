package com.test.login;

import com.test.cabinet.client_cabinet_page.ClientCabinetPage;
import com.test.cabinet.manager_cabinet_page.ManagerCabinetPage;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.sleep;
import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifyLoginAsManagerTest extends PrepareLoginTestData {

    @Test
    void loginAsManagerPage() throws IOException {
        ManagerCabinetPage managerCabinetPage = new LoginCabinetPage()
                .setEmailField(managerEmail)
                .setPasswordField(managerPassword)
                .loginAsManager();
        sleep(5000);
        Assertions.assertTrue(managerCabinetPage.isNewOfferButtonShown(),
                String.format("'%s' button should be shown", managerCabinetPage.getNewOfferButtonText()));
    }

    @AfterAll
    static void logOutManagerCabinet(){
        new ManagerCabinetPage()
                .clickLogOutLink();
    }



}