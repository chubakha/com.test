package com.test.registration;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class PrepareRegistrationTestData {

    @BeforeEach
    void openPage(){
        //setUp();
        open("https://stag.cabinet.legalnodes.co/registration");
    }

    public void setUp() {
        Configuration.headless = true;
    }

    public static final String AUTHOR_ALEX_CHU = "Alex Chu";
    public static final String STEP_FIRST_REGISTRATION_PAGE = "First registration page";
    public static final String STEP_SECOND_REGISTRATION_PAGE = "Second registration page";
    public static final String STEP_THIRD_REGISTRATION_PAGE = "Third registration page";
    public static final String STEP_FOURTH_REGISTRATION_PAGE = "Fourth registration page";
}
