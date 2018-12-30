package com.social.enums;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Permission {
    ADMIN("Admin"),
    USER("User"),
    GOLD("Gold");

    private String type;

    Permission(String type) {
        this.type = type;
    }

    @JsonValue
    public String getType() {
        return type;
    }

    public static List<String> getAllTypes(){
        return Arrays.stream(Permission.class.getEnumConstants()).map(Permission::getType).collect(Collectors.toList());
    }
}
