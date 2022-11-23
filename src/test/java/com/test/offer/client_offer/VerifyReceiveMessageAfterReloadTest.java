package com.test.offer.client_offer;

import com.test.PrepareOverallTestData;
import com.test.kanban.client_kanban.ClientDetailOfferPage;
import com.test.login.LoginCabinetPage;
import com.test.offer.PrepareOfferTestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class VerifyReceiveMessageAfterReloadTest extends PrepareOfferTestData {

    @Test
    void verifyReceiveMessageAfterReload(){

        String randomOfferOrRequest = String.valueOf((int) (Math.ceil(Math.random()*6)));
        String managerMessage = faker.lorem().sentence();
        String todayDate = (new PrepareOverallTestData().getTodayDateEuSlash());

        ClientDetailOfferPage clientDetailOfferPage = new LoginCabinetPage()
                .setEmailField(managerEmail)
                .setPasswordField(managerPassword)
                .loginAsManager()
                .clickCompanyListDropdown()
                .clickCompanyInDropdown(dataGenerationClientCompany)
                .clickOfferCard(randomOfferOrRequest)
                .switchToChatIframe()
                .setCommentField(managerMessage)
                .switchToRootContainerPage()
                .clickSendCommentButton()
                .clickLogOutLink()
                .setEmailField(dataGenerationClientEmail)
                .setPasswordField(dataGenerationClientPassword)
                .loginAsClient()
                .clickLegalBoardLink()
                .clickOfferCard(randomOfferOrRequest);
        sleep(2000);
        Assertions.assertAll(
                () -> Assertions.assertEquals(managerMessage, clientDetailOfferPage.getLastChatMessageText(),
                        String.format("'%s' message should be shown as last", managerMessage)),
                () -> Assertions.assertEquals(mainManagerFirstName + " " + mainManagerLastName,
                        clientDetailOfferPage.getLastChatMessageAuthor(),
                        "'DataGenerationFirstName DataGenerationLastName' should be shown as author of last message"),
                () -> Assertions.assertEquals(todayDate, clientDetailOfferPage.getLastChatMessageDate(),
                        String.format("'%s' should be shown as date of last message", todayDate))
        );
    }
}
