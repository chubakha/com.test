package com.test.login;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.io.FileInputStream;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;

public class PrepareLoginTestData {

    protected static String email;
    protected static String password;

    @BeforeEach
    void openPage() {
        //setUp();
        open("https://stag.cabinet.legalnodes.co/");
    }

    @BeforeAll
    static void generalLinksInitialization(){
        faker = new Faker();
        email = PrepareLoginTestData.getEmail();
        password = PrepareLoginTestData.getPassword();
    }

    public static Faker faker;

    private static String getEmail() {
        return getPropertyFileData().getProperty("stag.client.email");
    }

    private static String getPassword(){
        return getPropertyFileData().getProperty("stag.client.password");
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

    public void setUp() {
        Configuration.headless = true;
    }
}
