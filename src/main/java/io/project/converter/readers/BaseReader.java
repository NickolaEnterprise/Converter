package io.project.converter.readers;

import io.project.converter.exception.ConverterException;

import java.io.*;

public abstract class BaseReader implements IBaseReader {

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
    public final String readAsBase(final String content) {
        final String baseContent = read(content);
        return convertToBaseFormat(baseContent);
    }

    @Override
    public final String readAsBase(final File file) {
        final String baseContent = read(file);
        return convertToBaseFormat(baseContent);
    }

    abstract String convertToBaseFormat(String content);
}
