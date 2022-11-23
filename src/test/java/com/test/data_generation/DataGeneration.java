package com.test.data_generation;

import com.codeborne.selenide.Selenide;
import com.test.GenericPage;
import com.test.PrepareOverallTestData;
import com.test.admin_panel.MainAdminPage;
import com.test.admin_panel.clients_section.ViewClientPage;
import com.test.admin_panel.companies_section.invoices.ViewInvoicesPage;
import com.test.admin_panel.onboarding_section.ViewOnboardingPage;
import com.test.kanban.OfferStatusesType;
import com.test.kanban.client_kanban.ClientKanbanPage;
import com.test.kanban.client_kanban.CreateTaskRequestOverlay;
import com.test.kanban.client_kanban.ClientDetailOfferPage;
import com.test.kanban.client_kanban.ClientDetailRequestPage;
import com.test.kanban.manager_kanban.ManagerKanbanPage;
import com.test.kanban.manager_kanban.ManagerDetailOfferPage;
import com.test.onboarding.HelloSignEmailPopupOverlay;
import com.test.onboarding.HelloSignOverlay;
import com.test.onboarding.OnboardingPage;
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
        open(domainCabinet + "/registration");
    }

    @Test
    @Order(1)
    @Description("Registration new client")
    void verifyRegistrationNewClient(){
        ConfirmYourAccountOverlay confirmYourAccountOverlay = new FourthRegistrationPage()
                .setFirstNameField(dataGenerationClientFirstName)
                .setLastNameField(dataGenerationClientLastName)
                .setCompanyNameField(dataGenerationClientCompany)
                .setEmailField(dataGenerationClientEmail)
                .setPasswordField(dataGenerationClientPassword)
                .setRepeatPasswordField(dataGenerationClientPassword)
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
                .setClientSearchByEmailField(dataGenerationClientEmail)
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
                .setEmailField(dataGenerationClientEmail)
                .setPasswordField(dataGenerationClientPassword)
                .loginAsNewClient();
        sleep(3000);
        Assertions.assertTrue(welcomePopupOverlay.isPopupShown(),"Welcome popup should be shown");
    }

    @Test
    @Order(4)
    @Description("Passing Step 1 of Onboarding")
    void verifyPassingStep1Onboarding(){
        ViewOnboardingPage viewOnboardingPage = GenericPage
                .openLoginAdminPage()
                .setUsernameField(stageUsernameAdmin)
                .setPasswordField(stagePasswordAdmin)
                .loginAsAdmin()
                .clickClientsLink()
                .clickOnboardingLink()
                .clickUpdateButton(4, dataGenerationClientFirstName)
                .switchStageResultToDone()
                .clickSaveButton();
        sleep(500);
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
                .clickUpdateButton(3, dataGenerationClientFirstName)
                .switchStageResultToDone()
                .clickSaveButton();
        sleep(500);
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
                .clickUpdateButton(2, dataGenerationClientFirstName)
                .switchStageResultToDone()
                .clickSaveButton();
        sleep(500);
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
                .clickUpdateButton(1, dataGenerationClientFirstName)
                .switchStageResultToDone()
                .clickSaveButton();
        sleep(500);
        Assertions.assertTrue(viewOnboardingPage.updateButtonIsShown(), "Update button should be shown");
    }

    @ParameterizedTest(name = "{index} - request name is {0}")
    @ValueSource(strings = { "1", "2", "3", "4", "5", "6", "7" })
    @Order(8)
    @Description("Registration of 7 requests")
    void verifyRegistration7requests(String value){
        clearBrowserLocalStorage();
        GenericPage
                .openLoginPage()
                .setEmailField(dataGenerationClientEmail)
                .setPasswordField(dataGenerationClientPassword)
                .loginAsClient();
        sleep(2000);
        new ClientKanbanPage()
                .clickNewRequestButton()
                .clickCreateNewRequestButton();
        sleep(1000);
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
    void verifyAssignCompanyToManager(){
        clearBrowserLocalStorage();
        GenericPage
                .openLoginPage()
                .setEmailField(managerEmail)
                .setPasswordField(managerPassword)
                .loginAsManager();
        sleep(2000);
        ManagerKanbanPage managerKanbanPage = new ManagerKanbanPage()
                .clickNewClientButton()
                .setEnterClientEmailField(dataGenerationClientEmail)
                .clickAddNewClientButton()
                .clickSubmitButton();
        sleep(2000);
        Assertions.assertEquals("DataGenerationCompany", managerKanbanPage.getSelectedCompany(),
                "'DataGenerationCompany' should be as selected company");
    }

    @ParameterizedTest(name = "{index} - request name is {0}")
    @ValueSource(strings = { "1", "2", "3", "4", "5", "6" })
    @Order(10)
    @Description("Move 6 requests to draft")
    void verifyMoveRequestsToOffer(String value){
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
    @Order(11)
    @Description("Move 5 drafts to publish")
    void verifyMoveRequestsToPublish(String value){
        clearBrowserLocalStorage();
        GenericPage
                .openLoginPage()
                .setEmailField(managerEmail)
                .setPasswordField(managerPassword)
                .loginAsManager();
        sleep(2000);
        new ManagerKanbanPage()
                .clickCompanyListDropdown()
                .clickCompanyInDropdown(dataGenerationClientCompany);
        sleep(2000);
        ManagerDetailOfferPage managerDetailOfferPage = new ManagerKanbanPage()
                .clickOfferCard(value)
                .clickPublishButton();
        sleep(2000);
        Assertions.assertAll(
                () -> Assertions.assertEquals(OfferStatusesType.OFFER.getValue(),managerDetailOfferPage.getOfferStatusText(),
                        String.format("'%s' should not be shown on the top offer",
                                OfferStatusesType.OFFER.getValue())),
                () -> Assertions.assertEquals(OfferStatusesType.OFFER_HAS_TO_BE_ACCEPTED.getValue(),managerDetailOfferPage.getNextStepText(),
                        String.format("'%s' should not be shown on the top offer",
                                OfferStatusesType.OFFER_HAS_TO_BE_ACCEPTED.getValue()))
        );
    }

    @ParameterizedTest(name = "{index} - offer name is {0}")
    @ValueSource(strings = { "1", "2", "3", "4" })
    @Order(12)
    @Description("Move 4 offers to accepted status")
    void verifyMoveOfferToAccepted(String value){
        clearBrowserLocalStorage();
        GenericPage
                .openLoginPage()
                .setEmailField(dataGenerationClientEmail)
                .setPasswordField(dataGenerationClientPassword)
                .loginAsClient();
        sleep(2000);
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
    void verifyMoveOfferToMoveToPayment(String value){
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
    void verifyMoveOfferToStartDelivery(String value){
        clearBrowserLocalStorage();
        GenericPage
                .openLoginPage()
                .setEmailField(managerEmail)
                .setPasswordField(managerPassword)
                .loginAsManager();
        sleep(2000);
        new ManagerKanbanPage()
                .clickCompanyListDropdown()
                .clickCompanyInDropdown("DataGenerationCompany");
        sleep(2000);
        ManagerDetailOfferPage managerDetailOfferPage = new ManagerKanbanPage()
                .clickOfferCard(value)
                .clickStatusesDropDown()
                .clickStartDeliveryStatus();
        sleep(2000);
        Assertions.assertEquals(OfferStatusesType.PREPARING_DOCUMENT.getValue(), managerDetailOfferPage.getNextStepText(),
                String.format("'%s' should not be shown on the top offer",
                OfferStatusesType.PREPARING_DOCUMENT.getValue()));
    }

    @ParameterizedTest(name = "{index} - offer name is {0}")
    @ValueSource(strings = { "1" })
    @Order(15)
    @Description("Move 1 offers to 'Done'")
    void verifyMoveOfferToDone(String value){
        GenericPage
                .openLoginPage()
                .setEmailField(managerEmail)
                .setPasswordField(managerPassword)
                .loginAsManager();
        sleep(2000);
        new ManagerKanbanPage()
                .clickCompanyListDropdown()
                .clickCompanyInDropdown("DataGenerationCompany");
        sleep(2000);
        ManagerDetailOfferPage managerDetailOfferPage = new ManagerKanbanPage()
                .clickOfferCard(value)
                .clickStatusesDropDown()
                .clickMoveToDoneStatus();
        sleep(2000);
        Assertions.assertEquals(OfferStatusesType.DONE.getValue(), managerDetailOfferPage.getOfferStatusText(),
                String.format("'%s' should not be shown on the top offer",
                OfferStatusesType.DONE.getValue()));
    }

    private final String invoicingClientFirstName = "InvoicingFirstName";
    private final String invoicingClientLastName = "InvoicingLastName";
    private final String invoicingClientCompanyName = "InvoicingCompanyName";

    @Test
    @Order(16)
    @Description("Registration new client for invoicing")
    void verifyRegistrationNewClientForInvoicing(){
        registrationNewClientAndCompany(invoicingClientFirstName,
                invoicingClientLastName,
                invoicingClientCompanyName,
                invoicingClientEmail,
                invoicingClientPassword);
    }

    @Test
    @Order(17)
    void verifyCreateInvoiceAfterPassHelloSign() {
        GenericPage
                .openLoginPage()
                .setEmailField(invoicingClientEmail)
                .setPasswordField(invoicingClientPassword)
                .loginAsNewClient();
        sleep(2000);
        new WelcomePopupOverlay()
                .clickContinueButton();
        sleep(2000);
        new OnboardingPage()
                .clickSignLetterButton();
        Selenide.switchTo().window(1);
        new HelloSignEmailPopupOverlay()
                .setEmailField(invoicingClientEmail)
                .clickVerifyEmailField();
        GenericPage
                .openYopmailPage()
                .setLoginField(invoicingClientEmail)
                .clickLoginButton()
                .clickRefreshButton()
                .switchEmailIframe()
                .clickViewHelloSignDocument();
        Selenide.switchTo().window(2);
        sleep(15000);
        new HelloSignOverlay()
                .setFullNameField(invoicingClientFirstName + " " + invoicingClientLastName)
                .clickFullNameField()
                .clickSignatureField()
                .clickSignByTypeButton()
                .setSignField(invoicingClientFirstName)
                .clickInsertSignButton()
                .setAddressField(faker.address().streetAddress())
                .setCompanyField(invoicingClientCompanyName)
                .setCompanyNumberField(faker.phoneNumber().cellPhone())
                .clickSignatureTwoField()
                .setPositionField(faker.job().position())
                .clickNextStepButton()
                .clickAgreeButton();
        closeWindow();
        sleep(3000);
        ViewInvoicesPage viewInvoicesPage = GenericPage
                .openLoginAdminPage()
                .setUsernameField(stageUsernameAdmin)
                .setPasswordField(stagePasswordAdmin)
                .loginAsAdmin()
                .clickCompaniesLink()
                .clickInvoicesLink()
                .clickSortByIdLink()
                .clickSortByIdLink()
                .clickViewButton();
        Assertions.assertAll(
                () -> Assertions.assertEquals(invoicingClientCompanyName, viewInvoicesPage.getCompanyNameText(),
                        String.format("'%s' should be shown next to 'Company name' label", invoicingClientCompanyName)),
                () -> Assertions.assertEquals("retainer", viewInvoicesPage.getServiceText(),
                        "'retainer' should be shown next to 'Service' label")
        );
    }
}
