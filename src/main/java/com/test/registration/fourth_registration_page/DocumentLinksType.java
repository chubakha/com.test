package com.test.registration.fourth_registration_page;

public enum DocumentLinksType {
    TERMS_CONDITIONS("https://drive.google.com/file/d/1yOBnDvIqXjxaDy4NPc7idvXUMEg0WN-2/view"),
    PRIVACY_POLICY("https://drive.google.com/file/d/1SjuP_NyIPlz2aHcfhCAGYOOOgUylZNWe/view");

    private String value;

    DocumentLinksType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
