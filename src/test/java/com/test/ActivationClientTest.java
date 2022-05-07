package com.test;

import static com.codeborne.selenide.Selenide.*;

public class ActivationClientTest extends BaseTest {

    static void activateNewClient (){
        //allSteps();
        LoginPageAdminPage.enteringAdminLoginData();
        ClientsAdminPage.goToClientPageAdmin();
        ClientsAdminPage.goToLasClientPageAdmin();
        ClientsAdminPage.goToEditClientAdmin(REGISTRATION_EMAIL);
        ClientsAdminPage.doActiveClientAdmin();
        sleep(2000);
        ClientsAdminPage.saveClientAdmin();
        sleep(2000);
    }
}
