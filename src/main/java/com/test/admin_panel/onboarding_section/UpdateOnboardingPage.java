package com.test.admin_panel.onboarding_section;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class UpdateOnboardingPage {

    private final SelenideElement statusSelect = $x("//select[contains(@id, 'stage_result')]");
    private final SelenideElement saveButton = $x("//button[contains(text(), 'Save')]");

    public UpdateOnboardingPage switchStageResultToDone(){
        statusSelect.selectOption(0);
        return this;
    }

    public ViewOnboardingPage clickSaveButton(){
        saveButton.click();
        return new ViewOnboardingPage();
    }
}
