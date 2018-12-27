package com.social.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PictureKind {
    AVATAR("Avatar"),
    PUBLIC("Public"),
    PRIVATE("Private");

    private String type;

    PictureKind(String type) {
        this.type = type;
    }

    @JsonValue
    public String getType() {
        return type;
    }

}
