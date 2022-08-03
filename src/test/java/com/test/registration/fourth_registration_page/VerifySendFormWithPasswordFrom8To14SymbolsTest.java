package com.test.registration.fourth_registration_page;

import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import com.test.admin_panel.LoginAdminPage;
import com.test.admin_panel.MainAdminPage;
import com.test.admin_panel.PrepareAdminPanelTestData;
import com.test.registration.PrepareRegistrationTestData;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.stream.Stream;

import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifySendFormWithPasswordFrom8To14SymbolsTest extends PrepareRegistrationTestData {
    protected ArrayList<String> emails = new ArrayList<>();
    protected ArrayList<String> companies = new ArrayList<>();

    @ParameterizedTest
    @MethodSource
    void verifySendFormWithPasswordFrom8To14Symbols(String password) {
        String currentEmail = faker.internet().emailAddress();
        String currentCompanies = faker.company().name();
        emails.add(currentEmail);
        companies.add(currentCompanies);

        ConfirmYourAccountOverlay confirmYourAccountOverlay = new FourthRegistrationPage()
                .setFirstNameField(faker.name().firstName())
                .setLastNameField(faker.name().lastName())
                .setCompanyNameField(currentCompanies)
                .setEmailField(currentEmail)
                .setPasswordField(password)
                .setRepeatPasswordField(password)
                .clickInactiveIveReadAndAcceptedTermsConditionsAndPrivacyPolicy()
                .clickActiveCreateAccountButton();
        Assertions.assertEquals("Confirm your account", confirmYourAccountOverlay.getPageTitle(),
                "'Confirm your account' page should be shown");
    }

    static Stream<String> verifySendFormWithPasswordFrom8To14Symbols() {
        faker = new Faker();
        return Stream.of(faker.internet().password(8, 9),
                faker.internet().password(9, 10),
                faker.internet().password(10, 11),
                faker.internet().password(11, 12),
                faker.internet().password(12, 13),
                faker.internet().password(13, 14),
                faker.internet().password(14, 15));
    }


    @AfterEach
    void deleteClientAndCompany() {
        PrepareAdminPanelTestData.openLoginAdminPage();
        new LoginAdminPage()
                .setUsernameField(usernameAdmin)
                .setPasswordField(passwordAdmin)
                .loginAsAdmin()
                .clickClientsLink()
                .setClientSearchByEmailField(emails.get(0))
                .focusOutSearchFields()
                .clickDeleteButton()
                .pressEnterKey();
        new MainAdminPage()
                .clickCompaniesLink()
                .setClientSearchByCompanyField(companies.get(0))
                .focusOutSearchFields()
                .clickDeleteButton()
                .pressEnterKey();
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }

}
