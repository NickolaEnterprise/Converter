package io.project.converter.readers;

import java.io.File;

public interface IBaseReader {

    String read(File file);

    String read(String content);

    String readAsBase(String content);

    String readAsBase(File file);

    Formats getType();
}
