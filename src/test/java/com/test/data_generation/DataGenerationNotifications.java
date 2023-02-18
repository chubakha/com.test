package com.test.data_generation;

import com.test.GenericPage;
import com.test.PrepareOverallTestData;
import com.test.admin_panel.clients_section.ViewClientPage;
import com.test.admin_panel.onboarding_section.ViewOnboardingPage;
import com.test.kanban.OfferStatusesType;
import com.test.kanban.client_kanban.ClientDetailOfferPage;
import com.test.kanban.client_kanban.ClientDetailRequestPage;
import com.test.kanban.client_kanban.ClientKanbanPage;
import com.test.kanban.manager_kanban.ManagerDetailOfferPage;
import com.test.kanban.manager_kanban.ManagerKanbanPage;
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
public class DataGenerationNotifications extends PrepareOverallTestData {

    public static final String invoicingClientPassword = "12345678";//faker.internet().password(8, 15);
    public static final String firstName = faker.name().firstName();
    public static final String lastName = faker.name().lastName();
    public static final String company = faker.company().name();
    public static final String invoicingClientEmail = firstName.toLowerCase() + "testyop@yopmail.com";


    @BeforeAll
    static void openPage(){
        open(domainCabinet + "/registration");
    }

    @Test
    @Order(1)
    @Description("Registration new client")
    void verifyRegistrationNewClient(){
        ConfirmYourAccountOverlay confirmYourAccountOverlay = new FourthRegistrationPage()
                .setFirstNameField(dataGenerationClientNotificationsFirstName)
                .setLastNameField(dataGenerationClientNotificationsLastName)
                .setCompanyNameField(dataGenerationClientNotificationsCompany)
                .setEmailField(dataGenerationClientNotificationsEmail)
                .setPasswordField(dataGenerationClientNotificationsPassword)
                .setRepeatPasswordField(dataGenerationClientNotificationsPassword)
                .clickInactiveIveReadAndAcceptedTermsConditionsAndPrivacyPolicy()
                .clickActiveCreateAccountButton();
        Assertions.assertEquals("Please activate your account", confirmYourAccountOverlay.getPageTitle(),
                "'Please activate your account' page should be shown");
    }

    @Test
    @Order(2)
    @Description("activate new client")
    void verifyActivateNewClient(){
        ViewClientPage viewClientPage = GenericPage
                .openLoginAdminPage()
                .setUsernameField(stageUsernameAdmin)
                .setPasswordField(stagePasswordAdmin)
                .loginAsAdmin()
                .clickClientsLink()
                .setClientSearchByEmailField(dataGenerationClientNotificationsEmail)
                .focusOutSearchFields()
                .clickUpdateButton()
                .switchStatusToActive()
                .clickSaveButton();
        Assertions.assertEquals("Active", viewClientPage.getStatusState(), "Page title should be shown");
    }

    @Test
    @Order(3)
    @Description("Login by new client for creation onboarding stages")
    void verifyLoginByNewClient(){
        WelcomePopupOverlay welcomePopupOverlay = GenericPage
                .openLoginPage()
                .setEmailField(dataGenerationClientNotificationsEmail)
                .setPasswordField(dataGenerationClientNotificationsPassword)
                .loginAsNewClient();
        Assertions.assertTrue(welcomePopupOverlay.isPopupShown(),"Welcome popup should be shown");
    }

    @Test
    @Order(4)
    @Description("Passing Step 1 of Onboarding")
    void verifyPassingStep1Onboarding(){
        ViewOnboardingPage viewOnboardingPage = GenericPage
                .openAdminPageWithoutAuthorization()
                .clickClientsLink()
                .clickOnboardingLink()
                .clickUpdateButton(4, dataGenerationClientNotificationsFirstName)
                .switchStageResultToDone()
                .clickSaveButton();
        Assertions.assertTrue(viewOnboardingPage.updateButtonIsShown(), "Update button should be shown");
    }

    @Test
    @Order(5)
    @Description("Passing Step 2 of Onboarding")
    void verifyPassingStep2Onboarding(){
        ViewOnboardingPage viewOnboardingPage = GenericPage
                .openAdminPageWithoutAuthorization()
                .clickClientsLink()
                .clickOnboardingLink()
                .clickUpdateButton(3, dataGenerationClientNotificationsFirstName)
                .switchStageResultToDone()
                .clickSaveButton();
        Assertions.assertTrue(viewOnboardingPage.updateButtonIsShown(), "Update button should be shown");
    }

    @Test
    @Order(6)
    @Description("Passing Step 3 of Onboarding")
    void verifyPassingStep3Onboarding(){
        ViewOnboardingPage viewOnboardingPage = GenericPage
                .openAdminPageWithoutAuthorization()
                .clickClientsLink()
                .clickOnboardingLink()
                .clickUpdateButton(2, dataGenerationClientNotificationsFirstName)
                .switchStageResultToDone()
                .clickSaveButton();
        Assertions.assertTrue(viewOnboardingPage.updateButtonIsShown(), "Update button should be shown");
    }

    @Test
    @Order(7)
    @Description("Passing Step 4 of Onboarding")
    void verifyPassingStep4Onboarding(){
        ViewOnboardingPage viewOnboardingPage = GenericPage
                .openAdminPageWithoutAuthorization()
                .clickClientsLink()
                .clickOnboardingLink()
                .clickUpdateButton(1, dataGenerationClientNotificationsFirstName)
                .switchStageResultToDone()
                .clickSaveButton();
        Assertions.assertTrue(viewOnboardingPage.updateButtonIsShown(), "Update button should be shown");
    }

    @Test
    @Order(8)
    @Description("Switch trial to none status of company")
    void verifySwitchTrialToNoneStatusCompany(){
        GenericPage
                .openAdminPageWithoutAuthorization()
                .clickCompaniesLink()
                .setClientSearchByCompanyField(dataGenerationClientNotificationsCompany)
                .focusOutSearchFields()
                .clickUpdateButton()
                .clickDebtSelect()
                .clickDebtNone()
                .clickSaveButton();
   }

    @ParameterizedTest(name = "{index} - request name is {0}")
    @ValueSource(strings = { "1", "2", "3", "4", "5", "6", "7" })
    @Order(9)
    @Description("Registration of 7 requests")
    void verifyRegistration7requests(String value){
        ClientDetailRequestPage clientDetailRequestPage = GenericPage
                .openClientKanban()
                .clickNewRequestButton()
                .clickCreateNewRequestButton()
                .setTitleField(value)
                .switchToDescriptionIframe()
                .setDescriptionField(value)
                .switchFocusToOverlay()
                .clickSubmitButton();
        Assertions.assertEquals(OfferStatusesType.DISCUSS_WITH_VLO.getValue(),
                clientDetailRequestPage.getRequestStatus(),
                String.format("'%s' status should be shown on a detail request page",
                        OfferStatusesType.DISCUSS_WITH_VLO.getValue()));
    }

    @Test
    @Order(10)
    @Description("Assign company to manager")
    void verifyAssignCompanyToManager(){
        clearBrowserLocalStorage();
        ManagerKanbanPage managerKanbanPage = GenericPage
                .openLoginPage()
                .setEmailField(dataGenerationManagerEmail)
                .setPasswordField(dataGenerationManagerPassword)
                .loginAsManager()
                .clickNewClientButton()
                .setEnterClientEmailField(dataGenerationClientNotificationsEmail)
                .clickAddNewClientButton()
                .clickSubmitButton();
        Assertions.assertEquals(dataGenerationClientNotificationsCompany, managerKanbanPage.getSelectedCompany(),
                String.format("'%s' should be as selected company", dataGenerationClientNotificationsCompany));
    }

    @ParameterizedTest(name = "{index} - request name is {0}")
    @ValueSource(strings = { "1", "2", "3", "4", "5", "6" })
    @Order(11)
    @Description("Move 6 requests to draft")
    void verifyMoveRequestsToOffer(String value){
        ManagerDetailOfferPage managerDetailOfferPage = GenericPage
                .openManagerKanban()
                .clickCompanyListDropdown()
                .clickCompanyInDropdown(dataGenerationClientNotificationsCompany)
                .clickRequestCard(value)
                .clickTurnIntoOfferButton()
                .clickCreateOfferButton();
        Assertions.assertAll(
                () -> Assertions.assertEquals(OfferStatusesType.DRAFT.getValue(),
                        managerDetailOfferPage.getOfferStatusText(),
                        String.format("'%s' should not be shown on the top offer",
                                OfferStatusesType.DRAFT.getValue())),
                () -> Assertions.assertEquals(OfferStatusesType.PREPARING_OFFER.getValue(),
                        managerDetailOfferPage.getNextStepText(),
                        String.format("'%s' should not be shown on the top offer",
                                OfferStatusesType.OFFER_HAS_TO_BE_ACCEPTED.getValue()))
        );
    }

    @ParameterizedTest(name = "{index} - request name is {0}")
    @ValueSource(strings = { "1", "2", "3", "4", "5" })
    @Order(12)
    @Description("Move 5 drafts to publish")
    void verifyMoveRequestsToPublish(String value){
        ManagerDetailOfferPage managerDetailOfferPage = GenericPage
                .openManagerKanban()
                .clickCompanyListDropdown()
                .clickCompanyInDropdown(dataGenerationClientNotificationsCompany)
                .clickOfferCard(value)
                .clickPublishButton();
        Assertions.assertAll(
                () -> Assertions.assertEquals(OfferStatusesType.OFFER.getValue(),
                        managerDetailOfferPage.getOfferStatusText(),
                        String.format("'%s' should not be shown on the top offer",
                                OfferStatusesType.OFFER.getValue())),
                () -> Assertions.assertEquals(OfferStatusesType.OFFER_HAS_TO_BE_ACCEPTED.getValue(),
                        managerDetailOfferPage.getNextStepText(),
                        String.format("'%s' should not be shown on the top offer",
                                OfferStatusesType.OFFER_HAS_TO_BE_ACCEPTED.getValue()))
        );
    }

    @Test
    @Order(13)
    void loginAsClient(){
        logoutAndLoginAsClient(dataGenerationClientNotificationsEmail, dataGenerationClientNotificationsPassword);
    }

    @ParameterizedTest(name = "{index} - offer name is {0}")
    @ValueSource(strings = { "1", "2", "3", "4" })
    @Order(14)
    @Description("Move 4 offers to accepted status")
    void verifyMoveOfferToAccepted(String value){
        ClientDetailOfferPage clientDetailOfferPage = new ClientKanbanPage()
                .clickLegalBoardLink()
                .clickOfferCard(value)
                .clickAcceptButton();
        Assertions.assertAll(
                () -> Assertions.assertTrue(clientDetailOfferPage.getStatusOfferText().contains(OfferStatusesType.WAIT_FOR_VLO_RESPONSE.getValue()),
                        String.format("'%s' should not be shown on the top offer",
                                OfferStatusesType.WAIT_FOR_VLO_RESPONSE.getValue())),
                () -> Assertions.assertFalse(clientDetailOfferPage.isAcceptButtonEnabled(),
                        "Accepted button should be disabled")
        );
    }

    @Test
    @Order(15)
    void loginAsManager(){
        logoutAndLoginAsManager();
    }

    @ParameterizedTest(name = "{index} - offer name is {0}")
    @ValueSource(strings = { "1", "2", "3" })
    @Order(16)
    @Description("Move 3 offers to 'Move to payment'")
    void verifyMoveOfferToMoveToPayment(String value){
        ManagerDetailOfferPage managerDetailOfferPage = new ManagerKanbanPage()
                .clickLegalBoardLink()
                .clickCompanyListDropdown()
                .clickCompanyInDropdown(dataGenerationClientNotificationsCompany)
                .clickOfferCard(value)
                .clickStatusesDropDown()
                .clickMoveToPaymentStatusButton();
        Assertions.assertEquals(OfferStatusesType.AWAITING_PAYMENT.getValue(),
                managerDetailOfferPage.getNextStepText(),
                String.format("'%s' should not be shown on the top offer",
                OfferStatusesType.AWAITING_PAYMENT.getValue()));
    }

    @ParameterizedTest(name = "{index} - offer name is {0}")
    @ValueSource(strings = { "1", "2" })
    @Order(17)
    @Description("Move 2 offers to 'Start Delivery'")
    void verifyMoveOfferToStartDelivery(String value){
        ManagerDetailOfferPage managerDetailOfferPage = new ManagerKanbanPage()
                .clickLegalBoardLink()
                .clickCompanyListDropdown()
                .clickCompanyInDropdown(dataGenerationClientNotificationsCompany)
                .clickOfferCard(value)
                .clickStatusesDropDown()
                .clickStartDeliveryStatusButton();
        Assertions.assertEquals(OfferStatusesType.PREPARING_DOCUMENT.getValue(),
                managerDetailOfferPage.getNextStepText(),
                String.format("'%s' should not be shown on the top offer",
                OfferStatusesType.PREPARING_DOCUMENT.getValue()));
    }

    @ParameterizedTest(name = "{index} - offer name is {0}")
    @ValueSource(strings = { "1" })
    @Order(18)
    @Description("Move 1 offers to 'Done'")
    void verifyMoveOfferToDone(String value){
        ManagerDetailOfferPage managerDetailOfferPage = GenericPage
                .openManagerKanban()
                .clickCompanyListDropdown()
                .clickCompanyInDropdown(dataGenerationClientNotificationsCompany)
                .clickOfferCard(value)
                .clickStatusesDropDown()
                .clickMoveToDoneStatusButton();
        Assertions.assertEquals(OfferStatusesType.DONE.getValue(),
                managerDetailOfferPage.getOfferStatusText(),
                String.format("'%s' should not be shown on the top offer",
                OfferStatusesType.DONE.getValue()));
    }

    //@Test
    @Order(20)
    void deleteDataGeneration(){
        GenericPage
                .openAdminPageWithoutAuthorization()
                .clickCompaniesLink()
                .setClientSearchByCompanyField(dataGenerationClientCompany)
                .clickDeleteButton()
                .pressEnterKey();
        GenericPage
                .openAdminPageWithoutAuthorization()
                .clickClientsLink()
                .setClientSearchByEmailField(dataGenerationClientEmail)
                .clickDeleteButton()
                .pressEnterKey();
    }

}
