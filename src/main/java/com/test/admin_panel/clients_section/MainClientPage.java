package com.test.admin_panel.clients_section;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainClientPage {
    private final SelenideElement clientSearchByEmailField = $x("//input[contains(@name, 'UserClientSearch') and contains(@name, 'email')]");
    private final SelenideElement pageTitle = $x("//h1");
    private final SelenideElement deleteButton = $x("//a[contains(@title, 'Delete')]");
    private final SelenideElement updateButton = $x("//a[contains(@title, 'Update')]");
    private final SelenideElement noResultMessage = $x("//*[contains(text(), 'No results found.')]");

    public MainClientPage setClientSearchByEmailField(String searchRequest){
        clientSearchByEmailField.val(searchRequest);
        return this;
    }

    public MainClientPage focusOutSearchFields(){
        pageTitle.click();
        return this;
    }

    public MainClientPage clickDeleteButton(){
        deleteButton.click();
        return this;
    }

    public UpdateClientPage clickUpdateButton(){
        updateButton.click();
        return new UpdateClientPage();
    }

    public MainClientPage pressEnterKey(){
        Selenide.switchTo().alert().accept();
        return this;
    }

    public boolean isNoResultMessageShown(){
        return noResultMessage.exists();
    }
}
