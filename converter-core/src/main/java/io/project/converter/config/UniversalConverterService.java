package io.project.converter.config;

import io.project.converter.readers.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class UniversalConverterService {

    @Bean
    public Map<String, IConverter> converters() {
        return new HashMap<String, IConverter>() {{
            put(Formats.JSON.name(), new JsonConverter());
            put(Formats.XML.name(), new XmlConverter());
            put(Formats.YML.name(), new YmlConverter());
            put(Formats.PROPERTIES.name(), new PropertiesConverter());
            put(Formats.CSV.name(), new CsvConverter());
        }};
    }

}
