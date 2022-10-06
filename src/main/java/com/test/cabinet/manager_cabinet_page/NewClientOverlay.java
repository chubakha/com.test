package com.test.cabinet.manager_cabinet_page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class NewClientOverlay {
    private final SelenideElement enterClientEmailField = $x("//input[contains(@placeholder, 'email')]");
    private final SelenideElement addNewClientButton = $x("//button[contains(text(), 'Add new client')]");
    private final SelenideElement submitButton = $x("//button[contains(text(), 'Submit')]");

    public String getEnterClientEmailField() {
        return enterClientEmailField.getText();
    }

    public NewClientOverlay setEnterClientEmailField(String email){
        enterClientEmailField.val(email);
        return this;
    }

    public NewClientOverlay clickAddNewClientButtonWithWrongEmail(){
        addNewClientButton.click();
        return this;
    }

    public NewClientOverlay clickAddNewClientButton(){
        addNewClientButton.click();
        return this;
    }

    public ManagerKanbanPage clickSubmitButton(){
        submitButton.click();
        return new ManagerKanbanPage();
    }

}
