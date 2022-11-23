package com.test.offer.manager_offer;

import com.test.PrepareOverallTestData;
import com.test.kanban.manager_kanban.ManagerDetailOfferPage;
import com.test.login.LoginCabinetPage;
import com.test.offer.PrepareOfferTestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Selenide.sleep;

public class VerifyReceiveMessageAfterReloadTest extends PrepareOfferTestData {

    @Test
    void verifyReceiveMessageAfterReload(){

        String randomOfferOrRequest = String.valueOf((int) (Math.ceil(Math.random()*6)));
        String managerMessage = faker.lorem().sentence();
        String todayDate = (new PrepareOverallTestData().getTodayDateEuSlash());

        ManagerDetailOfferPage managerDetailOfferPage = new LoginCabinetPage()
                .setEmailField(dataGenerationClientEmail)
                .setPasswordField(dataGenerationClientPassword)
                .loginAsClient()
                .clickOfferCard(randomOfferOrRequest)
                .switchToChatIframe()
                .setCommentField(managerMessage)
                .switchToRootContainerPage()
                .clickSendCommentButton()
                .clickLogOutLink()
                .setEmailField(managerEmail)
                .setPasswordField(managerPassword)
                .loginAsManager()
                .clickLegalBoardLink()
                .clickOfferCard(randomOfferOrRequest);
        sleep(2000);
        Assertions.assertAll(
                () -> Assertions.assertEquals(managerMessage, managerDetailOfferPage.getLastChatMessageText(),
                        String.format("'%s' message should be shown as last", managerMessage)),
                () -> Assertions.assertEquals(dataGenerationClientFirstName + " " + dataGenerationClientLastName,
                        managerDetailOfferPage.getLastChatMessageAuthor(),
                        "'DataGenerationFirstName DataGenerationLastName' should be shown as author of last message"),
                () -> Assertions.assertEquals(todayDate, managerDetailOfferPage.getLastChatMessageDate(),
                        String.format("'%s' should be shown as date of last message", todayDate))
        );
    }
}
