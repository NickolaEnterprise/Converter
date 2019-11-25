package io.project.converter.readers;

import java.io.File;

public interface IConverter {
    /**
     * @param file
     * @return
     */
    String read(File file);

    /**
     * @param content
     * @return
     */
    String read(String content);

    /**
     * @param content
     * @param converter
     * @param <T>
     * @return
     */
    <T extends IConverter> String convert(String content, T converter);

    /**
     * @param file
     * @param converter
     * @param <T>
     * @return
     */
    <T extends IConverter> String convert(File file, T converter);

    /**
     * @param content
     * @return
     */
    String convert(String content);
}
