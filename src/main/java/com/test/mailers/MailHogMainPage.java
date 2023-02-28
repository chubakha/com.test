package com.test.mailers;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MailHogMainPage {

    private final SelenideElement deleteAllMessageLink = $x("//a[@ng-click = 'deleteAll()']");

    public MailHogRecoveryPasswordMailPage clickRecoveryPasswordEmail(String email){
        $x("//div[contains(text(), '" + email + "')]").click();
        return new MailHogRecoveryPasswordMailPage();
    }

    public MailHogInvoiceMailPage clickInvoiceEmail(String email){
        $x("//div[contains(text(), '" + email + "')]").click();
        return new MailHogInvoiceMailPage();
    }

    public MailHogNewRequestHasCreatedMailNotificationPage clickNewRequestHasCreatedEmail(String email){
        $x("//div[contains(text(), '" + email + "')]").click();
        return new MailHogNewRequestHasCreatedMailNotificationPage();
    }


    public MailHogNewCommentHasAddedInRequestChatNotificationPage clickNewCommentHasAddedInRequestChatEmail(String email){
        $x("//div[contains(text(), '" + email + "')]").click();
        return new MailHogNewCommentHasAddedInRequestChatNotificationPage();
    }

    public MailHogNewCommentHasAddedInOfferChatNotificationPage clickNewCommentHasAddedInOfferChatEmail(String email){
        $x("//div[contains(text(), '" + email + "')]").click();
        return new MailHogNewCommentHasAddedInOfferChatNotificationPage();
    }

    public MailHogStatusHasChangedToAcceptedNotificationPage clickStatusIsChangedToAcceptedEmail(String email){
        $x("//div[contains(text(), '" + email + "')]").click();
        return new MailHogStatusHasChangedToAcceptedNotificationPage();
    }

    public MailHogDeleteAllMessageOverlayPage clickDeleteAllMessageLink(){
        deleteAllMessageLink.click();
        return new MailHogDeleteAllMessageOverlayPage();
    }
}
