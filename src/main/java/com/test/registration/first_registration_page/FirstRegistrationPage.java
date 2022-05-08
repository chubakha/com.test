package com.test.registration.first_registration_page;

import com.codeborne.selenide.SelenideElement;
import com.test.registration.*;

import java.util.Random;

import static com.codeborne.selenide.Selenide.*;

public class FirstRegistrationPage {
    private SelenideElement nextButton = $x("//*[text() = 'NEXT']");
    private SelenideElement needHelpWithSomethingElse = $x("(//div[contains(@class,'FirstStep_customRequestBlock')])[1]");
    private SelenideElement whatDoYouNeedLegallySolved = $x("//*[text() = 'What do you need legally solved?']");
    private SelenideElement stepNumberTextLabel = $x("//div[@class='registration-quiz__header-container']/b");
    private SelenideElement needHelpWithSomethingElseSendButton = $x("//*[text() = 'SEND']");
    private SelenideElement addedHelpWithSomethingElseText = $x("(//div[contains(@class,'FirstStep_customRequestBlock')])[1]/div/div[2]/div[contains(@class, 'checkbox_checkbox')]");

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

    public CreateCustomRequestOverlay clickNeedHelpWithSomethingElseSendButton(){
        needHelpWithSomethingElseSendButton.click();
        return new CreateCustomRequestOverlay();
    }

    public FirstRegistrationPage clickCheckbox(String value){
        String xpath = String.format("//*[text() = '%s']", value);
        $x(xpath).click();
        return this;
    }

    public void clickNextButton() {
        nextButton.click();
    }

    public CreateCustomRequestOverlay clickNeedHelpWithSomethingElseButton() {
        needHelpWithSomethingElse.click();
        return new CreateCustomRequestOverlay();
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
