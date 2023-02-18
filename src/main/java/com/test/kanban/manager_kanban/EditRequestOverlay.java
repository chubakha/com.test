package com.test.kanban.manager_kanban;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class EditRequestOverlay {

    private final SelenideElement titleField = $x("//input[contains(@placeholder, 'Title')]");
    private final SelenideElement descriptionField = $x("//body[contains(@id, 'tinymce')]");
    private final SelenideElement requestDescriptionIframe = $x("//iframe[contains(@id, 'tiny-react')]");
    private final SelenideElement submitButton = $x("//button[contains(text(), 'Update')]");

    public EditRequestOverlay setTitleField(String title){
        titleField.val(title);
        return this;
    }
    public ManagerDetailRequestPage clickSubmitButton(){
        submitButton.click();
        return new ManagerDetailRequestPage();
    }

    public String getTitleField(){
        return titleField.getValue();
    }

}
