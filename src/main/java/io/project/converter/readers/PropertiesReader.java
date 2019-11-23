package io.project.converter.readers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import io.project.converter.exception.ConverterException;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
public final class PropertiesReader extends BaseReader {

    /**
     * read from content and validate
     *
     * @param content
     * @return
     */
    @Override
    public final String read(final String content) {
        if (Objects.isNull(content)) {
            throw new ConverterException("YML not valid");
        }
        return content;
    }

    /**
     * defined type
     *
     * @return
     */
    @Override
    public final Formats getType() {
        return Formats.PROPERTIES;
    }

    @Override
    final String convertToBaseFormat(final String content) {
        try {
            final JavaPropsMapper mapper = new JavaPropsMapper();
            final ObjectMapper jsonMapper = new ObjectMapper();
            final Object data = mapper.readValue(content, Object.class);
            return jsonMapper.writeValueAsString(data);
        } catch (final Exception e) {
            throw new ConverterException("Can't convert PROPERTIES to JSON");
        }
    }
}
