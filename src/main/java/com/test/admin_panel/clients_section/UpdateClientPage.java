package com.test.admin_panel.clients_section;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class UpdateClientPage {
    private final SelenideElement statusSelect = $x("//select[contains(@id, 'status')]");
    private final SelenideElement saveButton = $x("//button[contains(text(), 'Save')]");
    private final SelenideElement passwordField = $x("//input[@id = 'userform-password']");
    private final SelenideElement repeatPasswordField = $x("//input[@id = 'userform-password_repeat']");

    public UpdateClientPage switchStatusToActive(){
        statusSelect.selectOption(1);
        return this;
    }

    public UpdateClientPage setPasswordField(String password){
        passwordField.val(password);
        return this;
    }

    public UpdateClientPage setRepeatPasswordField(String password){
        repeatPasswordField.val(password);
        return this;
    }

    public ViewClientPage clickSaveButton(){
        saveButton.click();
        sleep(4000);
        return new ViewClientPage();
    }
}
