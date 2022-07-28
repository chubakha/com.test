package com.test.login;

import com.test.cabinet.manager_cabinet_page.ManagerCabinetPage;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifyLoginAsManagerPageTest extends PrepareLoginTestData {

    @Test
    void loginAsManagerPage() throws IOException {
        /*FileInputStream fileInputStream;
        Properties prop = new Properties();
        fileInputStream = new FileInputStream("src/test/resources/credentials.properties");
        prop.load(fileInputStream);
        String email = prop.getProperty("stag.manager.email");
        String password = prop.getProperty("stag.manager.password");*/

        ManagerCabinetPage managerCabinetPage = new ClientLoginPage()
                .setEmailField(managerEmail)
                .setPasswordField(managerPassword)
                .loginAsManager();
        //sleep(5000);
        Assertions.assertTrue(managerCabinetPage.isNewOfferButtonShown(),
                String.format("'%s' button should be shown", managerCabinetPage.getNewOfferButtonText()));
    }



}
