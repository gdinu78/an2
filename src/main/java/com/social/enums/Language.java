package com.social.enums;

public enum Language {
    LOW("Low"),
    AVERAGE("Average"),
    HIGH("High");

    private String type;

    Language(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
