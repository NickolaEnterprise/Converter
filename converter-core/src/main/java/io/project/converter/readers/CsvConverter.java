package io.project.converter.readers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import io.project.converter.exception.ConverterException;

import java.util.Objects;

public final class CsvConverter extends BaseJsonConverter {
    private static final CsvMapper csvMapper = new CsvMapper();

    @Override
    public final String read(final String content) {
        if (Objects.isNull(content)) {
            throw new ConverterException("CSV not valid");
        }
        return content;
    }

    @Override
    public final String convert(final String content) {
        try {
            final Object obj = jsonWriter.readValue(content, Object.class);
            return csvMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new ConverterException("Can't convert CSV to JSON");
        }
    }

    @Override
    final String convertToJson(final String content) {
        try {
            final Object obj = csvMapper.readValue(content, Object.class);
            return jsonWriter.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new ConverterException("Can't convert CSV to JSON");
        }
    }
}
