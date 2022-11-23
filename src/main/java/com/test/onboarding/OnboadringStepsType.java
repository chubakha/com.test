package com.test.onboarding;

public enum OnboadringStepsType {
    FIRST_STEP("Please sign the KYC Statement and the Engagement Letter to proceed."),
    SECOND_STEP("Pay a retainer fee for VLO Services (Monthly Payment)"),
    THIRD_STEP("Now it’s time to book a call with our team to meet your VLO."),
    FOURTH_STEP("The call with VLO has been booked. Please, join the call at the selected time.");

    private final String value;

    OnboadringStepsType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }


}
