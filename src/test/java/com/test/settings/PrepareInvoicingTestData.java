package com.test.settings;

import com.codeborne.selenide.Selenide;
import com.test.GenericPage;
import com.test.PrepareOverallTestData;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.Random;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.clearBrowserCookies;

public class PrepareInvoicingTestData extends PrepareOverallTestData {

    @BeforeEach
    void openPage() {
        //setUp();
        open(domainCabinet);
    }

    @AfterEach
    void clearCookiesAndLocalStorage(){
        Selenide.clearBrowserCookies();
        localStorage().clear();
    }

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
        clearBrowserCookies();
    }
}
