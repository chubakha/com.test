package com.test.registration;

import com.codeborne.selenide.Selenide;
import com.test.admin_panel.LoginAdminPage;
import com.test.admin_panel.PrepareAdminPanelTestData;
import com.test.admin_panel.clients_section.MainClientPage;
import com.test.admin_panel.clients_section.ViewClientPage;
import com.test.admin_panel.companies_section.MainCompaniesPage;
import com.test.login.LoginCabinetPage;
import com.test.login.PrepareLoginTestData;
import com.test.onboarding.WelcomePopupOverlay;
import com.test.registration.PrepareRegistrationTestData;
import com.test.registration.fourth_registration_page.ConfirmYourAccountOverlay;
import com.test.registration.fourth_registration_page.FourthRegistrationPage;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.localStorage;
import static com.codeborne.selenide.Selenide.sleep;
import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class VerifyLoginByNewClientTest extends PrepareRegistrationTestData {
    public static String passwordCurrent = faker.internet().password(8, 15, true);
    public static String emailCurrent = faker.internet().emailAddress();
    public static String companyCurrent = faker.company().name();

    @Test
    @Order(1)
    @Description("Registration new client")
    void registrationNewClient(){
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
    @Description("activate new client")
    void activateNewClient(){
        PrepareAdminPanelTestData.openLoginAdminPage();
        ViewClientPage viewClientPage = new LoginAdminPage()
                .setUsernameField(usernameAdmin)
                .setPasswordField(passwordAdmin)
                .loginAsAdmin()
                .clickClientsLink()
                .setClientSearchByEmailField(emailCurrent)
                .focusOutSearchFields()
                .clickUpdateButton()
                .switchStatusToActive()
                .clickSaveButton();
        sleep(500);
        Assertions.assertEquals("Active", viewClientPage.getStatusState(), "Page title should be shown");
    }

    @Test
    @Order(3)
    @Description("Login by new client")
    void verifyLoginByNewClient(){
        PrepareLoginTestData.openLoginPage();
        WelcomePopupOverlay welcomePopupOverlay = new LoginCabinetPage()
                .setEmailField(emailCurrent)
                .setPasswordField(passwordCurrent)
                .loginAsNewClient();
        sleep(3000);
        Assertions.assertTrue(welcomePopupOverlay.isPopupShown(),"Welcome popup should be shown");
    }

    @Test
    @Order(4)
    @Description("Delete new client")
    void deleteNewClient(){
        PrepareAdminPanelTestData.openLoginAdminPage();
        MainClientPage mainClientPage = new LoginAdminPage()
                .setUsernameField(usernameAdmin)
                .setPasswordField(passwordAdmin)
                .loginAsAdmin()
                .clickClientsLink()
                .setClientSearchByEmailField(emailCurrent)
                .focusOutSearchFields()
                .clickDeleteButton()
                .pressEnterKey()
                .setClientSearchByEmailField(emailCurrent)
                .focusOutSearchFields();
        Assertions.assertTrue(mainClientPage.isNoResultMessageShown(), "'No results found.' should be shown");
    }

    @Test
    @Order(5)
    @Description("Delete new company")
    void deleteNewCompany(){
        PrepareAdminPanelTestData.openLoginAdminPage();
        MainCompaniesPage mainCompaniesPage = new LoginAdminPage()
                .setUsernameField(usernameAdmin)
                .setPasswordField(passwordAdmin)
                .loginAsAdmin()
                .clickCompaniesLink()
                .setClientSearchByCompanyField(companyCurrent)
                .focusOutSearchFields()
                .clickDeleteButton()
                .pressEnterKey()
                .setClientSearchByCompanyField(companyCurrent)
                .focusOutSearchFields();
        Assertions.assertTrue(mainCompaniesPage.isNoResultMessageShown(), "'No results found.' should be shown");
    }

    @AfterEach
    void clearCookiesAndLocalStorage(){
        Selenide.clearBrowserCookies();
        localStorage().clear();
    }

    @AfterAll
    static void clearCookiesAndLocalStorage2(){
        Selenide.clearBrowserCookies();
        localStorage().clear();
    }

}
