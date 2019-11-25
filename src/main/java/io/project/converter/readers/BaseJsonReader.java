package io.project.converter.readers;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.project.converter.exception.ConverterException;

import java.io.*;

public abstract class BaseJsonReader implements IBaseReader {
    static final ObjectMapper jsonWriter = new ObjectMapper();

    /**
     * read from file and validate
     *
     * @param file
     * @return
     */
    @Override
    public final String read(File file) {
        try (final InputStream inputStream = new FileInputStream(file);
             final BufferedReader bf = new BufferedReader(new InputStreamReader(inputStream))) {
            return read(bf.readLine());
        } catch (final IOException e) {
            throw new ConverterException(e);
        }
    }

    @Override
    public final <T extends BaseJsonReader> String toJson(final String content, final T reader) {
        final String baseContent = read(content);
        final String json = convertToJson(baseContent);
        return reader.convert(json);
    }

    @Override
    public final <T extends BaseJsonReader> String toJson(final File file, final T reader) {
        final String baseContent = read(file);
        return toJson(baseContent, reader);
    }

    abstract String convertToJson(String content);

}
