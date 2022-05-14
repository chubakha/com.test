package com.test.registration.first_registration_page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.Random;

import static com.codeborne.selenide.Selenide.*;

public class FirstRegistrationPage {
    private ElementsCollection toolTipIcons = $$x("//div[contains(@class,'FirstStep_firstStepBlockHeading')]/div[contains(@class,'FirstStep_firstStepBlockTooltip')]");

    public SecondRegistrationPage clickOneCheckboxInEverySection() {
        clickRandomIncorporationCheckBox();
        clickAccountingAndTaxesOneCheckbox();
        clickHiringOneCheckbox();
        clickNextButton();
        return new SecondRegistrationPage();
    }

    public SecondRegistrationPage clickAllCheckboxInEverySection() {
        clickAllCheckboxInIncorporation();
        clickAllCheckboxInAccountingAndTaxes();
        clickAllCheckboxInHiring();
        clickNextButton();
        return new SecondRegistrationPage();
    }

    public FirstRegistrationPage clickRandomIncorporationCheckBox() {
        int randomIncorporation = choiceRandomOneCheckbox(3);
        IncorporationValuesType incorporation = IncorporationValuesType.values()[randomIncorporation];
        clickCheckbox(incorporation.getValue());
        return this;
    }

    public FirstRegistrationPage clickAccountingAndTaxesOneCheckbox() {
        int randomAccountingAndTaxes = choiceRandomOneCheckbox(6);
        AccountingAndTaxesValueType accountingandtaxes = AccountingAndTaxesValueType.values()[randomAccountingAndTaxes];
        clickCheckbox(accountingandtaxes.getValue());
        return this;
    }

    public FirstRegistrationPage clickHiringOneCheckbox() {
        int randomHiring = choiceRandomOneCheckbox(4);
        HiringValueType hiring = HiringValueType.values()[randomHiring];
        clickCheckbox(hiring.getValue());
        return this;
    }

    public FirstRegistrationPage clickAllCheckboxInIncorporation() {
        for (IncorporationValuesType incorporation : IncorporationValuesType.values()) {
            clickCheckbox(incorporation.getValue());
        }
        return this;
    }

    public FirstRegistrationPage clickAllCheckboxInAccountingAndTaxes() {
        for (AccountingAndTaxesValueType accountingandtaxes : AccountingAndTaxesValueType.values()) {
            clickCheckbox(accountingandtaxes.getValue());
        }
        return this;
    }

    public FirstRegistrationPage clickAllCheckboxInHiring() {
        for (HiringValueType hiring : HiringValueType.values()) {
            clickCheckbox(hiring.getValue());
        }
        return this;
    }

    public boolean[] hoverAllInfoIcon() {
        boolean[] textHintArray = new boolean[toolTipIcons.size()];
        for (int i = 0; i < toolTipIcons.size(); i++) {
            toolTipIcons.get(i).hover();
            textHintArray[i] = $$x("//div[contains(@class,'FirstStep_firstStepBlockTooltipDropDown')]").get(i).isDisplayed();
        }
        return textHintArray;
    }

    public int choiceRandomOneCheckbox(int amount) {
        return new Random().nextInt(amount);
    }

    public FirstRegistrationPage clickCheckbox(String value) {
        String xpath = String.format("//*[text() = '%s']", value);
        $x(xpath).click();
        return this;
    }

    public void clickNextButton() {
        $x("//*[text() = 'NEXT']").click();
    }

    public CreateCustomRequestOverlay clickNeedHelpWithSomethingElseButton() {
        $x("(//div[contains(@class,'FirstStep_customRequestBlock')])[1]").click();
        return new CreateCustomRequestOverlay();
    }

    public FirstRegistrationPage deleteNeedHelpWithSomethingElseButton() {
        $x("(//div[contains(@class,'FirstStep_customRequestBlock')])[1]/div/div[2]/div[contains(@class, 'checkbox_checkbox')]").click();
        return this;
    }

    public String getWhatDoYouNeedLegallySolved() {
        return $x("//*[text() = 'What do you need legally solved?']").getText();
    }

    public String getStepNumberTextLabel() {
        return $x("//div[@class='registration-quiz__header-container']/b").getText();
    }

    public String getAddedNeedHelpWithSomethingElseText() {
        return $x("(//div[contains(@class,'FirstStep_customRequestBlock')])[1]/div/div[2]/div/span").getText();
    }

    public String getNeedHelpWithSomethingElseText() {
        return $x("(//div[contains(@class,'FirstStep_customRequestBlock')])[1]/div/div[1]").getText();
    }

    public boolean isNotNeedHelpWithSomethingElse() {
        return $x("//*[contains(@class, 'slide-enter-done')]").isDisplayed();
    }
}
