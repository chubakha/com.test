package com.test.login;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import com.test.PrepareOverallTestData;
import com.test.registration.PrepareRegistrationTestData;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.io.FileInputStream;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;

public class PrepareLoginTestData extends PrepareOverallTestData {

    protected static String clientEmail;
    protected static String clientPassword;
    protected static String managerEmail;
    protected static String managerPassword;
    protected static String usernameAdmin;
    protected static String passwordAdmin;

    @BeforeEach
    void openPage() {
        //setUp();
        open("https://stag.cabinet.legalnodes.co/");
    }

    @BeforeAll
    static void generalLinksInitialization(){
        clientEmail = PrepareLoginTestData.getClientEmail();
        clientPassword = PrepareLoginTestData.getClientPassword();
        managerEmail = PrepareLoginTestData.getManagerEmail();
        managerPassword = PrepareLoginTestData.getManagerPassword();
        usernameAdmin = PrepareLoginTestData.getUsernameAdmin();
        passwordAdmin = PrepareLoginTestData.getEmailAdmin();
    }

    public static void openLoginPage(){
        open("https://stag.cabinet.legalnodes.co/");
    }

    public static void openYopmailPage(){
        open("https://yopmail.com/ru/");
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

    private static String getUsernameAdmin() {
        return getPropertyFileData().getProperty("stag.admin.username");
    }

    private static String getEmailAdmin(){
        return getPropertyFileData().getProperty("stag.admin.password");
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

    public void setUp() {
        Configuration.headless = true;
    }

}
