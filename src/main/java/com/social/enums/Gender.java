package com.social.enums;

public enum Gender {
    MALE("Male"),
    FEMALE("Female");

    private String type;

    Gender(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
