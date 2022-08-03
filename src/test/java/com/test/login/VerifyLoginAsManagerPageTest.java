package com.test.login;

import com.test.cabinet.manager_cabinet_page.ManagerCabinetPage;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.sleep;
import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifyLoginAsManagerPageTest extends PrepareLoginTestData {

    @Test
    void loginAsManagerPage() throws IOException {
        ManagerCabinetPage managerCabinetPage = new LoginCabinetPage()
                .setEmailField(managerEmail)
                .setPasswordField(managerPassword)
                .loginAsManager();
        sleep(3000);
        Assertions.assertTrue(managerCabinetPage.isNewOfferButtonShown(),
                String.format("'%s' button should be shown", managerCabinetPage.getNewOfferButtonText()));
    }

    @Test
    @Order(2)
    void logOutManagerCabinet(){
        LoginCabinetPage loginCabinetPage = new ManagerCabinetPage()
                .clickLogOutLink();
        Assertions.assertEquals("Sign in to access your Legal Nodes workspace and communicate with your " +
                        "Virtual Legal Officer",
                loginCabinetPage.getPageTitle());
    }



}
