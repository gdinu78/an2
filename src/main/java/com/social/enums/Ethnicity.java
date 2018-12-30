package com.social.enums;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Ethnicity {
    LOW("Low"),
    AVERAGE("Average"),
    HIGH("High");

    private String type;

    Ethnicity(String type) {
        this.type = type;
    }

    @JsonValue
    public String getType() {
        return type;
    }

    public static List<String> getAllTypes(){
        return Arrays.stream(Ethnicity.class.getEnumConstants()).map(Ethnicity::getType).collect(Collectors.toList());
    }
}
