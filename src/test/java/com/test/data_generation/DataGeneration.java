package com.test.data_generation;

import com.codeborne.selenide.Selenide;
import com.test.GenericPage;
import com.test.PrepareOverallTestData;
import com.test.admin_panel.clients_section.ViewClientPage;
import com.test.admin_panel.companies_section.invoices.ViewInvoicesPage;
import com.test.admin_panel.onboarding_section.ViewOnboardingPage;
import com.test.kanban.OfferStatusesType;
import com.test.kanban.client_kanban.ClientKanbanPage;
import com.test.kanban.client_kanban.ClientDetailOfferPage;
import com.test.kanban.client_kanban.ClientDetailRequestPage;
import com.test.kanban.manager_kanban.ManagerKanbanPage;
import com.test.kanban.manager_kanban.ManagerDetailOfferPage;
import com.test.onboarding.*;
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
        Assertions.assertEquals("Active", viewClientPage.getStatusState(), "Page title should be shown");
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
                .clickUpdateButton(4, dataGenerationClientFirstName)
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
                .clickUpdateButton(3, dataGenerationClientFirstName)
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
                .clickUpdateButton(2, dataGenerationClientFirstName)
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
                .clickUpdateButton(1, dataGenerationClientFirstName)
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
                .setClientSearchByCompanyField(dataGenerationClientCompany)
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
                .setEnterClientEmailField(dataGenerationClientEmail)
                .clickAddNewClientButton()
                .clickSubmitButton();
        Assertions.assertEquals("DataGenerationCompany", managerKanbanPage.getSelectedCompany(),
                "'DataGenerationCompany' should be as selected company");
    }

    @ParameterizedTest(name = "{index} - request name is {0}")
    @ValueSource(strings = { "1", "2", "3", "4", "5", "6" })
    @Order(11)
    @Description("Move 6 requests to draft")
    void verifyMoveRequestsToOffer(String value){
        ManagerDetailOfferPage managerDetailOfferPage = GenericPage
                .openManagerKanban()
                .clickCompanyListDropdown()
                .clickCompanyInDropdown("DataGenerationCompany")
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
                .clickCompanyInDropdown(dataGenerationClientCompany)
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
        logoutAndLoginAsClient();
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
                .clickCompanyInDropdown(dataGenerationClientCompany)
                .clickOfferCard(value)
                .clickStatusesDropDown()
                .clickMoveToPaymentStatus();
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
                .clickCompanyInDropdown(dataGenerationClientCompany)
                .clickOfferCard(value)
                .clickStatusesDropDown()
                .clickStartDeliveryStatus();
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
                .clickCompanyInDropdown(dataGenerationClientCompany)
                .clickOfferCard(value)
                .clickStatusesDropDown()
                .clickMoveToDoneStatus();
        Assertions.assertEquals(OfferStatusesType.DONE.getValue(), managerDetailOfferPage.getOfferStatusText(),
                String.format("'%s' should not be shown on the top offer",
                OfferStatusesType.DONE.getValue()));
    }

    @Test
    @Order(19)
    @Description("Create a trial invoice after passing onboarding")
    void verifyCreateTrialInvoiceAfterPassHelloSign() {
        recordInvoiceCredentialToFile(invoicingClientEmail, invoicingClientPassword, company);
        open(domainCabinet + "/registration");
        registrationNewClientAndCompany(firstName, lastName, company, invoicingClientEmail, invoicingClientPassword);
        GenericPage
                .openLoginPage()
                .setEmailField(invoicingClientEmail)
                .setPasswordField(invoicingClientPassword)
                .loginAsNewClient()
                .clickContinueButton()
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
        new HelloSignOverlay()
                .setFullNameField(firstName + " " + lastName)
                .clickFullNameField()
                .clickSignatureField()
                .clickSignByTypeButton()
                .setSignField(firstName)
                .clickInsertEverywhereSignButton()
                .setAddressField(faker.address().streetAddress())
                .setCompanyField(company)
                .setCompanyNumberField(faker.phoneNumber().cellPhone())
                .setPositionField(faker.job().position())
                .clickNextStepButton()
                .clickAgreeButton();
        closeWindow();
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
                () -> Assertions.assertEquals(company, viewInvoicesPage.getCompanyNameText(),
                        String.format("'%s' should be shown next to 'Company name' label", company)),
                () -> Assertions.assertEquals("trial", viewInvoicesPage.getServiceText(),
                        "'retainer' should be shown next to 'Service' label"),
                () -> Assertions.assertEquals("UNPAID", viewInvoicesPage.getStatusText(),
                        "'UNPAID' should be shown next to 'Status' label"),
                () -> Assertions.assertEquals(trialInvoicePrice, viewInvoicesPage.getSumText(),
                        String.format("'%s' should be shown next to 'Sum' label", trialInvoicePrice))
        );
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
