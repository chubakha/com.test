package com.test.data_generation;

import com.test.GenericPage;
import com.test.PrepareOverallTestData;
import com.test.admin_panel.MainAdminPage;
import com.test.admin_panel.clients_section.ViewClientPage;
import com.test.admin_panel.onboarding_section.ViewOnboardingPage;
import com.test.cabinet.OfferStatusesType;
import com.test.cabinet.client_cabinet_page.ClientCabinetPage;
import com.test.cabinet.client_cabinet_page.CreateTaskRequestOverlay;
import com.test.cabinet.client_cabinet_page.DetailRequestPage;
import com.test.onboarding.WelcomePopupOverlay;
import com.test.registration.fourth_registration_page.ConfirmYourAccountOverlay;
import com.test.registration.fourth_registration_page.FourthRegistrationPage;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.test.PrepareOverallTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DataGeneration extends PrepareOverallTestData {

    @BeforeAll
    static void openPage(){
        open("https://cabinet.legalnodes.com/registration");
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
        Assertions.assertEquals("Please activate your account", confirmYourAccountOverlay.getPageTitle(),
                "'Please activate your account' page should be shown");
    }

    @Test
    @Order(2)
    @Description("activate new client")
    void activateNewClient(){
        ViewClientPage viewClientPage = GenericPage
                .openLoginAdminPage()
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
        WelcomePopupOverlay welcomePopupOverlay = GenericPage
                .openLoginPage()
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
        ViewOnboardingPage viewOnboardingPage = GenericPage
                .openLoginAdminPage()
                .setUsernameField(usernameAdmin)
                .setPasswordField(passwordAdmin)
                .loginAsAdmin()
                .clickOnboardingLink()
                .clickUpdateButton(4, "DataGenerationFirstName")
                .switchStageResultToDone()
                .clickSaveButton();
        sleep(500);
        Assertions.assertTrue(viewOnboardingPage.updateButtonIsShown(), "Update button should be shown");
    }

    @Test
    @Order(5)
    @Description("Passing Step 2 of Onboarding")
    void passingStep2Onboarding(){
        ViewOnboardingPage viewOnboardingPage = GenericPage
                .openAdminPageWithoutAuthorization()
                .clickOnboardingLink()
                .clickUpdateButton(3, "DataGenerationFirstName")
                .switchStageResultToDone()
                .clickSaveButton();
        sleep(500);
        Assertions.assertTrue(viewOnboardingPage.updateButtonIsShown(), "Update button should be shown");
    }

    @Test
    @Order(6)
    @Description("Passing Step 3 of Onboarding")
    void passingStep3Onboarding(){
        ViewOnboardingPage viewOnboardingPage = GenericPage
                .openAdminPageWithoutAuthorization()
                .clickOnboardingLink()
                .clickUpdateButton(2, "DataGenerationFirstName")
                .switchStageResultToDone()
                .clickSaveButton();
        sleep(500);
        Assertions.assertTrue(viewOnboardingPage.updateButtonIsShown(), "Update button should be shown");
    }

    @Test
    @Order(7)
    @Description("Passing Step 4 of Onboarding")
    void passingStep4Onboarding(){
        ViewOnboardingPage viewOnboardingPage = GenericPage
                .openAdminPageWithoutAuthorization()
                .clickOnboardingLink()
                .clickUpdateButton(1, "DataGenerationFirstName")
                .switchStageResultToDone()
                .clickSaveButton();
        sleep(500);
        Assertions.assertTrue(viewOnboardingPage.updateButtonIsShown(), "Update button should be shown");
    }

    @ParameterizedTest(name = "{index} - request name is {0}")
    @ValueSource(strings = { "1", "2", "3", "4", "5", "6", "7" })
    @Order(8)
    @Description("Registration of 7 requests")
    void registration7requests(String value){
        GenericPage
                .openLoginPage()
                .setEmailField(clientEmailDataGeneration)
                .setPasswordField(clientPasswordDataGeneration)
                .loginAsClient();
        sleep(3000);
        new ClientCabinetPage()
                .clickNewRequestButton()
                .clickCreateNewRequestButton();
        sleep(3000);
        DetailRequestPage detailRequestPage = new CreateTaskRequestOverlay()
                .setTitleField(value)
                .switchToDescriptionIframe()
                .setDescriptionField(value)
                .switchFocusToOverlay()
                .clickSubmitButton();
        sleep(2000);
        Assertions.assertEquals(OfferStatusesType.DISCUSS_WITH_VLO.getValue(), detailRequestPage.getRequestStatus(),
                String.format("'%s' status should be shown on a detail request page",
                        OfferStatusesType.DISCUSS_WITH_VLO.getValue()));
    }

    @ParameterizedTest(name = "{index} - request name is {0}")
    @ValueSource(strings = { "1", "2", "3", "4", "5", "6" })
    @Order(9)
    @Description("Move 6 requests to offers")
    void moveRequestsToOffer(String value){
        GenericPage
                .openLoginPage()
                .setEmailField(clientEmailDataGeneration)
                .setPasswordField(clientPasswordDataGeneration)
                .loginAsManager();
        sleep(3000);
        new ClientCabinetPage()
                .clickRequestCard(value)
                .clickTurnIntoOfferButton();
        sleep(2000);


    }
}
