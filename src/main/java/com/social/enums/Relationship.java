package com.social.enums;

public enum Relationship {
    LOW("Low"),
    AVERAGE("Average"),
    HIGH("High");

    private String type;

    Relationship(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
