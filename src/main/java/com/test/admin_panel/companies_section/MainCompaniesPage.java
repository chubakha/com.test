package com.test.admin_panel.companies_section;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.test.admin_panel.clients_section.MainClientPage;

import static com.codeborne.selenide.Selenide.$x;

public class MainCompaniesPage {
    private SelenideElement clientSearchByCompanyField = $x("//input[contains(@name, 'CompanySearch') and contains(@name, 'name')]");
    private SelenideElement pageTitle = $x("//h1");
    private SelenideElement deleteButton = $x("//a[contains(@title, 'Delete')]");
    private SelenideElement noResultMessage = $x("//*[contains(text(), 'No results found.')]");

    public MainCompaniesPage setClientSearchByCompanyField(String searchRequest){
        clientSearchByCompanyField.val(searchRequest);
        return this;
    }

    public MainCompaniesPage focusOutSearchFields(){
        pageTitle.click();
        return this;
    }

    public MainCompaniesPage clickDeleteButton(){
        deleteButton.click();
        return this;
    }

    public MainCompaniesPage pressEnterKey(){
        Selenide.switchTo().alert().accept();
        return this;
    }

    public boolean isNoResultMessageShown(){
        return noResultMessage.exists();
    }


}
