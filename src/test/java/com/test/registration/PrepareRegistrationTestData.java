package com.test.registration;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;

public class PrepareRegistrationTestData {

    public static WebDriver driver;

    @BeforeEach
    void openPage(){
        open("https://stag.cabinet.legalnodes.co/registration");
    }

    @BeforeAll
    static void testTest(){
        faker = new Faker();
    }

    public void setUp() {
        Configuration.headless = true;
    }

    public static final String AUTHOR_ALEX_CHU = "Alex Chu";

    public static Faker faker;

    protected static String usernameAdmin;
    protected static String passwordAdmin;

    @BeforeAll
    static void generalLinksInitialization() {
        usernameAdmin = PrepareRegistrationTestData.getUsernameAdmin();
        passwordAdmin = PrepareRegistrationTestData.getEmailAdmin();
    }

    private static String getUsernameAdmin() {
        return getPropertyFileData().getProperty("stag.admin.username");
    }

    private static String getEmailAdmin(){
        return getPropertyFileData().getProperty("stag.admin.password");
    }

    private static Properties getPropertyFileData(){
        Properties prop = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/credentials.properties");
            prop.load(fileInputStream);
        } catch (Exception e){
            e.printStackTrace();
        }
        return prop;
    }

}
