package io.project.converter.readers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import io.project.converter.exception.ConverterException;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
public final class XmlReader extends BaseReader {

    /**
     * read from content and validate
     *
     * @param content
     * @return
     */
    @Override
    public final String read(final String content) {
        if (Objects.isNull(content)) {
            throw new ConverterException("Properties not valid");
        }
        return content;
    }

    /**
     * defined type
     *
     * @return
     */
    @Override
    public final Formats getType() {
        return Formats.XML;
    }

    @Override
    final String convertToBaseFormat(final String content) {
        try {
            XmlMapper mapper = new XmlMapper();
            final ObjectMapper jsonWriter = new ObjectMapper();
            final Object obj = mapper.readValue(content, Object.class);
            return jsonWriter.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new ConverterException("Can't convert XML to JSON");
        }
    }
}
