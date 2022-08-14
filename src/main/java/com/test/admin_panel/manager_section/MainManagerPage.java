package com.test.admin_panel.manager_section;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.test.admin_panel.clients_section.MainClientPage;
import com.test.admin_panel.clients_section.UpdateClientPage;

import static com.codeborne.selenide.Selenide.$x;

public class MainManagerPage {

    private final SelenideElement managerSearchByEmailField = $x("//input[contains(@name, 'ManagerSearch') and contains(@name, 'Email')]");
    private final SelenideElement pageTitle = $x("//h1");
    private final SelenideElement deleteButton = $x("//a[contains(@title, 'Delete')]");
    private final SelenideElement updateButton = $x("//a[contains(@title, 'Update')]");
    private final SelenideElement noResultMessage = $x("//*[contains(text(), 'No results found.')]");

    public MainManagerPage setManagerSearchByEmailField(String searchRequest){
        managerSearchByEmailField.val(searchRequest);
        return this;
    }

    public MainManagerPage focusOutSearchFields(){
        pageTitle.click();
        return this;
    }

    public MainManagerPage clickDeleteButton(){
        deleteButton.click();
        return this;
    }

    public UpdateManagerPage clickUpdateButton(){
        updateButton.click();
        return new UpdateManagerPage();
    }

    public MainManagerPage pressEnterKey(){
        Selenide.switchTo().alert().accept();
        return this;
    }

    public boolean isNoResultMessageShown(){
        return noResultMessage.exists();
    }
}
