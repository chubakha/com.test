package com.test.registration;

public enum WhatDoYouNeedLegallySolvedSections {
    INCORPORATION("The first steps required to legalise a business project are (1) choosing the most suitable jurisdiction, (2) registering the company, and (3) arranging the issuance of shares for the founders. Together, these actions are commonly referred to as “business incorporation”."),
    ACCOUNTINGTAXES("After registering a company and opening an account, you need to take care of some accounting including (1) for clients' funds that are expected to enter the company's account, (2) for arranging salary payments to staff, and (3) for setting up tax payments."),
    HIRING("In order to do business, you will need a team, and you will need to handle the legalities that come with having a team. It is important to prepare the documents that must be signed with each member of the team. These documents will (1) set out the terms of cooperation (employment) with them, and (2) protect the company's trade secrets.");

    private String value;

    WhatDoYouNeedLegallySolvedSections(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
