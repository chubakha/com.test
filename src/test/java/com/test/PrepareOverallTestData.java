package com.test;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import com.test.forgot_password_mail.MailHogIncomingPage;
import com.test.forgot_password_mail.YopmailIncomingMailPage;
import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
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
    protected static String clientEmailDataGeneration;
    protected static String clientPasswordDataGeneration;

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
        clientEmailDataGeneration = PrepareOverallTestData.getClientEmailDataGeneration();
        clientPasswordDataGeneration = PrepareOverallTestData.getClientPasswordDataGeneration();
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

    private static String getClientEmailDataGeneration(){
        return getPropertyFileData().getProperty("stag.client.email.data-generation");
    }

    private static String getClientPasswordDataGeneration(){
        return getPropertyFileData().getProperty("stag.client.password.data-generation");
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

    public static void redirectToForgetPasswordToken(String email){
        boolean isProd = new YopmailIncomingMailPage().isProductionDomainShown(url());
        if(isProd){
            GenericPage
                    .openYopmailPage()
                    .clickCookiesAcceptButton()
                    .setLoginField(email)
                    .clickLoginButton();
            sleep(2000);
            new YopmailIncomingMailPage()
                    .clickRefreshButton()
                    .switchIframe();
            sleep(2000);
            GenericPage.openAnyLink(new YopmailIncomingMailPage().getForgetPasswordToken());
        }
        else {
            GenericPage
                    .openMailHogPage()
                    .clickIncomingEmail(email);
            GenericPage.openAnyLink(new MailHogIncomingPage().getForgetPasswordToken());
        }
    }
}
