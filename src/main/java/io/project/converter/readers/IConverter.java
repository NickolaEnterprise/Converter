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
     * @param reader
     * @param <T>
     * @return
     */
    <T extends BaseJsonConverter> String convert(String content, T reader);

    /**
     * @param file
     * @param reader
     * @param <T>
     * @return
     */
    <T extends BaseJsonConverter> String convert(File file, T reader);

    /**
     * @param content
     * @return
     */
    String convert(String content);
}
