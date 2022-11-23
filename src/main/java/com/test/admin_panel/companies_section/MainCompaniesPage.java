package com.test.admin_panel.companies_section;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.test.admin_panel.companies_section.invoices.MainInvoicesPage;

import static com.codeborne.selenide.Selenide.$x;

public class MainCompaniesPage {
    private final SelenideElement clientSearchByCompanyField = $x("//input[contains(@name, 'CompanySearch') and contains(@name, 'name')]");
    private final SelenideElement pageTitle = $x("//h1");
    private final SelenideElement deleteButton = $x("//a[contains(@title, 'Delete')]");
    private final SelenideElement noResultMessage = $x("//*[contains(text(), 'No results found.')]");
    private final SelenideElement invoicesLink = $x("//span[contains(text(), 'Invoices')]");

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

    public MainInvoicesPage clickInvoicesLink(){
        invoicesLink.click();
        return new MainInvoicesPage();
    }


}
