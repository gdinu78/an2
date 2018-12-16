package com.social.enums;

public enum FavEnum {
    LOW("Low"),
    AVERAGE("Average"),
    HIGH("High");

    private String type;

    FavEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
