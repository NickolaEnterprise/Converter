package io.project.converter.readers;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.project.converter.exception.ConverterException;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public abstract class BaseJsonConverter implements IConverter {
    static final ObjectMapper jsonWriter = new ObjectMapper();

    @Override
    public final String read(final File file) {
        try (final InputStream inputStream = new FileInputStream(file);
             final BufferedReader bf = new BufferedReader(new InputStreamReader(inputStream))) {
            return read(bf.readLine());
        } catch (final IOException e) {
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
    public final <T extends IConverter> String convert(final File file, final T converter) {
        final String baseContent = read(file);
        return convert(baseContent, converter);
    }

    abstract String convertToJson(String content);

}
