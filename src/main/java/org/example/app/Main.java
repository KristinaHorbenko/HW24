package org.example.app;
import static org.example.app.FileConverter.convertJsonToYaml;
import static org.example.app.FileConverter.convertYamlToJson;
import static org.example.app.FileUtils.listFilesInCurrentDirectory;

public class Main {
    public static void main(String[] args)  {
        listFilesInCurrentDirectory();
        String inputJsonFilePath = "C:\\Users\\Kristina\\Desktop\\HomeWork24\\src\\main\\resources\\file.json";
        String inputYamlFilePath = convertJsonToYaml(inputJsonFilePath);

        convertYamlToJson(inputYamlFilePath);


    }




}

