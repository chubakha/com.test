package com.test.registration.first_registration_page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$$x;

public class VerifyToolTipsPopupIsShownTest extends PrepareFirstRegistrationPageTestData {
    private ElementsCollection toolTipText = $$x("//div[contains(@class,'FirstStep_firstStepBlockTooltipDropDown')]");
    private ElementsCollection toolTipIcons = $$x("//div[contains(@class,'FirstStep_firstStepBlockHeading')]/div[contains(@class,'FirstStep_firstStepBlockTooltip')]");
    @Test
    void verifyToolTipsPopupIsShown(){
        for (int i = 0; i < toolTipIcons.size(); i++){
            new FirstRegistrationPage().hoverOneInfoIcon(toolTipIcons.get(i));
            System.out.println(toolTipIcons.get(i));
            toolTipText.get(i).has(Condition.cssValue("display", "block"));
        }
    }
}
