package com.test.kanban;

import com.test.PrepareOverallTestData;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class PrepareKanbanTestData extends PrepareOverallTestData {
    @BeforeEach
    void openPage() {
        open("https://stag.cabinet.legalnodes.co/");
    }
}
