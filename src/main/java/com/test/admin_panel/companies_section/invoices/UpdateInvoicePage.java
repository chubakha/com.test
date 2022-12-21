package com.test.admin_panel.companies_section.invoices;

import com.codeborne.selenide.SelenideElement;
import com.test.admin_panel.clients_section.UpdateClientPage;
import com.test.admin_panel.clients_section.ViewClientPage;

import static com.codeborne.selenide.Selenide.$x;

public class UpdateInvoicePage {

    private final SelenideElement statusSelect = $x("//select[contains(@id, 'invoiceform-status')]");
    private final SelenideElement saveButton = $x("//button[contains(text(), 'Save')]");

    public UpdateInvoicePage switchStatusToUnpaid(){
        statusSelect.selectOption(0);
        return this;
    }

    public ViewInvoicesPage clickSaveButton(){
        saveButton.click();
        return new ViewInvoicesPage();
    }
}
