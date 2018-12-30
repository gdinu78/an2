package com.social.enums;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Smoking {
    LOW("Low"),
    AVERAGE("Average"),
    HIGH("High");

    private String type;

    Smoking(String type) {
        this.type = type;
    }

    @JsonValue
    public String getType() {
        return type;
    }

    public static List<String> getAllTypes(){
        return Arrays.stream(Smoking.class.getEnumConstants()).map(Smoking::getType).collect(Collectors.toList());
    }
}
