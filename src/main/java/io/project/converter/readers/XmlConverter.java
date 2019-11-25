package io.project.converter.readers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import io.project.converter.exception.ConverterException;
import org.springframework.stereotype.Service;

import java.util.Objects;

public final class XmlConverter extends BaseJsonConverter {
    private static final XmlMapper mapper = new XmlMapper();

    @Override
    public final String read(final String content) {
        if (Objects.isNull(content)) {
            throw new ConverterException("XML not valid");
        }
        return content;
    }

    @Override
    public final String convert(final String content) {
        try {
            final Object obj = jsonWriter.readValue(content, Object.class);
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new ConverterException("Can't convert XML to JSON");
        }

    }

    @Override
    final String convertToJson(final String content) {
        try {
            final Object obj = mapper.readValue(content, Object.class);
            return jsonWriter.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new ConverterException("Can't convert XML to JSON");
        }
    }
}
