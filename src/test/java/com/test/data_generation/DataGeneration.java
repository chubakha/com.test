package com.test.data_generation;

import com.test.GenericPage;
import com.test.PrepareOverallTestData;
import com.test.admin_panel.MainAdminPage;
import com.test.admin_panel.clients_section.ViewClientPage;
import com.test.admin_panel.onboarding_section.ViewOnboardingPage;
import com.test.cabinet.OfferStatusesType;
import com.test.cabinet.client_cabinet_page.ClientKanbanPage;
import com.test.cabinet.client_cabinet_page.CreateTaskRequestOverlay;
import com.test.cabinet.client_cabinet_page.ClientDetailOfferPage;
import com.test.cabinet.client_cabinet_page.ClientDetailRequestPage;
import com.test.cabinet.manager_cabinet_page.ManagerKanbanPage;
import com.test.cabinet.manager_cabinet_page.ManagerDetailOfferPage;
import com.test.onboarding.WelcomePopupOverlay;
import com.test.registration.fourth_registration_page.ConfirmYourAccountOverlay;
import com.test.registration.fourth_registration_page.FourthRegistrationPage;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.*;
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
        Assertions.assertEquals("Please activate your account", confirmYourAccountOverlay.getPageTitle(),
                "'Please activate your account' page should be shown");
    }

    @Test
    @Order(2)
    @Description("activate new client")
    void activateNewClient(){
        ViewClientPage viewClientPage = GenericPage
                .openLoginAdminPage()
                .setUsernameField(stageUsernameAdmin)
                .setPasswordField(stagePasswordAdmin)
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
    @Description("Login by new client for creation onboarding stages")
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
                .setUsernameField(stageUsernameAdmin)
                .setPasswordField(stagePasswordAdmin)
                .loginAsAdmin()
                .clickClientsLink()
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
                .clickClientsLink()
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
                .clickClientsLink()
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
                .clickClientsLink()
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
        new ClientKanbanPage()
                .clickNewRequestButton()
                .clickCreateNewRequestButton();
        sleep(3000);
        ClientDetailRequestPage clientDetailRequestPage = new CreateTaskRequestOverlay()
                .setTitleField(value)
                .switchToDescriptionIframe()
                .setDescriptionField(value)
                .switchFocusToOverlay()
                .clickSubmitButton();
        sleep(2000);
        Assertions.assertEquals(OfferStatusesType.DISCUSS_WITH_VLO.getValue(), clientDetailRequestPage.getRequestStatus(),
                String.format("'%s' status should be shown on a detail request page",
                        OfferStatusesType.DISCUSS_WITH_VLO.getValue()));
    }

    @Test
    @Order(9)
    @Description("Assign company to manager")
    void assignCompanyToManager(){
        clearBrowserLocalStorage();
        sleep(2000);
        GenericPage
                .openLoginPage()
                .setEmailField(managerEmail)
                .setPasswordField(managerPassword)
                .loginAsManager();
        sleep(3000);
        ManagerKanbanPage managerKanbanPage = new ManagerKanbanPage()
                .clickNewClientButton()
                .setEnterClientEmailField(clientEmailDataGeneration)
                .clickAddNewClientButton()
                .clickSubmitButton();
        sleep(3000);
        Assertions.assertEquals("DataGenerationCompany", managerKanbanPage.getSelectedCompany(),
                "'DataGenerationCompany' should be as selected company");
    }

    @ParameterizedTest(name = "{index} - request name is {0}")
    @ValueSource(strings = { "1", "2", "3", "4", "5", "6" })
    @Order(10)
    @Description("Move 6 requests to draft")
    void moveRequestsToOffer(String value){
        clearBrowserLocalStorage();
        GenericPage
                .openLoginPage()
                .setEmailField(managerEmail)
                .setPasswordField(managerPassword)
                .loginAsManager();
        sleep(3000);
        new ManagerKanbanPage()
                .clickCompanyListDropdown()
                .clickCompanyInDropdown("DataGenerationCompany");
                sleep(2000);
        ManagerDetailOfferPage managerDetailOfferPage = new ManagerKanbanPage()
                .clickRequestCard(value)
                .clickTurnIntoOfferButton()
                .clickCreateOfferButton();
        sleep(2000);
        Assertions.assertAll(
                () -> Assertions.assertEquals(OfferStatusesType.DRAFT.getValue(), managerDetailOfferPage.getOfferStatusText(),
                        String.format("'%s' should not be shown on the top offer",
                                OfferStatusesType.DRAFT.getValue())),
                () -> Assertions.assertEquals(OfferStatusesType.PREPARING_OFFER.getValue(),managerDetailOfferPage.getNextStepText(),
                        String.format("'%s' should not be shown on the top offer",
                                OfferStatusesType.OFFER_HAS_TO_BE_ACCEPTED.getValue()))
        );
    }

    @ParameterizedTest(name = "{index} - request name is {0}")
    @ValueSource(strings = { "1", "2", "3", "4", "5" })
    @Order(10)
    @Description("Move 5 requests to publish")
    void moveRequestsToPublish(String value){
        clearBrowserLocalStorage();
        GenericPage
                .openLoginPage()
                .setEmailField(managerEmail)
                .setPasswordField(managerPassword)
                .loginAsManager();
        sleep(3000);
        new ManagerKanbanPage()
                .clickCompanyListDropdown()
                .clickCompanyInDropdown("DataGenerationCompany");
        sleep(2000);
        ManagerDetailOfferPage managerDetailOfferPage = new ManagerKanbanPage()
                .clickOfferCard(value)
                .clickPublishButton();
        sleep(2000);
        Assertions.assertAll(
                () -> Assertions.assertEquals("COPY", managerDetailOfferPage.getMoveToNextStatusButton(), "Button should has text 'Copy'"),
                () -> Assertions.assertEquals(OfferStatusesType.OFFER_HAS_TO_BE_ACCEPTED.getValue(),managerDetailOfferPage.getNextStepText(),
                        String.format("'%s' should not be shown on the top offer",
                                OfferStatusesType.OFFER_HAS_TO_BE_ACCEPTED.getValue()))
        );
    }

    @ParameterizedTest(name = "{index} - offer name is {0}")
    @ValueSource(strings = { "1", "2", "3", "4" })
    @Order(12)
    @Description("Move 4 offers to accepted status")
    void moveOfferToAccepted(String value){
        GenericPage
                .openLoginPage()
                .setEmailField(clientEmailDataGeneration)
                .setPasswordField(clientPasswordDataGeneration)
                .loginAsClient();
        sleep(3000);
        ClientDetailOfferPage clientDetailOfferPage = new ClientKanbanPage()
                .clickOfferCard(value)
                .clickAcceptButton();
        sleep(2000);
        Assertions.assertAll(
                () -> Assertions.assertFalse(clientDetailOfferPage.isAcceptButtonEnabled(),
                        "Accepted button should be disabled"),
                () -> Assertions.assertTrue(clientDetailOfferPage.getStatusOfferText().contains(OfferStatusesType.WAIT_FOR_VLO_RESPONSE.getValue()),
                        String.format("'%s' should not be shown on the top offer",
                        OfferStatusesType.WAIT_FOR_VLO_RESPONSE.getValue()))
        );
    }

    @ParameterizedTest(name = "{index} - offer name is {0}")
    @ValueSource(strings = { "1", "2", "3" })
    @Order(13)
    @Description("Move 3 offers to 'Move to payment'")
    void moveOfferToMoveToPayment(String value){
        GenericPage
                .openLoginPage()
                .setEmailField(managerEmail)
                .setPasswordField(managerPassword)
                .loginAsManager();
        sleep(3000);
        ManagerDetailOfferPage managerDetailOfferPage = new ManagerKanbanPage()
                .clickOfferCard(value)
                .clickStatusesDropDown()
                .clickMoveToPaymentStatus();
        sleep(2000);
        Assertions.assertEquals(OfferStatusesType.AWAITING_PAYMENT.getValue(), managerDetailOfferPage.getNextStepText(),
                String.format("'%s' should not be shown on the top offer",
                OfferStatusesType.AWAITING_PAYMENT.getValue()));
    }

    @ParameterizedTest(name = "{index} - offer name is {0}")
    @ValueSource(strings = { "1", "2" })
    @Order(14)
    @Description("Move 2 offers to 'Start Delivery'")
    void moveOfferToStartDelivery(String value){
        GenericPage
                .openLoginPage()
                .setEmailField(managerEmail)
                .setPasswordField(managerPassword)
                .loginAsManager();
        sleep(3000);
        ManagerDetailOfferPage managerDetailOfferPage = new ManagerKanbanPage()
                .clickOfferCard(value)
                .clickStatusesDropDown()
                .clickStartDeliveryStatus();
        sleep(3000);
        Assertions.assertEquals(OfferStatusesType.PREPARING_DOCUMENT.getValue(), managerDetailOfferPage.getNextStepText(),
                String.format("'%s' should not be shown on the top offer",
                OfferStatusesType.PREPARING_DOCUMENT.getValue()));
    }

    @ParameterizedTest(name = "{index} - offer name is {0}")
    @ValueSource(strings = { "1" })
    @Order(15)
    @Description("Move 1 offers to 'Done'")
    void moveOfferToDone(String value){
        GenericPage
                .openLoginPage()
                .setEmailField(managerEmail)
                .setPasswordField(managerPassword)
                .loginAsManager();
        sleep(3000);
        ManagerDetailOfferPage managerDetailOfferPage = new ManagerKanbanPage()
                .clickOfferCard(value)
                .clickStatusesDropDown()
                .clickMoveToDoneStatus();
        sleep(2000);
        Assertions.assertEquals(OfferStatusesType.DONE.getValue(), managerDetailOfferPage.getOfferStatusText(),
                String.format("'%s' should not be shown on the top offer",
                OfferStatusesType.DONE.getValue()));
    }
}
