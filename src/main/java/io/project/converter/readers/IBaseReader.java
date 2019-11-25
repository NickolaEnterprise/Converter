package io.project.converter.readers;

import java.io.File;

public interface IBaseReader {

    String read(File file);

    String read(String content);

    <T extends BaseJsonReader> String toJson(String content, T reader);

    <T extends BaseJsonReader> String toJson(File file, T reader);

    Formats getType();

    String convert(String content);
}
