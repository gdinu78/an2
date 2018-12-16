package com.social.enums;

public enum Dinking {
    LOW("Low"),
    AVERAGE("Average"),
    HIGH("High");

    private String type;

    Dinking(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
