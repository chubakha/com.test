package com.test.admin_panel.companies_section;

import com.codeborne.selenide.SelenideElement;
import com.test.admin_panel.clients_section.ViewClientPage;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class UpdateCompaniesPage {

    private final SelenideElement debtSelect = $x("//span[contains(@data-select2-id, 'select2-data-1')]");
    private final SelenideElement debtNoneOption = $x("//li[contains(text(), 'none')]");
    private final SelenideElement managerSelect = $x("//span[contains(@aria-labelledby, 'companyform-manager_id')]");
    private final SelenideElement saveButton = $x("//button[contains(text(), 'Save')]");

    public UpdateCompaniesPage clickDebtSelect(){
        debtSelect.click();
        return this;
    }

    public UpdateCompaniesPage clickDebtNone(){
        debtNoneOption.click();
        return this;
    }

    public UpdateCompaniesPage clickManagerSelect(){
        managerSelect.click();
        return this;
    }

    public UpdateCompaniesPage clickCertainManagerOption(String managerName){
        $x("//li[contains(text(), '" + managerName +"')]").click();
        return this;
    }

    public ViewCompaniesPage clickSaveButton(){
        saveButton.click();
        sleep(2000);
        return new ViewCompaniesPage();
    }
}
