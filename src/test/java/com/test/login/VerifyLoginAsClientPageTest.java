package com.test.login;

import com.test.cabinet.client_cabinet_page.ClientCabinetPage;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


import static com.codeborne.selenide.Selenide.sleep;
import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifyLoginAsClientPageTest extends PrepareLoginTestData {

    @Test
    void loginAsClientPage() {

        ClientCabinetPage clientCabinetPage = new LoginPage()
                .setEmailField(email)
                .setPasswordField(password)
                .loginAsClient();
        //sleep(5000);
        Assertions.assertTrue(clientCabinetPage.isTaskRequestShownButton(),
                String.format("'%s' button should be shown", clientCabinetPage.getTaskRequestButtonText()));
    }



}