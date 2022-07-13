package com.test.login;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Properties;

import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class LoginPageTest extends PreparingTestData {

    @Test
    void loginPageTest() throws IOException{
        FileInputStream fileInputStream;
        Properties prop = new Properties();
        fileInputStream = new FileInputStream("src/main/resources/credentials.properties");
        prop.load(fileInputStream);
        String email = prop.getProperty("stag.email");
        String password = prop.getProperty("stag.password");

    }



}
