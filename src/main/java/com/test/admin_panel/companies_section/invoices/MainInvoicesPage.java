package com.test.admin_panel.companies_section.invoices;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class MainInvoicesPage {

    private final SelenideElement sortByIdLink = $x("//a[text() = 'ID']");
    private final SelenideElement viewButton = $x("//a[@title = 'View']");
    private final SelenideElement pageTitle = $x("//h1");
    private final SelenideElement invoiceSearchByCompanyNameField = $x("//input[contains(@name, 'InvoiceSearchForm') and contains(@name, 'company_name')]");
    private final SelenideElement updateButton = $x("//a[contains(@title, 'Update')]");

    public MainInvoicesPage clickSortByIdLink(){
        sleep(5000);
        sortByIdLink.click();
        return this;
    }

    public ViewInvoicesPage clickViewButton(){
        viewButton.click();
        return new ViewInvoicesPage();
    }

    public MainInvoicesPage setInvoiceSearchByCompanyNameField(String searchRequest){
        invoiceSearchByCompanyNameField.val(searchRequest);
        return this;
    }

    public UpdateInvoicePage clickUpdateButton(){
        updateButton.click();
        return new UpdateInvoicePage();
    }

    public MainInvoicesPage focusOutSearchFields(){
        pageTitle.click();
        return this;
    }

}
