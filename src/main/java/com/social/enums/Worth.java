package com.social.enums;

public enum Worth {
    LOW("Low"),
    AVERAGE("Average"),
    HIGH("High");

    private String type;

    Worth(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
