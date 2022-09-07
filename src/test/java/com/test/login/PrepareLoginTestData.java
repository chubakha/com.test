package com.test.login;

import com.test.PrepareOverallTestData;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;


public class PrepareLoginTestData extends PrepareOverallTestData {

    @BeforeEach
    void openPage() {
        //setUp();
        open("https://stag.cabinet.legalnodes.co/");
    }

}
