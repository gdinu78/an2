package com.social.enums;

public enum Income {
    LOW("Low"),
    AVERAGE("Average"),
    HIGH("High");

    private String type;

    Income(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
