package io.project.converter.readers;

import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper;
import io.project.converter.exception.ConverterException;
import org.springframework.stereotype.Service;

import java.util.Objects;

public final class PropertiesConverter extends BaseJsonConverter {
    private static final JavaPropsMapper mapper = new JavaPropsMapper();

    @Override
    public final String read(final String content) {
        if (Objects.isNull(content)) {
            throw new ConverterException("PROPERTIES not valid");
        }
        return content;
    }

    @Override
    public final String convert(final String content) {
        try {
            final Object data = jsonWriter.readValue(content, Object.class);
            return mapper.writeValueAsString(data);
        } catch (final Exception e) {
            throw new ConverterException("Can't convert PROPERTIES to JSON");
        }
    }

    @Override
    final String convertToJson(final String content) {
        try {
            final Object data = mapper.readValue(content, Object.class);
            return jsonWriter.writeValueAsString(data);
        } catch (final Exception e) {
            throw new ConverterException("Can't convert PROPERTIES to JSON");
        }
    }
}
