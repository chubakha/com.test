package com.test.settings;

import com.test.GenericPage;
import com.test.PrepareOverallTestData;
import com.test.RegistrationParametersType;
import com.test.onboarding.PrepareOnboardingTestData;
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
    void closeBrowser(){
        clearBrowserLocalStorage();
        localStorage().clear();
        clearBrowserCookies();
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
        sleep(2000);
    }
}
