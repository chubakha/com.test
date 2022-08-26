package com.test.admin_panel.onboarding_section;

import com.codeborne.selenide.ElementsCollection;
import com.test.admin_panel.clients_section.UpdateClientPage;

import static com.codeborne.selenide.Selenide.$x;

public class MainOnboardingPage {

    public UpdateOnboardingPage clickUpdateButton(int index, String name){
        $x("//tr[td//text()[contains(., '" + name +"')]][" + index + "]//a[contains(@title, 'Update')]").click();
        return new UpdateOnboardingPage();
    }
}
