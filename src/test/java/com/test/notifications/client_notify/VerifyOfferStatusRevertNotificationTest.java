package com.test.notifications.client_notify;

import com.test.kanban.OfferStatusesType;
import com.test.kanban.notifications.MainNotificationsOverlay;
import com.test.login.LoginCabinetPage;
import com.test.notifications.PrepareClientNotificationsData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyOfferStatusRevertNotificationTest extends PrepareClientNotificationsData {

    @Test
    void verifyOfferStatusRevertNotification(){

        MainNotificationsOverlay mainNotificationsOverlay = new LoginCabinetPage()
                .setEmailField(dataGenerationManagerEmail)
                .setPasswordField(dataGenerationManagerPassword)
                .loginAsManager()
                .clickCompanyListDropdown()
                .clickCompanyInDropdown(dataGenerationClientNotificationsCompany)
                .clickFirstAwaitingVloNextStepCard()
                .clickStatusesDropDown()
                .clickReturnToOfferHasToBeAcceptedButton()
                .clickLogOutLink()
                .setEmailField(dataGenerationClientNotificationsEmail)
                .setPasswordField(dataGenerationClientNotificationsPassword)
                .loginAsClient()
                .clickNotificationsIcon();
        Assertions.assertEquals(String.format("The Offer's Status has been changed from \"%s\" to \"%s\"",
                OfferStatusesType.ACCEPTED.getValue(), OfferStatusesType.PREPARED.getValue()),
                mainNotificationsOverlay.getLastMessage(),
                String.format("'The Offer's Status has been changed from \"%s\" to \"%s\"' should be shown as last notifications",
                        OfferStatusesType.WAIT_FOR_VLO_RESPONSE.getValue(), OfferStatusesType.OFFER_HAS_TO_BE_ACCEPTED));
    }

}
