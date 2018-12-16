package com.social.enums;

public enum Ethnicity {
    LOW("Low"),
    AVERAGE("Average"),
    HIGH("High");

    private String type;

    Ethnicity(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
