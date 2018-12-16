package com.social.enums;

public enum PictureKind {
    AVATAR("Avatar"),
    PUBLIC("Public"),
    PRIVATE("Private");

    private String type;

    PictureKind(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
