package com.test.onboarding;

import com.test.PrepareOverallTestData;
import com.test.RegistrationParametersType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.Random;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.clearBrowserCookies;

public class PrepareOnboardingTestData extends PrepareOverallTestData {

    @BeforeEach
    void openPage() {
        //setUp();
        open(domainCabinet + "/registration" + "?param=" + String.valueOf(RegistrationParametersType.values()[getRandomManager(3)]).toLowerCase());
    }

    @AfterEach
    void closeBrowser(){
        clearBrowserLocalStorage();
        localStorage().clear();
        clearBrowserCookies();
    }

    public int getRandomManager(int amount){
        return new Random().nextInt(amount);
    }

    protected static int dayToday = Integer.parseInt(getTodayDateEuSlash().substring(0, getTodayDateEuSlash().indexOf("/")));

    protected static int getOnboardingInvoicePrice(){
        int onboardingInvoicePrice = 0;
        if (dayToday >= 1 & dayToday<=6){
            onboardingInvoicePrice = 500;
        }
        else if (dayToday > 6 & dayToday <=12){
            onboardingInvoicePrice = 400;
        }
        else if (dayToday > 12 & dayToday <=18){
            onboardingInvoicePrice = 300;
        }
        else if (dayToday > 18 & dayToday <=24){
            onboardingInvoicePrice = 200;
        }
        else if (dayToday > 24 & dayToday <=31){
            onboardingInvoicePrice = 100;
        }
        return onboardingInvoicePrice;
    }

}
