package com.test;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import com.test.admin_panel.LoginAdminPage;
import com.test.admin_panel.MainAdminPage;
import com.test.mailers.MailHogRecoveryPasswordMailPage;
import com.test.mailers.YopmailInboxMailPage;
import com.test.kanban.manager_kanban.ManagerKanbanPage;
import com.test.registration.fourth_registration_page.FourthRegistrationPage;
import org.junit.jupiter.api.BeforeAll;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class PrepareOverallTestData {

    @BeforeAll
    public static void overallLinksInitialization() {
        faker = new Faker();
    }

    public static Faker faker;

    public static final String AUTHOR_ALEX_CHU = "Alex Chu";

    public void setUp() {
        Configuration.headless = true;
    }

    protected static String clientEmail;
    protected static String clientPassword;
    protected static String managerEmail;
    protected static String managerPassword;
    protected static String stageUsernameAdmin;
    protected static String stagePasswordAdmin;
    protected static String prodUsernameAdmin;
    protected static String prodPasswordAdmin;
    protected static String dataGenerationClientEmail;
    protected static String dataGenerationClientPassword;
    protected static String dataGenerationClientNotificationsEmail;
    protected static String dataGenerationClientNotificationsPassword;
    protected static String dataGenerationClientFirstName = "DataGenerationFirstName";
    protected static String dataGenerationClientLastName = "DataGenerationLastName";
    protected static String dataGenerationClientCompany = "DataGenerationCompany";
    protected static String dataGenerationClientNotificationsFirstName = "DataGenerationNotificationsFirstName";
    protected static String dataGenerationClientNotificationsLastName = "DataGenerationNotificationsLastName";
    protected static String dataGenerationClientNotificationsCompany = "DataGenerationNotificationsCompany";
    protected static String dataGenerationManagerEmail;
    protected static String dataGenerationManagerPassword;
    protected static String dataGenerationManagerFirstName = "Alex";
    protected static String dataGenerationManagerLastName = "ManagerDataGeneration";
    protected static String invoicingClientEmail;
    protected static String invoicingClientPassword;
    protected static String invoicingCompanyName;
    protected static String testCreditCardNumber;
    protected static String testCardExpiry;
    protected static String testCardCvc;
    protected static String testCardHolder;

    protected static int limitChatMessage = 2990;

    protected static int trialInvoicePrice = 299;
    protected static int retainerInvoicePrice = 499;

    protected static String staticUrl = "https://www.legalnodes.com/";

    public static String managerParameter;

    protected static String domainCabinet = "https://stag.cabinet.legalnodes.co";

    @BeforeAll
    static void generalLinksInitialization(){
        clientEmail = PrepareOverallTestData.getClientEmail();
        clientPassword = PrepareOverallTestData.getClientPassword();
        managerEmail = PrepareOverallTestData.getManagerEmail();
        managerPassword = PrepareOverallTestData.getManagerPassword();
        stageUsernameAdmin = PrepareOverallTestData.getStageUsernameAdmin();
        stagePasswordAdmin = PrepareOverallTestData.getStagePasswordAdmin();
        prodUsernameAdmin = PrepareOverallTestData.getProdUsernameAdmin();
        prodPasswordAdmin = PrepareOverallTestData.getProdPasswordAdmin();
        dataGenerationClientEmail = PrepareOverallTestData.getDataGenerationClientEmail();
        dataGenerationClientPassword = PrepareOverallTestData.getDataGenerationClientPassword();
        dataGenerationClientNotificationsEmail = PrepareOverallTestData.getDataGenerationClientNotificationsEmail();
        dataGenerationClientNotificationsPassword = PrepareOverallTestData.getDataGenerationClientNotificationsPassword();
        dataGenerationManagerEmail = PrepareOverallTestData.getDataGenerationManagerEmail();
        dataGenerationManagerPassword = PrepareOverallTestData.getDataGenerationManagerPassword();
        invoicingClientEmail = PrepareOverallTestData.getInvoicingClientEmail();
        invoicingClientPassword = PrepareOverallTestData.getInvoicingClientPassword();
        invoicingCompanyName = PrepareOverallTestData.getInvoicingCompanyName();
        testCreditCardNumber = PrepareOverallTestData.getTestCreditCardNumber();
        testCardExpiry = PrepareOverallTestData.getTestCardExpiry();
        testCardCvc = PrepareOverallTestData.getTestCardCvc();
        testCardHolder = PrepareOverallTestData.getTestCardHolder();
    }

    private static String getClientEmail() {
        return getPropertyFileData().getProperty("stag.client.email");
    }

    private static String getClientPassword(){
        return getPropertyFileData().getProperty("stag.client.password");
    }

    private static String getManagerEmail() {
        return getPropertyFileData().getProperty("stag.manager.email");
    }

    private static String getManagerPassword(){
        return getPropertyFileData().getProperty("stag.manager.password");
    }

    private static String getStageUsernameAdmin() {
        return getPropertyFileData().getProperty("stag.admin.username");
    }

    private static String getStagePasswordAdmin(){
        return getPropertyFileData().getProperty("stag.admin.password");
    }

    private static String getProdUsernameAdmin() {
        return getPropertyFileData().getProperty("prod.admin.username");
    }

    private static String getProdPasswordAdmin(){
        return getPropertyFileData().getProperty("prod.admin.password");
    }

    private static String getInvoicingClientEmail(){
        return getPropertyFileData().getProperty("invoicing.client.email");
    }

    private static String getInvoicingClientPassword(){
        return getPropertyFileData().getProperty("invoicing.client.password");
    }

    private static String getInvoicingCompanyName(){
        return getPropertyFileData().getProperty("invoicing.client.company.name");
    }

    private static String getDataGenerationClientEmail(){
        return getPropertyFileData().getProperty("client.email.data-generation");
    }

    private static String getDataGenerationClientPassword(){
        return getPropertyFileData().getProperty("client.password.data-generation");
    }

    private static String getDataGenerationClientNotificationsEmail(){
        return getPropertyFileData().getProperty("client.email.data-generation.notifications");
    }

    private static String getDataGenerationClientNotificationsPassword(){
        return getPropertyFileData().getProperty("client.password.data-generation.notifications");
    }

    private static String getDataGenerationManagerEmail(){
        return getPropertyFileData().getProperty("manager.email.data-generation");
    }

    private static String getDataGenerationManagerPassword(){
        return getPropertyFileData().getProperty("manager.password.data-generation");
    }

    private static String getTestCreditCardNumber(){
        return getPropertyFileData().getProperty("test.credit.card.number");
    }

    private static String getTestCardExpiry(){
        return getPropertyFileData().getProperty("test.card.expiry");
    }

    private static String getTestCardCvc(){
        return getPropertyFileData().getProperty("test.card.cvc");
    }

    private static String getTestCardHolder(){
        return getPropertyFileData().getProperty("test.card.holder");
    }

    public static Properties getPropertyFileData(){
        Properties prop = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/credentials.properties");
            prop.load(fileInputStream);
        } catch (Exception e){
            e.printStackTrace();
        }
        return prop;
    }

    public static boolean isProd;

    public static boolean isProductionDomainShown(String url){

        if (url.equals("https://stag.cabinet.legalnodes.co/")){
            isProd = false;
        }
        else{
            isProd = true;
        }
        return isProd;
    }

    public static void redirectToLinkFromEmail(String email){
        boolean isProd = isProductionDomainShown(url());
        if(isProd){
            GenericPage
                    .openYopmailPage()
                    .setLoginField(email)
                    .clickLoginButton();
            new YopmailInboxMailPage()
                    .clickRefreshButton()
                    .switchEmailIframe();
            GenericPage.openAnyLink(new YopmailInboxMailPage().getLinkFromProdEmail());
            sleep(2000);
        }
        else {
            GenericPage
                    .openMailHogPage()
                    .clickRecoveryPasswordEmail(email);
            GenericPage.openAnyLink(new MailHogRecoveryPasswordMailPage().getLinkFromStageEmail());
            sleep(2000);
        }
    }

    public static String getTodayDateEuSlash(){
        Date date = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd/MM/yyyy");
        return formatForDateNow.format(date);
    }

    public static String getTodayDateUSAHyphen(){
        Date date = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy-MM-dd");
        return formatForDateNow.format(date);
    }

    public static void registrationNewClientAndCompany(String firstName, String lastName, String company, String email, String password) {
        managerParameter = url().substring(url().indexOf("=") + 1);
        if(new ManagerKanbanPage().isLogOutLinkShown()){
            new ManagerKanbanPage().clickLogOutLink();
        }
        new FourthRegistrationPage()
                .setFirstNameField(firstName)
                .setLastNameField(lastName)
                .setCompanyNameField(company)
                .setEmailField(email)
                .setPasswordField(password)
                .setRepeatPasswordField(password)
                .clickInactiveIveReadAndAcceptedTermsConditionsAndPrivacyPolicy()
                .clickActiveCreateAccountButton();
        GenericPage
                .openLoginAdminPage();
        if(new MainAdminPage().isLogoutLinkShown()){
            new MainAdminPage().clickLogoutLink();
        }
        new LoginAdminPage()
                .setUsernameField(stageUsernameAdmin)
                .setPasswordField(stagePasswordAdmin)
                .loginAsAdmin()
                .clickClientsLink()
                .setClientSearchByEmailField(email)
                .focusOutSearchFields()
                .clickUpdateButton()
                .switchStatusToActive()
                .clickSaveButton();
    }


    public static void deleteNewClient(String email, String company) {
        GenericPage
                .openLoginAdminPage()
                .setUsernameField(stageUsernameAdmin)
                .setPasswordField(stagePasswordAdmin)
                .loginAsAdmin()
                .clickClientsLink()
                .setClientSearchByEmailField(email)
                .focusOutSearchFields()
                .clickDeleteButton()
                .pressEnterKey();
        new MainAdminPage()
                .clickCompaniesLink()
                .setClientSearchByCompanyField(company)
                .focusOutSearchFields()
                .clickDeleteButton()
                .pressEnterKey();
        clearBrowserCookies();
    }

    public static void resetDefaultClientPassword(String email){
        GenericPage
                .openLoginAdminPage()
                .setUsernameField(stageUsernameAdmin)
                .setPasswordField(stagePasswordAdmin)
                .loginAsAdmin()
                .clickClientsLink()
                .setClientSearchByEmailField(email)
                .focusOutSearchFields()
                .clickUpdateButton()
                .setPasswordField(managerPassword)
                .setRepeatPasswordField(managerPassword)
                .clickSaveButton();
        clearBrowserCookies();
    }

    public static void resetDefaultManagerPassword(String email){
        GenericPage
                .openLoginAdminPage()
                .setUsernameField(stageUsernameAdmin)
                .setPasswordField(stagePasswordAdmin)
                .loginAsAdmin()
                .clickManagersLink()
                .setManagerSearchByEmailField(email)
                .focusOutSearchFields()
                .clickUpdateButton()
                .setPasswordField(managerPassword)
                .setRepeatPasswordField(managerPassword)
                .clickSaveButton();
        clearBrowserCookies();
    }

    public static void recordInvoiceCredentialToFile(String invoicingClientEmail, String invoicingClientPassword,
                                                     String invoicingCompanyName){
        File file = new File("src/test/resources/credentials.properties");
        Properties prop = new Properties();
        try (InputStream in = new FileInputStream(file))
        {
            if (in == null) {
                throw new FileNotFoundException();
            }
            prop.load(in);
            prop.setProperty("invoicing.client.email", invoicingClientEmail);
            prop.setProperty("invoicing.client.password", invoicingClientPassword);
            prop.setProperty("invoicing.client.company.name", invoicingCompanyName);

            OutputStream out = new FileOutputStream(file);
            prop.store(out, "update date");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void logoutAndLoginAsClient(String email, String password){
        clearBrowserLocalStorage();
        GenericPage
                .openLoginPage()
                .setEmailField(email)
                .setPasswordField(password)
                .loginAsClient();
    }

    public static void logoutAndLoginAsManager(){
        clearBrowserLocalStorage();
        GenericPage
                .openLoginPage()
                .setEmailField(dataGenerationManagerEmail)
                .setPasswordField(dataGenerationManagerPassword)
                .loginAsManager();
    }

    public void refreshPage(){
        sleep(2000);
        refresh();
        sleep(2000);
    }

    public String getEntityId(){
        int lastSlashIndex = url().lastIndexOf("/");
        return url().substring(lastSlashIndex + 1);
    }

}
