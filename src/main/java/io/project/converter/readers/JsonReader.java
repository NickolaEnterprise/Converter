package io.project.converter.readers;

import io.project.converter.exception.ConverterException;
import net.minidev.json.JSONValue;
import org.springframework.stereotype.Service;

@Service
public final class JsonReader extends BaseJsonReader {
    /**
     * read from content and validate
     *
     * @param content
     * @return
     */
    @Override
    public String read(String content) {
        if (!JSONValue.isValidJson(content)) {
            throw new ConverterException("Json not valid");
        }
        return content;
    }

    /**
     * defined type
     *
     * @return
     */
    @Override
    public Formats getType() {
        return Formats.JSON;
    }

    @Override
    public String convert(final String content) {
        return content;
    }

    @Override
    String convertToJson(String content) {
        return content;
    }
}
