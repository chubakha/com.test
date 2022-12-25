package com.test.setting;

public enum InvoicesDescriptionType {
    TRIAL("Get 2 Legal Strategy Sessions, hosted by an expert from Legal Nodes. During these sessions, our experts will lay out all the different legal options for your project and will build a legal roadmap containing the steps you need to take to achieve your legal goals. The payment is for the trial only, with no obligation to continue after the trial period. You will be provided with an actionable legal roadmap as a result of the legal strategy sessions and may begin a monthly plan at any time during the trial."),
    RETAINER("Get a Virtual Legal Officer and unlock a world of add-ons from the Legal Nodes Network. Your VLO will act as your main point of contact for all cross-border tasks. They implement your legal roadmap by choosing add-ons from our vetted service providers in the Legal Nodes Network. Your VLO will choose the best add-ons for you, manage all relationships with service providers on your behalf, quality-check each deliverable and provide regular updates to keep you informed."),
    REMINDER("This payment is for additional VLO works that are not included in the VLO Individual Monthly Plan. We’ve charged these additional works on a pay-as-you-go basis at an hourly rate of 100 USD/hour.");

    private String value;

    InvoicesDescriptionType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
