package com.test.onboarding;

import com.codeborne.selenide.Selenide;
import com.test.GenericPage;
import com.test.admin_panel.companies_section.invoices.ViewInvoicesPage;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.*;

public class VerifyCreateInvoiceAfterPassHelloSignTest extends PrepareOnboardingTestData {

    public static String password = "12345678";//faker.internet().password(8, 15);
    public static String firstName = faker.name().firstName();
    public static String lastName = faker.name().lastName();
    public static String company = faker.company().name();
    public static String email = firstName + "testyop@yopmail.com";
    public static int onboardingInvoicePrice = getOnboardingInvoicePrice();

    @BeforeEach
    void registrationNewClientAndCompany(){
        registrationNewClientAndCompany(firstName, lastName, company, email, password);
    }

    @Test
    void verifyCreateInvoiceAfterPassHelloSign() {
        GenericPage
                .openLoginPage()
                .setEmailField(email)
                .setPasswordField(password)
                .loginAsNewClient();
        sleep(2000);
        new WelcomePopupOverlay()
                .clickContinueButton();
        sleep(2000);
        new OnboardingPage()
                .clickSignLetterButton();
        Selenide.switchTo().window(1);
        new HelloSignEmailPopupOverlay()
                .setEmailField(email)
                .clickVerifyEmailField();
        GenericPage
                .openYopmailPage()
                .setLoginField(email)
                .clickLoginButton()
                .clickRefreshButton()
                .switchEmailIframe()
                .clickViewHelloSignDocument();
        Selenide.switchTo().window(2);
        sleep(15000);
        new HelloSignOverlay()
                .setFullNameField(firstName + " " + lastName)
                .clickFullNameField()
                .clickSignatureField()
                .clickSignByTypeButton()
                .setSignField(firstName)
                .clickInsertSignButton()
                .setAddressField(faker.address().streetAddress())
                .setCompanyField(company)
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
                () -> Assertions.assertEquals(company, viewInvoicesPage.getCompanyNameText(),
                        String.format("'%s' should be shown next to 'Company name' label", company)),
                () -> Assertions.assertEquals("retainer", viewInvoicesPage.getServiceText(),
                        "'retainer' should be shown next to 'Service' label"),
                () -> Assertions.assertEquals("UNPAID", viewInvoicesPage.getStatusText(),
                        "'UNPAID' should be shown next to 'Status' label"),
                () -> Assertions.assertEquals(onboardingInvoicePrice, viewInvoicesPage.getSumText(),
                        String.format("'%s' should be shown next to 'Sum' label",
                                onboardingInvoicePrice)),
                () -> Assertions.assertTrue(viewInvoicesPage.getTimestampText().contains(getTodayDateUSAHyphen()),
                        String.format("'%s' should be shown next to 'Sum' label",
                                getTodayDateUSAHyphen()))
        );
    }

//    @AfterAll
//    static void deleteNewClientAndCompany(){
//        deleteNewClient(email, company);
//    }


}
