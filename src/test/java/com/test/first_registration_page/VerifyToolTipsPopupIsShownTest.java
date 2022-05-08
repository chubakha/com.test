package com.test.first_registration_page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.test.registration.FirstRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.sleep;

public class VerifyToolTipsPopupIsShownTest extends PrepareFirstRegistrationPageTestData {
    private ElementsCollection toolTipText = $$x("//div[contains(@class,'FirstStep_firstStepBlockTooltipDropDown')]");
    private ElementsCollection toolTipIcons = $$x("//div[contains(@class,'FirstStep_firstStepBlockHeading')]/div[contains(@class,'FirstStep_firstStepBlockTooltip')]");
    @Test
    void verifyToolTipsPopupIsShown(){
        for (int i = 0; i < toolTipIcons.size(); i++){
            new FirstRegistrationPage().hoverOneInfoIcon(toolTipIcons.get(i));
            toolTipText.get(i).has(Condition.cssValue("display", "block!important"));
        }

        /*for (SelenideElement selenideElement : toolTipIcons){
            selenideElement.get();
        }*/

    }
}
