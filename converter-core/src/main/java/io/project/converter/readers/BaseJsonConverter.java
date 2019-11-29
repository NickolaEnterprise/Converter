package io.project.converter.readers;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.project.converter.exception.ConverterException;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class BaseJsonConverter implements IConverter {
    static final ObjectMapper jsonWriter = new ObjectMapper();

    @Override
    public final String read(final Path path) {
        try {
            final byte[] content = Files.readAllBytes(path);
            return new String(content, Charset.defaultCharset());
        } catch (IOException e) {
            throw new ConverterException(e);
        }
    }

    @Override
    public final <T extends IConverter> String convert(final String content, final T converter) {
        final String baseContent = read(content);
        final String json = convertToJson(baseContent);
        return converter.convert(json);
    }

    @Override
    public final <T extends IConverter> String convert(final Path path, final T converter) {
        final String baseContent = read(path);
        return convert(baseContent, converter);
    }

    abstract String convertToJson(String content);

}
