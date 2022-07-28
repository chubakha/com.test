package com.test.registration.fourth_registration_page;

import com.test.admin_panel.LoginAdminPage;
import com.test.admin_panel.PreparingAdminPanelTestData;
import com.test.admin_panel.client_section.MainClientPage;
import com.test.cabinet.client_cabinet_page.ClientCabinetPage;
import com.test.login.ClientLoginPage;
import com.test.login.PrepareLoginTestData;
import com.test.registration.PrepareRegistrationTestData;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;

import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class VerifyLoginByNewClientTest extends PrepareRegistrationTestData {
    public static String passwordCurrent = faker.internet().password(8, 15, true);
    public static String emailCurrent = faker.internet().emailAddress();
    public static String companyCurrent = faker.company().name();

    @Test
    @Order(1)
    void verifyRegistrationNewClient(){
        ConfirmYourAccountOverlay confirmYourAccountOverlay = new FourthRegistrationPage()
                .setFirstNameField(faker.name().firstName())
                .setLastNameField(faker.name().lastName())
                .setCompanyNameField(companyCurrent)
                .setEmailField(emailCurrent)
                .setPasswordField(passwordCurrent)
                .setRepeatPasswordField(passwordCurrent)
                .clickInactiveIveReadAndAcceptedTermsConditionsAndPrivacyPolicy()
                .clickActiveCreateAccountButton();
        Assertions.assertEquals("Confirm your account", confirmYourAccountOverlay.getPageTitle(),
                "'Confirm your account' page should be shown");
    }

    @Test
    @Order(2)
    void verifyLoginByNewClient(){
        PrepareLoginTestData.openLoginPage();
        ClientCabinetPage clientCabinetPage = new ClientLoginPage()
                .setEmailField(emailCurrent)
                .setPasswordField(passwordCurrent)
                .loginAsClient();
        Assertions.assertTrue(clientCabinetPage.isTaskRequestShownButton(),
                String.format("'%s' button should be shown", clientCabinetPage.getTaskRequestButtonText()));
    }

    @Test
    @Order(3)
    void deleteNewClient(){
        PreparingAdminPanelTestData.openLoginAdminPage();
        MainClientPage mainClientPage = new LoginAdminPage()
                .setUsernameField(usernameAdmin)
                .setPasswordField(passwordAdmin)
                .loginAsAdmin()
                .clickClientsLink()
                .setClientSearchByEmailField(emailCurrent)
                .focusOutSearchFields()
                .clickDeleteButton()
                .pressEnterKey();
    }

    @Test
    @Order(4)
    void deleteNewCompany(){
        PreparingAdminPanelTestData.openLoginAdminPage();

    }
}
