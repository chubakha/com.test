package com.test.registration;

import com.codeborne.selenide.ElementsCollection;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

public class Functions {
    public String[] getChosenOptions(ElementsCollection selectedOptions) {
        String[] chosenList = new String[selectedOptions.size()];
        for (int i = 0; i < selectedOptions.size(); i++) {
            chosenList[i] = selectedOptions.get(i).getText();
        }
        return chosenList;
    }

    public boolean compareSectionAndOption(String chosenOption, String chosenSection) {
        ListMultimap<String, String> sectionsAndOptionsArray = ArrayListMultimap.create();
        Map<String, Collection<String>> map = Map.of(
                "INCORPORATION", Arrays.asList("Pick the best jurisdictions and corporate structure for my tech project",
                        "Register a company for initial fundraising & go-to-market",
                        "Set up or update terms of cooperation between founders"),
                "ACCOUNTING & TAXES", Arrays.asList("Get taxation analysis on the country chosen for company registration",
                        "Obtain a company tax number",
                        "Start issuing and collecting invoices in a tax-compliant way",
                        "Set up accounting for paying salaries",
                        "Obtain company VAT number"),
                "HIRING", Arrays.asList("Hire a new team member",
                        "Protect intellectual property and trade secrets",
                        "Incentivize the team by issuing share options",
                        "Engage a new contractor"),
                "IP PROTECTION", Arrays.asList("Protect the name and logo of the company",
                        "Protect the company`s invention"),
                "CLIENT ACQUISITION", Arrays.asList("Start user acquisition on the website / app",
                        "Start receiving payments from B2B clients",
                        "Start working with a new referral partner"),
                "PRIVACY / GDPR COMPLIANCE", Arrays.asList("Make the website / app compliant with privacy laws",
                        "Start working with EU-based clients and users",
                        "Sign B2B agreements with EU-based clients"),
                "FUNDRAISING", Arrays.asList("Prepare for the fundraising",
                        "Raise investments",
                        "Raise investments with the promise to issue tokens",
                        "Make a cash-out / exit"),
                "TOKEN GENERATION & DISTRIBUTION (WEB3)", Arrays.asList("Register a company to issue the tokens",
                        "Ensuring regulatory and AML compliance when selling tokens",
                        "Public Token distribution through launchpads, listing tokens on crypto exchanges",
                        "Launching DeFi and token incentive programs for users (staking, yield farming, airdrops, NFTs, etc.)"),
                "LAUNCHING A DAO (WEB3)", Arrays.asList("DAO Legal Wrapper setup",
                        "DAO Governance legal setup",
                        "Appointment of DAO Management",
                        "Onboarding DAO members"));
        int i = 0;
        int j = 0;
        boolean sectionIsRight = false;
        for (Map.Entry<String, Collection<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            Collection<String> value = entry.getValue();
            sectionsAndOptionsArray.putAll(key, value);
            for (String valueCurrent : value) {
                if (valueCurrent.equals(chosenOption)) {
                    i++;
                    if (key.equals(chosenSection)) {
                        j++;
                    }
                }
            }
        }
        if ((i == 1) && (j == 1)) {
            sectionIsRight = true;
        }
        return sectionIsRight;
    }

}
