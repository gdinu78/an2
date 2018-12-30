package com.social.enums;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum RolEnum {
    ADMIN("Admin"),
    USER("User"),
    SILVER("Silver"),
    GOLD("Gold");

    private String type;

    RolEnum(String type) {
        this.type = type;
    }

    @JsonValue
    public String getType() {
        return type;
    }

    public static List<String> getAllTypes(){
        return Arrays.stream(RolEnum.class.getEnumConstants()).map(RolEnum::getType).collect(Collectors.toList());
    }
}
