package com.social.enums;

public enum Lifestyle {
    LOW("Low"),
    AVERAGE("Average"),
    HIGH("High");

    private String type;

    Lifestyle(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
