package com.test.data_generation;

import com.test.PrepareOverallTestData;
import com.test.admin_panel.LoginAdminPage;
import com.test.admin_panel.MainAdminPage;
import com.test.admin_panel.PrepareAdminPanelTestData;
import com.test.admin_panel.clients_section.ViewClientPage;
import com.test.admin_panel.onboarding_section.ViewOnboardingPage;
import com.test.login.LoginCabinetPage;
import com.test.login.PrepareLoginTestData;
import com.test.onboarding.WelcomePopupOverlay;
import com.test.registration.fourth_registration_page.ConfirmYourAccountOverlay;
import com.test.registration.fourth_registration_page.FourthRegistrationPage;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.test.PrepareOverallTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DataGeneration extends PrepareOverallTestData {

    @BeforeAll
    static void openPage(){
        open("https://stag.cabinet.legalnodes.co/registration");
    }

    @Test
    @Order(1)
    @Description("Registration new client")
    void registrationNewClient(){
        ConfirmYourAccountOverlay confirmYourAccountOverlay = new FourthRegistrationPage()
                .setFirstNameField("DataGenerationFirstName")
                .setLastNameField("DataGenerationLastName")
                .setCompanyNameField("DataGenerationCompany")
                .setEmailField(clientEmailDataGeneration)
                .setPasswordField(clientPasswordDataGeneration)
                .setRepeatPasswordField(clientPasswordDataGeneration)
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
                .setClientSearchByEmailField(clientEmailDataGeneration)
                .focusOutSearchFields()
                .clickUpdateButton()
                .switchStatusToActive()
                .clickSaveButton();
        sleep(500);
        Assertions.assertEquals("Active", viewClientPage.getStatusState(), "Page title should be shown");
        sleep(500);
        new MainAdminPage().clickLogoutLink();
        sleep(500);
    }

    @Test
    @Order(3)
    @Description("Login by new client")
    void verifyLoginByNewClient(){
        PrepareLoginTestData.openLoginPage();
        WelcomePopupOverlay welcomePopupOverlay = new LoginCabinetPage()
                .setEmailField(clientEmailDataGeneration)
                .setPasswordField(clientPasswordDataGeneration)
                .loginAsNewClient();
        sleep(3000);
        Assertions.assertTrue(welcomePopupOverlay.isPopupShown(),"Welcome popup should be shown");
    }

    @Test
    @Order(4)
    @Description("Passing Step 1 of Onboarding")
    void passingStep1Onboarding(){
        PrepareAdminPanelTestData.openLoginAdminPage();
        ViewOnboardingPage viewOnboardingPage = new LoginAdminPage()
                .setUsernameField(usernameAdmin)
                .setPasswordField(passwordAdmin)
                .loginAsAdmin()
                .clickOnboardingLink()
                .clickUpdateButton(4, "DataGenerationFirstName")
                .switchStageResultToDone()
                .clickSaveButton();
        sleep(500);
        Assertions.assertTrue(viewOnboardingPage.updateButtonIsShown(), "Update button should be shown");
        sleep(500);
        new MainAdminPage().clickLogoutLink();
        sleep(500);
    }

    @Test
    @Order(5)
    @Description("Passing Step 2 of Onboarding")
    void passingStep2Onboarding(){
        PrepareAdminPanelTestData.openLoginAdminPage();
        ViewOnboardingPage viewOnboardingPage = new MainAdminPage()
                .clickOnboardingLink()
                .clickUpdateButton(3, "DataGenerationFirstName")
                .switchStageResultToDone()
                .clickSaveButton();
        sleep(500);
        Assertions.assertTrue(viewOnboardingPage.updateButtonIsShown(), "Update button should be shown");
        sleep(500);
        new MainAdminPage().clickLogoutLink();
        sleep(500);
    }

    @Test
    @Order(6)
    @Description("Passing Step 3 of Onboarding")
    void passingStep3Onboarding(){
        PrepareAdminPanelTestData.openLoginAdminPage();
        ViewOnboardingPage viewOnboardingPage = new MainAdminPage()
                .clickOnboardingLink()
                .clickUpdateButton(2, "DataGenerationFirstName")
                .switchStageResultToDone()
                .clickSaveButton();
        sleep(500);
        Assertions.assertTrue(viewOnboardingPage.updateButtonIsShown(), "Update button should be shown");
        sleep(500);
        new MainAdminPage().clickLogoutLink();
        sleep(500);
    }

    @Test
    @Order(7)
    @Description("Passing Step 4 of Onboarding")
    void passingStep4Onboarding(){
        PrepareAdminPanelTestData.openLoginAdminPage();
        ViewOnboardingPage viewOnboardingPage = new MainAdminPage()
                .clickOnboardingLink()
                .clickUpdateButton(1, "DataGenerationFirstName")
                .switchStageResultToDone()
                .clickSaveButton();
        sleep(500);
        Assertions.assertTrue(viewOnboardingPage.updateButtonIsShown(), "Update button should be shown");
        sleep(500);
        new MainAdminPage().clickLogoutLink();
        sleep(500);
    }
}
