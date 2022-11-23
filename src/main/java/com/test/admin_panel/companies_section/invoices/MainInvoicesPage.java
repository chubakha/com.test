package com.test.admin_panel.companies_section.invoices;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class MainInvoicesPage {

    private final SelenideElement sortByIdLink = $x("//a[text() = 'ID']");
    private final SelenideElement viewButton = $x("//a[@title = 'View']");

    public MainInvoicesPage clickSortByIdLink(){
        sleep(1000);
        sortByIdLink.click();
        return this;
    }

    public ViewInvoicesPage clickViewButton(){
        viewButton.click();
        return new ViewInvoicesPage();
    }

}
