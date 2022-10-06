package com.test.cabinet;

public enum OfferStatusesType {
    DISCUSS_WITH_VLO("DISCUSS WITH VLO"),
    OFFER_HAS_TO_BE_ACCEPTED("Offer has to be accepted"),
    PREPARING_OFFER("Preparing Offer"),
    AWAITING_PAYMENT("Awaiting payment"),
    PREPARING_DOCUMENT("Preparing document"),
    DONE("Done"),
    WAIT_FOR_VLO_RESPONSE("WAIT FOR VLO’S RESPONSE");

    private final String value;

    OfferStatusesType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
