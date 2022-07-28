package com.test.admin_panel;

import static com.codeborne.selenide.Selenide.open;

public class PreparingAdminPanelTestData {

    public static void openLoginAdminPage(){
        open("https://stag.admin.legalnodes.co");
    }

}
