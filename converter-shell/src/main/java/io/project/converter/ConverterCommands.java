package io.project.converter;

import io.project.converter.readers.IConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.io.File;
import java.util.Map;


@ShellComponent
public class ConverterCommands {
    private final Map<String, IConverter> converters;

    @Autowired
    public ConverterCommands(Map<String, IConverter> converters) {
        this.converters = converters;
    }

    @ShellMethod("Convert from one format to another.")
    public String convert(
            @ShellOption() String pathToFile,
            @ShellOption() String from,
            @ShellOption(defaultValue = "JSON") String to
    ) {
        final IConverter fromConverter = converters.get(from);
        final IConverter toConverter = converters.get(to);
        return fromConverter.convert(new File(pathToFile), toConverter);
    }
}
