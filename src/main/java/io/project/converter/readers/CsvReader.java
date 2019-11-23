package io.project.converter.readers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import io.project.converter.exception.ConverterException;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
public final class CsvReader extends BaseReader {

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
        return Formats.CSV;
    }

    @Override
    final String convertToBaseFormat(final String content) {
        try {
            final CsvMapper csvMapper = new CsvMapper();
            final ObjectMapper objectMapper = new ObjectMapper();
            final Object obj = csvMapper.readValue(content, Object.class);
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new ConverterException("Can't convert YML to JSON");
        }
    }
}
