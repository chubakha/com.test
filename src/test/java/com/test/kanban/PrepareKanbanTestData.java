package com.test.kanban;

import com.test.PrepareOverallTestData;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.clearBrowserLocalStorage;

public class PrepareKanbanTestData extends PrepareOverallTestData {
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
}
