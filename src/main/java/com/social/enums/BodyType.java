package com.social.enums;

public enum BodyType {
    SLIM("Slim"),
    FAT("Fat"),
    AVERAGE("Average");

    private String type;

    BodyType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
