package com.study.rafael.curso_rest_spring.enums;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import nonapi.io.github.classgraph.json.JSONDeserializer;

import java.io.IOException;

public class GenderDeserializer extends StdDeserializer<Gender> {

    public GenderDeserializer() {
        this(null);
    }

    public GenderDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Gender deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException {
        String gender = jsonParser.getText().trim().toUpperCase(); // Convert to upper case for case insensitivity
        try {
            return Gender.valueOf(gender);
        } catch (IllegalArgumentException ex) {
            // Handle exception if needed, e.g., return a default value or throw a specific exception
            throw new IllegalArgumentException("Invalid gender value: " + gender);
        }
    }

}
