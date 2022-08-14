package com.test.admin_panel.manager_section;

import com.codeborne.selenide.SelenideElement;
import com.test.admin_panel.clients_section.ViewClientPage;

import static com.codeborne.selenide.Selenide.$x;

public class UpdateManagerPage {

    private final SelenideElement statusSelect = $x("//select[contains(@id, 'status')]");
    private final SelenideElement saveButton = $x("//button[contains(text(), 'Save')]");
    private final SelenideElement passwordField = $x("//input[@id = 'userform-password']");
    private final SelenideElement repeatPasswordField = $x("//input[@id = 'userform-password_repeat']");

    public UpdateManagerPage activateStatus(){
        statusSelect.selectOption(1);
        return this;
    }

    public UpdateManagerPage setPasswordField(String password){
        passwordField.val(password);
        return this;
    }

    public UpdateManagerPage setRepeatPasswordField(String password){
        repeatPasswordField.val(password);
        return this;
    }

    public ViewManagerPage clickSaveButton(){
        saveButton.click();
        return new ViewManagerPage();
    }
}
