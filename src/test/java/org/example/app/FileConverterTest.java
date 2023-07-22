package org.example.app;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNotNull;


class FileConverterTest {

    @Test
    void convertJsonToYaml()  {
        String inputJsonFilePath =  "C:\\Users\\Kristina\\Desktop\\HomeWork24\\src\\main\\resources\\file.json";

        String outputYamlFilePath = FileConverter.convertJsonToYaml(inputJsonFilePath);
        assertNotNull(outputYamlFilePath);
    }

    @Test
    void convertYamlToJson()  {
        String inputJsonFilePath = "C:\\Users\\Kristina\\Desktop\\HomeWork24\\src\\main\\resources\\file.json";
        String inputYamlFilePath = FileConverter.convertJsonToYaml(inputJsonFilePath);
        assertNotNull(inputYamlFilePath);

        String outputJsonFilePath = FileConverter.convertYamlToJson(inputYamlFilePath);
        assertNotNull(outputJsonFilePath);
    }



}