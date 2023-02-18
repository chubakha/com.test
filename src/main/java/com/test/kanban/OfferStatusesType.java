package com.test.kanban;

public enum OfferStatusesType {
    DISCUSS_WITH_VLO("DISCUSS WITH VLO"),
    OFFER_HAS_TO_BE_ACCEPTED("Offer has to be accepted"),
    PREPARING_OFFER("Preparing Offer"),
    AWAITING_PAYMENT("Awaiting payment"),
    PREPARING_DOCUMENT("Preparing document"),
    DONE("DONE"),
    DRAFT("DRAFT"),
    OFFER("OFFER"),
    ACCEPTED("ACCEPTED"),
    PREPARED("PREPARED"),
    TASKS_ASSIGNED("TASKS ASSIGNED"),
    IN_PROGRESS("In Progress"),
    WAIT_FOR_VLO_RESPONSE("WAIT FOR VLO");

    private final String value;

    OfferStatusesType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
