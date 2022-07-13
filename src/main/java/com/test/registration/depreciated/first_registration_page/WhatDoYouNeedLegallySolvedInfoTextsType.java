package com.test.registration.depreciated.first_registration_page;

public enum WhatDoYouNeedLegallySolvedInfoTextsType {
    INCORPORATION("The first steps required to legalise a business project are (1) choosing the most suitable jurisdiction, (2) registering the company, and (3) arranging the issuance of shares for the founders. Together, these actions are commonly referred to as вЂњbusiness incorporationвЂќ."),
    ACCOUNTING_TAXES("After registering a company and opening an account, you need to take care of some accounting including (1) for clients' funds that are expected to enter the company's account, (2) for arranging salary payments to staff, and (3) for setting up tax payments."),
    HIRING("In order to do business, you will need a team, and you will need to handle the legalities that come with having a team. It is important to prepare the documents that must be signed with each member of the team. These documents will (1) set out the terms of cooperation (employment) with them, and (2) protect the company's trade secrets."),
    IP_PROTECTION("Before the public launch of a project, it’s important to ensure that the brand and technology of the project are protected from IP squatters and unfair competitors. Protection is achieved with state registrations of trademarks and patents."),
    CLIENT_ACQUISITION("When a business project starts to attract clients, it’s important to have detailed client contracts that will help the business secure contracts with the conditions most favourable to the business, and with terms and conditions that reduce the risk of client debt and litigation."),
    PRIVACY_GDPR_COMPLIANCE("In the European market, the lack of necessary policies and procedures for the protection of personal data can become a dealbreaker in the process of attracting customers. To avoid this, businesses have to take care of Privacy and GDPR compliance issues and ensure that they are compliant with the relevant privacy laws."),
    FUNDRAISING("Once the business has been incorporated, the team has been hired, and the client base and profits are growing rapidly, it's time to raise funds. In order to attract investments–and at the same time not to lose control over the company and not dilute shares in the business–you will need detailed investment documents."),
    TOKEN_GENERATION_DISTRIBUTION_WEB3("If a business project pursues the route of token issuance and their further distribution through a public sale, these activities are usually separated into a separate legal structure, and the legal status of the token is also checked to avoid any violations of financial and investment laws."),
    LAUNCHING_A_DAO_WEB3("After the release and distribution of tokens, the next stage in the development of the Web3 company is to unite token holders into a decentralised autonomous organisation (DAO). It is needed to protect members of the DAO from unlimited liability, and to enable the DAO to interact with the outside world.");

    private String value;

    WhatDoYouNeedLegallySolvedInfoTextsType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static String[] getAllValues(){
        String[] hint = new String[WhatDoYouNeedLegallySolvedInfoTextsType.values().length];
        WhatDoYouNeedLegallySolvedInfoTextsType[] values = WhatDoYouNeedLegallySolvedInfoTextsType.values();
        for (WhatDoYouNeedLegallySolvedInfoTextsType value : values) {
            hint[value.ordinal()] = value.getValue();
        }
        return hint;
    }


}
