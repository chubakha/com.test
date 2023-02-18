package com.test.kanban.manager_kanban;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class EditOfferOverlay {

    private final SelenideElement titleField = $x("//div[contains(@class, 'input__invalid')]/input");
    private final SelenideElement descriptionField = $x("//body[contains(@id, 'tinymce')]");
    private final SelenideElement offerDescriptionIframe = $x("//iframe[contains(@id, 'tiny-react')]");
    private final SelenideElement submitButton = $x("//button[contains(text(), 'Update')]");

    public EditOfferOverlay setTitleField(String title){
        titleField.val(title);
        return this;
    }
    public ManagerDetailOfferPage clickSubmitButton(){
        submitButton.click();
        return new ManagerDetailOfferPage();
    }

    public String getTitleField(){
        return titleField.getValue();
    }

}
