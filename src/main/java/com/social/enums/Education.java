package com.social.enums;

public enum Education {
    LOW("Low"),
    AVERAGE("Average"),
    HIGH("High");

    private String type;

    Education(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
