package com.test.settings;

import com.test.GenericPage;
import com.test.PrepareOverallTestData;
import com.test.login.LoginCabinetPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.BeforeTest;

import java.util.Random;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.clearBrowserCookies;

public class PrepareInvoicingTestData extends PrepareOverallTestData {

    @BeforeEach
    void openPage() {
        //setUp();
        open(domainCabinet);
    }

    @BeforeTest
    public static void Login() {
        new LoginCabinetPage()
                .setEmailField(invoicingClientEmail)
                .setPasswordField(invoicingClientPassword)
                .loginAsClient();
    }

//    @AfterEach
//    void clearCookiesAndLocalStorage(){
//        Selenide.clearBrowserCookies();
//        localStorage().clear();
//    }

    protected int getRandomCurrency(int amount){
        return new Random().nextInt(amount);
    }

    protected static void changeTrialInvoiceToUnpaid(){
        GenericPage
                .openLoginAdminPage()
                .setUsernameField(stageUsernameAdmin)
                .setPasswordField(stagePasswordAdmin)
                .loginAsAdmin()
                .clickCompaniesLink()
                .clickInvoicesLink()
                .setInvoiceSearchByCompanyNameField(invoicingCompanyName)
                .focusOutSearchFields()
                .clickUpdateButton()
                .switchStatusToUnpaid()
                .clickSaveButton();
        sleep(2000);
        clearBrowserCookies();
    }
}
