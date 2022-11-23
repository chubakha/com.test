package com.test.registration;

public enum RegistrationStepsType {
    REGISTRATION_STEP1("1/4"),
    REGISTRATION_STEP2("2/4"),
    REGISTRATION_STEP3("3/4"),
    REGISTRATION_STEP4("Registration");

    private final String value;

    RegistrationStepsType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
