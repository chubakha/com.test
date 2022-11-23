package com.test.onboarding;

import com.test.GenericPage;
import com.test.admin_panel.clients_section.ViewClientPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VerifyRegistrationParameterTest extends PrepareOnboardingTestData {

    public static String password = faker.internet().password(8, 15, true);
    public static String firstName = faker.name().firstName();
    public static String lastName = faker.name().lastName();
    public static String company = faker.company().name();
    public static String email = firstName + "testyop@yopmail.com";

    @BeforeEach
    void registrationNewClientAndCompany(){
        registrationNewClientAndCompany(firstName, lastName, company, email, password);
    }

    @Test
    void verifyRegistrationParameter(){
        ViewClientPage viewClientPage = GenericPage
                .openAdminPageWithoutAuthorization()
                .clickClientsLink()
                .setClientSearchByEmailField(email)
                .focusOutSearchFields()
                .clickViewButton();
        Assertions.assertEquals(managerParameter, viewClientPage.getOnboardingUrl(),
                String.format("'%s' parameter should be shown next to 'Onboard url'", managerParameter));
    }

    @AfterAll
    static void deleteNewClientAndCompany(){
        deleteNewClient(email, company);
    }
}
