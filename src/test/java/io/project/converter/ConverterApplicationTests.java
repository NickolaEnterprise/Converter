package io.project.converter;

import io.project.converter.readers.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConverterApplicationTests {

    @Test
    void contextLoads() {
        final JsonConverter jr = new JsonConverter();
        System.out.println(jr.convert("{\"Her\": \"test\"}", new PropertiesConverter()));
        final BaseJsonConverter xmlReader = new BaseJsonConverter();
        System.out.println(xmlReader.convert("<note>\n" +
                "<to>Tove</to>\n" +
                "<from>Jani</from>\n" +
                "<heading>Reminder</heading>\n" +
                "<body>Don't forget me this weekend!</body>\n" +
                "</note>", new YmlConverter()));
        final YmlConverter ymlReader = new YmlConverter();
        String yml = ymlReader.convert("--- \n" +
                " doe: \"a deer, a female deer\"\n" +
                " ray: \"a drop of golden sun\"\n" +
                " pi: 3.14159\n" +
                " xmas: true\n" +
                " french-hens: 3\n" +
                " calling-birds: \n" +
                "   - huey\n" +
                "   - dewey\n" +
                "   - louie\n" +
                "   - fred\n" +
                " xmas-fifth-day: \n" +
                "   calling-birds: four\n" +
                "   french-hens: 3\n" +
                "   golden-rings: 5\n" +
                "   partridges: \n" +
                "     count: 1\n" +
                "     location: \"a pear tree\"\n" +
                "   turtle-doves: two", new JsonConverter());
        System.out.println(yml);

        final PropertiesConverter propertiesReader = new PropertiesConverter();
        final String her = propertiesReader.convert("title=Home Page\n" +
                "site.host=localhost\n" +
                "site.port=8080", new BaseJsonConverter());
        System.out.println(her);

        final CsvConverter csvReader = new CsvConverter();
        final String csv = csvReader.convert("tJohn,Doe,120 jefferson st.,Riverside, NJ, 08075\n" +
                "Jack,McGinnis,220 hobo Av.,Phila, PA,09119\n" +
                "\"John \"\"Da Man\"\"\",Repici,120 Jefferson St.,Riverside, NJ,08075\n" +
                "Stephen,Tyler,\"7452 Terrace \"\"At the Plaza\"\" road\",SomeTown,SD, 91234\n" +
                ",Blankman,,SomeTown, SD, 00298\n" +
                "\"Joan \"\"the bone\"\", Anne\",Jet,\"9th, at Terrace plc\",Desert City,CO,00123", new YmlConverter());
        System.out.println(csv);


    }
}
