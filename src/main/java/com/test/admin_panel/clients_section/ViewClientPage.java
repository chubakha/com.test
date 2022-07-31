package com.test.admin_panel.client_section;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ViewClientPage {
    private SelenideElement pageTitle = $x("//h1");

    public boolean isPageTitleShown(){
        return pageTitle.exists();
    }
}
