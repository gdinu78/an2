package com.social.enums;

public enum HairColor {
    LOW("Low"),
    AVERAGE("Average"),
    HIGH("High");

    private String type;

    HairColor(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
