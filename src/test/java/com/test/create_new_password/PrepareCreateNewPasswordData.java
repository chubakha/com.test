package com.test.create_new_password;

import com.test.PrepareOverallTestData;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;

public class PrepareCreateNewPasswordData extends PrepareOverallTestData {

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
