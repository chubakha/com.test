package com.test.offer.manager_offer;

import com.test.PrepareOverallTestData;
import com.test.kanban.manager_kanban.ManagerDetailOfferPage;
import com.test.kanban.manager_kanban.ManagerKanbanPage;
import com.test.login.LoginCabinetPage;
import com.test.offer.PrepareOfferTestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class VerifySendMinLimitSymbolsMessageTest extends PrepareOfferTestData {

    @Test
    void verifySendMinLimitSymbolsMessage(){

        String managerMessage = (String.valueOf(faker.lorem().character()));
        String todayDate = (new PrepareOverallTestData().getTodayDateEuSlash());
        String randomOfferOrRequest = String.valueOf((int) (Math.ceil(Math.random()*6)));

        new LoginCabinetPage()
                .setEmailField(managerEmail)
                .setPasswordField(managerPassword)
                .loginAsManager()
                .clickCompanyListDropdown()
                .clickCompanyInDropdown(dataGenerationClientCompany);
        sleep(2000);
        ManagerDetailOfferPage managerDetailOfferPage = new ManagerKanbanPage()
                .clickOfferCard(randomOfferOrRequest)
                .switchToChatIframe()
                .setCommentField(managerMessage)
                .switchToRootContainerPage()
                .clickSendCommentButton();
        sleep(3000);
        Assertions.assertAll(
                () -> Assertions.assertEquals(managerMessage, managerDetailOfferPage.getLastChatMessageText(),
                        String.format("'%s' message should be shown as last", managerMessage)),
                () -> Assertions.assertEquals(mainManagerFirstName + " " + mainManagerLastName,
                        managerDetailOfferPage.getLastChatMessageAuthor(),
                        "'DataGenerationFirstName DataGenerationLastName' should be shown as author of last message"),
                () -> Assertions.assertEquals(todayDate, managerDetailOfferPage.getLastChatMessageDate(),
                        String.format("'%s' should be shown as date of last message", todayDate))
        );

    }
}
