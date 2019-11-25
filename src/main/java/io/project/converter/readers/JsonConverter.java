package io.project.converter.readers;

import io.project.converter.exception.ConverterException;
import net.minidev.json.JSONValue;
import org.springframework.stereotype.Service;

public final class JsonConverter extends BaseJsonConverter {

    @Override
    public final String read(String content) {
        if (!JSONValue.isValidJson(content)) {
            throw new ConverterException("Json not valid");
        }
        return content;
    }

    @Override
    public final String convert(final String content) {
        return content;
    }

    @Override
    String convertToJson(final String content) {
        return content;
    }
}
