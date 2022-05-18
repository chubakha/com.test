package com.test.registration.first_registration_page;

import com.codeborne.selenide.ElementsCollection;
import com.test.registration.Functions;
import com.test.registration.second_registration_page.SecondRegistrationPage;

import java.util.Arrays;
import java.util.Random;

import static com.codeborne.selenide.Selenide.*;

public class FirstRegistrationPage {
    private ElementsCollection toolTipIcons = $$x("//div[contains(@class,'FirstStep_firstStepBlockHeading')]/div[contains(@class,'FirstStep_firstStepBlockTooltip')]");
    private ElementsCollection toolTipText = $$x("//div[contains(@class,'FirstStep_firstStepBlockTooltipDropDown')]");
    private ElementsCollection selectedOptions = $$x("//div[contains(@class, 'checkbox_containerActive')]/following-sibling::span");


    public SecondRegistrationPage choiceOneCheckboxInEverySection() {
        selectOneCheckboxInEverySection();
        clickNextButton();
        return new SecondRegistrationPage();
    }

    public FirstRegistrationPage selectOneCheckboxInEverySection() {
        clickRandomIncorporationCheckBox();
        clickRandomAccountingAndTaxesCheckbox();
        clickRandomHiringCheckbox();
        clickRandomIpprotectionCheckbox();
        clickRandomClientAcquisitionCheckbox();
        clickRandomPrivacygdprcomplianceCheckbox();
        clickRandomFundraisingCheckbox();
        clickRandomTokenGenerationDistributionCheckbox();
        clickRandomLaunchingDaoWeb3Checkbox();
        return this;
    }

    public SecondRegistrationPage choiceAllCheckboxInEverySection() {
        selectAllCheckboxInEverySection();
        clickNextButton();
        return new SecondRegistrationPage();
    }

    public FirstRegistrationPage selectAllCheckboxInEverySection() {
        clickAllIncorporationCheckbox();
        clickAllAccountingAndTaxesCheckbox();
        clickAllHiringCheckbox();
        clickAllIpprotectionCheckbox();
        clickAllClientAcquisitionCheckbox();
        clickAllPrivacygdprcomplianceCheckbox();
        clickAllFundraisingCheckbox();
        clickAllTokenGenerationDistributionCheckbox();
        clickAllLaunchingDaoWeb3CheckboxCheckbox();
        return this;
    }

    public FirstRegistrationPage clickRandomIncorporationCheckBox() {
        int randomIncorporation = choiceRandomOneCheckbox(3);
        IncorporationValuesType incorporation = IncorporationValuesType.values()[randomIncorporation];
        clickCheckbox(incorporation.getValue());
        return this;
    }

    public FirstRegistrationPage clickRandomAccountingAndTaxesCheckbox() {
        int randomAccountingAndTaxes = choiceRandomOneCheckbox(5);
        AccountingAndTaxesValueType accountingandtaxes = AccountingAndTaxesValueType.values()[randomAccountingAndTaxes];
        clickCheckbox(accountingandtaxes.getValue());
        return this;
    }

    public FirstRegistrationPage clickRandomHiringCheckbox() {
        int randomHiring = choiceRandomOneCheckbox(4);
        HiringValueType hiring = HiringValueType.values()[randomHiring];
        clickCheckbox(hiring.getValue());
        return this;
    }

    public FirstRegistrationPage clickRandomIpprotectionCheckbox() {
        int randomIpprotection = choiceRandomOneCheckbox(2);
        IpprotectionValueType ipprotection = IpprotectionValueType.values()[randomIpprotection];
        clickCheckbox(ipprotection.getValue());
        return this;
    }

    public FirstRegistrationPage clickRandomClientAcquisitionCheckbox() {
        int randomClientAcquisition = choiceRandomOneCheckbox(3);
        ClientAcquisitionValueType clientAcquisition = ClientAcquisitionValueType.values()[randomClientAcquisition];
        clickCheckbox(clientAcquisition.getValue());
        return this;
    }

    public FirstRegistrationPage clickRandomPrivacygdprcomplianceCheckbox() {
        int randomPrivacygdprcompliance = choiceRandomOneCheckbox(3);
        PrivacygdprcomplianceValueType privacygdprcompliance = PrivacygdprcomplianceValueType.values()[randomPrivacygdprcompliance];
        clickCheckbox(privacygdprcompliance.getValue());
        return this;
    }

    public FirstRegistrationPage clickRandomFundraisingCheckbox() {
        int randomFundraising = choiceRandomOneCheckbox(4);
        FundraisingValueType fundraising = FundraisingValueType.values()[randomFundraising];
        clickCheckbox(fundraising.getValue());
        return this;
    }

    public FirstRegistrationPage clickRandomTokenGenerationDistributionCheckbox() {
        int randomTokenGenerationDistribution = choiceRandomOneCheckbox(4);
        TokenGenerationDistributionValueType tokenGenerationDistribution = TokenGenerationDistributionValueType.values()[randomTokenGenerationDistribution];
        clickCheckbox(tokenGenerationDistribution.getValue());
        return this;
    }

    public FirstRegistrationPage clickRandomLaunchingDaoWeb3Checkbox() {
        int randomLaunchingDaoWeb3 = choiceRandomOneCheckbox(4);
        LaunchingDaoWeb3ValueType launchingDaoWeb3 = LaunchingDaoWeb3ValueType.values()[randomLaunchingDaoWeb3];
        clickCheckbox(launchingDaoWeb3.getValue());
        return this;
    }

    public FirstRegistrationPage clickAllIncorporationCheckbox() {
        for (IncorporationValuesType incorporation : IncorporationValuesType.values()) {
            clickCheckbox(incorporation.getValue());
        }
        return this;
    }

    public FirstRegistrationPage clickAllAccountingAndTaxesCheckbox() {
        for (AccountingAndTaxesValueType accountingandtaxes : AccountingAndTaxesValueType.values()) {
            clickCheckbox(accountingandtaxes.getValue());
        }
        return this;
    }

    public FirstRegistrationPage clickAllHiringCheckbox() {
        for (HiringValueType hiring : HiringValueType.values()) {
            clickCheckbox(hiring.getValue());
        }
        return this;
    }

    public FirstRegistrationPage clickAllIpprotectionCheckbox() {
        for (IpprotectionValueType ipprotection : IpprotectionValueType.values()) {
            clickCheckbox(ipprotection.getValue());
        }
        return this;
    }

    public FirstRegistrationPage clickAllClientAcquisitionCheckbox() {
        for (ClientAcquisitionValueType clientAcquisition : ClientAcquisitionValueType.values()) {
            clickCheckbox(clientAcquisition.getValue());
        }
        return this;
    }

    public FirstRegistrationPage clickAllPrivacygdprcomplianceCheckbox() {
        for (PrivacygdprcomplianceValueType privacygdprcompliance : PrivacygdprcomplianceValueType.values()) {
            clickCheckbox(privacygdprcompliance.getValue());
        }
        return this;
    }

    public FirstRegistrationPage clickAllFundraisingCheckbox() {
        for (FundraisingValueType fundraising : FundraisingValueType.values()) {
            clickCheckbox(fundraising.getValue());
        }
        return this;
    }

    public FirstRegistrationPage clickAllTokenGenerationDistributionCheckbox() {
        for (TokenGenerationDistributionValueType tokenGenerationDistribution : TokenGenerationDistributionValueType.values()) {
            clickCheckbox(tokenGenerationDistribution.getValue());
        }
        return this;
    }

    public FirstRegistrationPage clickAllLaunchingDaoWeb3CheckboxCheckbox() {
        for (LaunchingDaoWeb3ValueType daoWeb3Checkbox : LaunchingDaoWeb3ValueType.values()) {
            clickCheckbox(daoWeb3Checkbox.getValue());
        }
        return this;
    }

    public boolean[] hoverAllInfoIcon() {
        boolean[] textHintArray = new boolean[toolTipIcons.size()];
        for (int i = 0; i < toolTipIcons.size(); i++) {
            toolTipIcons.get(i).hover();
            textHintArray[i] = toolTipText.get(i).isDisplayed();
        }
        return textHintArray;
    }

    public String[] getToolTipText(){
        String[] textHintArray = new String[toolTipText.size()];
        for (int i = 0; i < toolTipText.size(); i++) {
            textHintArray[i] = toolTipText.get(i).innerText();
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

    public String[] getChosenOptions(){
        choiceOneCheckboxInEverySection();
        String[] chosenListFirstCopy = new Functions().getChosenOptions(selectedOptions);
        String[] chosenListFirst = Arrays.copyOfRange(chosenListFirstCopy, 0, chosenListFirstCopy.length/2);
        return chosenListFirst;
    }


}
