package com.social.enums;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Worth {
    LOW("Low"),
    AVERAGE("Average"),
    HIGH("High");

    private String type;

    Worth(String type) {
        this.type = type;
    }

    @JsonValue
    public String getType() {
        return type;
    }

    public static List<String> getAllTypes(){
        return Arrays.stream(Worth.class.getEnumConstants()).map(Worth::getType).collect(Collectors.toList());
    }
}
