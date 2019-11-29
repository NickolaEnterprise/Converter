package io.project.converter.readers;

import java.io.File;
import java.nio.file.Path;

public interface IConverter {
    /**
     * @param file
     * @return
     */
    String read(Path path);

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
     * @param path
     * @param converter
     * @param <T>
     * @return
     */
    <T extends IConverter> String convert(Path path, T converter);

    /**
     * @param content
     * @return
     */
    String convert(String content);
}
