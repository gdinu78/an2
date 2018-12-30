package com.social.enums;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum BodyType {
    SLIM("Slim"),
    FAT("Fat"),
    AVERAGE("Average");

    private String type;

    BodyType(String type) {
        this.type = type;
    }

    @JsonValue
    public String getType() {
        return type;
    }

    public static List<String> getAllTypes(){
        return Arrays.stream(BodyType.class.getEnumConstants()).map(BodyType::getType).collect(Collectors.toList());
    }
}
