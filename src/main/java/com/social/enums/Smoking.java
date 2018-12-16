package com.social.enums;

public enum Smoking {
    LOW("Low"),
    AVERAGE("Average"),
    HIGH("High");

    private String type;

    Smoking(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
