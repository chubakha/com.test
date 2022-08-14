package com.test.admin_panel.clients_section;

import com.codeborne.selenide.SelenideElement;
import com.test.admin_panel.LoginAdminPage;

import static com.codeborne.selenide.Selenide.$x;

public class ViewClientPage {
    private final SelenideElement pageTitle = $x("//h1");
    private final SelenideElement statusState = $x("//th[contains(text(), 'Status')]/following-sibling::td");

    public boolean isPageTitleShown(){
        return pageTitle.exists();
    }

    public String getStatusState(){
        return statusState.getText();
    }
}
