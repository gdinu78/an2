package com.social.enums;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public static List<String> getAllTypes(){
        return Arrays.stream(PictureKind.class.getEnumConstants()).map(PictureKind::getType).collect(Collectors.toList());
    }
}
