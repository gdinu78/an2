package com.social.enums;

public enum Occupation {
    LOW("Low"),
    AVERAGE("Average"),
    HIGH("High");

    private String type;

    Occupation(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
