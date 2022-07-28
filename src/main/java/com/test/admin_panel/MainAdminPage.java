package com.test.admin_panel;

import com.codeborne.selenide.SelenideElement;
import com.test.admin_panel.client_section.MainClientPage;

import static com.codeborne.selenide.Selenide.$x;

public class MainAdminPage {
    private SelenideElement clientsLink = $x("//*[contains(text(), 'Clients')]");

    public MainClientPage clickClientsLink(){
        clientsLink.click();
        return new MainClientPage();
    }
}
