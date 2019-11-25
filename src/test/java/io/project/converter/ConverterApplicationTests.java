package io.project.converter;

import io.project.converter.readers.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConverterApplicationTests {

    @Test
    void contextLoads() {
        final JsonReader jr = new JsonReader();
        System.out.println(jr.toJson("{\"Her\": \"test\"}", new PropertiesReader()));
        final XmlReader xmlReader = new XmlReader();
        System.out.println(xmlReader.toJson("<note>\n" +
                "<to>Tove</to>\n" +
                "<from>Jani</from>\n" +
                "<heading>Reminder</heading>\n" +
                "<body>Don't forget me this weekend!</body>\n" +
                "</note>", new YmlReader()));
        final YmlReader ymlReader = new YmlReader();
        String yml = ymlReader.toJson("--- \n" +
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
                "   turtle-doves: two", new JsonReader());
        System.out.println(yml);

        final PropertiesReader propertiesReader = new PropertiesReader();
        final String her = propertiesReader.toJson("title=Home Page\n" +
                "site.host=localhost\n" +
                "site.port=8080", new XmlReader());
        System.out.println(her);

        final CsvReader csvReader = new CsvReader();
        final String csv = csvReader.toJson("tJohn,Doe,120 jefferson st.,Riverside, NJ, 08075\n" +
                "Jack,McGinnis,220 hobo Av.,Phila, PA,09119\n" +
                "\"John \"\"Da Man\"\"\",Repici,120 Jefferson St.,Riverside, NJ,08075\n" +
                "Stephen,Tyler,\"7452 Terrace \"\"At the Plaza\"\" road\",SomeTown,SD, 91234\n" +
                ",Blankman,,SomeTown, SD, 00298\n" +
                "\"Joan \"\"the bone\"\", Anne\",Jet,\"9th, at Terrace plc\",Desert City,CO,00123", new YmlReader());
        System.out.println(csv);


    }
}
