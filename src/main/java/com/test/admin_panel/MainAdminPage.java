package com.test.admin_panel;

import com.codeborne.selenide.SelenideElement;
import com.test.admin_panel.clients_section.MainClientPage;
import com.test.admin_panel.companies_section.MainCompaniesPage;
import com.test.admin_panel.manager_section.MainManagerPage;
import com.test.admin_panel.onboarding_section.MainOnboardingPage;

import static com.codeborne.selenide.Selenide.$x;

public class MainAdminPage {
    private final SelenideElement clientsLink = $x("//span[contains(text(), 'Clients')]");
    private final SelenideElement managerLink = $x("//span[contains(text(), 'Managers')]");
    private final SelenideElement companiesLink = $x("//span[contains(text(), 'Companies')]");
    private final SelenideElement logoutLink = $x("//*[contains(@id, 'logout')]");

    public MainClientPage clickClientsLink(){
        clientsLink.click();
        return new MainClientPage();
    }

    public MainCompaniesPage clickCompaniesLink(){
        companiesLink.click();
        return new MainCompaniesPage();
    }

    public MainManagerPage clickManagersLink(){
        managerLink.click();
        return new MainManagerPage();
    }

    public LoginAdminPage clickLogoutLink(){
        logoutLink.click();
        return new LoginAdminPage();
    }
}
