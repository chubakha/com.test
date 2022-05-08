package com.test.registration;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.Random;

import static com.codeborne.selenide.Selenide.*;

public class FirstRegistrationPage {
    private SelenideElement nextButton = $x("//*[text() = 'NEXT']");
    private SelenideElement needHelpWithSomethingElse = $x("(//div[contains(@class,'FirstStep_customRequestBlock')])[1]");
    private ElementsCollection toolTipIcons = $$x("//div[contains(@class,'FirstStep_firstStepBlockHeading')]/div[contains(@class,'FirstStep_firstStepBlockTooltip')]");

    private SelenideElement whatDoYouNeedLegallySolved = $x("//*[text() = 'What do you need legally solved?']");
    private SelenideElement stepNumberTextLabel = $x("//div[@class='registration-quiz__header-container']/b");
    private SelenideElement needHelpWithSomethingElseSendButton = $x("//*[text() = 'SEND']");
    private SelenideElement needHelpWithSomethingElseTextArea = $x("//*[contains(@class, 'CustomModal_textarea')]");
    private SelenideElement addedHelpWithSomethingElseText = $x("(//div[contains(@class,'FirstStep_customRequestBlock')])[1]/div/div[2]/div[contains(@class, 'checkbox_checkbox')]");
    public String needhelpwithsomethingelseText = "my custom need";//????

    public SecondRegistrationPage clickOneCheckboxInEverySection(){
        clickRandomIncorporationCheckBox();
        clickAccountingAndTaxesOneCheckbox();
        clickHiringOneCheckbox();
        clickNextButton();
        return new SecondRegistrationPage();
    }

    public SecondRegistrationPage clickAllCheckboxInEverySection(){
        clickAllCheckboxInIncorporation();
        clickAllCheckboxInAccountingAndTaxes();
        clickAllCheckboxInHiring();
        clickNextButton();
        return new SecondRegistrationPage();
    }

    public FirstRegistrationPage clickRandomIncorporationCheckBox(){
        int randomIncorporation = choiceRandomOneCheckbox(3);
        IncorporationValuesType incorporation = IncorporationValuesType.values()[randomIncorporation];
        clickCheckbox(incorporation.getValue());
        return this;
    }

    public FirstRegistrationPage clickAccountingAndTaxesOneCheckbox(){
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

    public FirstRegistrationPage hoverOneInfoIcon(SelenideElement selenideElement) {
        selenideElement.hover();
        return this;
    }

    public int choiceRandomOneCheckbox(int amount){
        return new Random().nextInt(amount);
    }

    public FirstRegistrationPage setNeedHelpWithSomethingElseText(){
        needHelpWithSomethingElseTextArea.val(needhelpwithsomethingelseText);
        return this;
    }

    public String getNeedHelpWithSomethingElseText(){
        return needHelpWithSomethingElseTextArea.getText();
    }

    public FirstRegistrationPage clickNeedHelpWithSomethingElseSendButton(){
        needHelpWithSomethingElseSendButton.click();
        return this;
    }

    public FirstRegistrationPage clickCheckbox(String value){
        String xpath = String.format("//*[text() = '%s']", value);
        $x(xpath).click();
        return this;
    }

    public void clickNextButton() {
        nextButton.click();
    }

    public FirstRegistrationPage clickNeedHelpWithSomethingElseButton() {
        needHelpWithSomethingElse.click();
        return this;
    }

    public FirstRegistrationPage deleteNeedHelpWithSomethingElseButton() {
        addedHelpWithSomethingElseText.click();
        return this;
    }

    public String getWhatDoYouNeedLegallySolved(){
        return whatDoYouNeedLegallySolved.getText();
    }

    public String getStepNumberTextLabel(){
        return stepNumberTextLabel.getText();
    }
}
