package io.project.converter.readers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import io.project.converter.exception.ConverterException;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
public final class CsvReader extends BaseJsonReader {
    private static final CsvMapper csvMapper = new CsvMapper();


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
    public String convert(final String content) {
        try {
            final Object obj = jsonWriter.readValue(content, Object.class);
            return csvMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new ConverterException("Can't convert YML to JSON");
        }
    }

    @Override
    final String convertToJson(final String content) {
        try {
            final Object obj = csvMapper.readValue(content, Object.class);
            return jsonWriter.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new ConverterException("Can't convert YML to JSON");
        }
    }
}
