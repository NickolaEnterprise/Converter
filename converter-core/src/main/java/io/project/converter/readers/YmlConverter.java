package io.project.converter.readers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import io.project.converter.exception.ConverterException;

import java.util.Objects;

public final class YmlConverter extends BaseJsonConverter {
    private static final ObjectMapper yamlReader = new ObjectMapper(new YAMLFactory());

    @Override
    public final String read(final String content) {
        if (Objects.isNull(content)) {
            throw new ConverterException("YML not valid");
        }
        return content;
    }

    @Override
    public final String convert(final String content) {
        try {
            final Object obj = jsonWriter.readValue(content, Object.class);
            return yamlReader.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new ConverterException("Can't convert YML to JSON");
        }
    }

    @Override
    final String convertToJson(final String content) {
        try {
            final Object obj = yamlReader.readValue(content, Object.class);
            return jsonWriter.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new ConverterException("Can't convert YML to JSON");
        }
    }
}
