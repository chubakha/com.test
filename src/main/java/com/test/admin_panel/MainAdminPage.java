package com.test.admin_panel;

import com.codeborne.selenide.SelenideElement;
import com.test.admin_panel.clients_section.MainClientPage;
import com.test.admin_panel.companies_section.MainCompaniesPage;

import static com.codeborne.selenide.Selenide.$x;

public class MainAdminPage {
    private SelenideElement clientsLink = $x("//span[contains(text(), 'Clients')]");
    private SelenideElement companiesLink = $x("//span[contains(text(), 'Companies')]");

    public MainClientPage clickClientsLink(){
        clientsLink.click();
        return new MainClientPage();
    }

    public MainCompaniesPage clickCompaniesLink(){
        companiesLink.click();
        return new MainCompaniesPage();
    }


}
