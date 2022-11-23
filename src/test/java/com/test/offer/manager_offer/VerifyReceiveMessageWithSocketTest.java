package com.test.offer.manager_offer;

import com.test.GenericPage;
import com.test.PrepareOverallTestData;
import com.test.kanban.manager_kanban.ManagerDetailOfferPage;
import com.test.login.LoginCabinetPage;
import com.test.offer.PrepareOfferTestData;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class VerifyReceiveMessageWithSocketTest extends PrepareOfferTestData {

    public static WebDriver managerCabinetBrowserWindow;
    public static WebDriver clientCabinetBrowserWindow;

    @Test
    void verifyReceiveMessageWithSocket(){

        managerCabinetBrowserWindow = new ChromeDriver();
        clientCabinetBrowserWindow = new ChromeDriver();

        String managerMessage = faker.lorem().sentence();
        String randomOfferOrRequest = String.valueOf((int) (Math.ceil(Math.random()*6)));
        String todayDate = (new PrepareOverallTestData().getTodayDateEuSlash());

        setWebDriver(managerCabinetBrowserWindow);
        GenericPage.openLoginPage();
        ManagerDetailOfferPage managerDetailOfferPage = new LoginCabinetPage()
                .setEmailField(managerEmail)
                .setPasswordField(managerPassword)
                .loginAsManager()
                .clickCompanyListDropdown()
                .clickCompanyInDropdown(dataGenerationClientCompany)
                .clickOfferCard(randomOfferOrRequest);

        setWebDriver(clientCabinetBrowserWindow);
        GenericPage.openLoginPage();
        new LoginCabinetPage()
                .setEmailField(dataGenerationClientEmail)
                .setPasswordField(dataGenerationClientPassword)
                .loginAsClient()
                .clickOfferCard(randomOfferOrRequest)
                .switchToChatIframe()
                .setCommentField(managerMessage)
                .switchToRootContainerPage()
                .clickSendCommentButton();
        sleep(2000);
        setWebDriver(managerCabinetBrowserWindow);
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

    @AfterAll
    static void closeBrowsers(){
        clientCabinetBrowserWindow.close();
        managerCabinetBrowserWindow.close();
    }
}
