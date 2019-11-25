package io.project.converter.readers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import io.project.converter.exception.ConverterException;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
public final class YmlReader extends BaseJsonReader {
    private static final ObjectMapper yamlReader = new ObjectMapper(new YAMLFactory());

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
        return Formats.YML;
    }

    @Override
    public String convert(final String content) {
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
