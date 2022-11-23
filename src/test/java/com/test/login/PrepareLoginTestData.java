package com.test.login;

import com.test.PrepareOverallTestData;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;


public class PrepareLoginTestData extends PrepareOverallTestData {

    @BeforeEach
    void openPage() {
        //setUp();
        open(domainCabinet);
    }

    @AfterEach
    void closeBrowser(){
        clearBrowserLocalStorage();
        localStorage().clear();
    }

}
