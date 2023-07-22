package org.example.app;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.yaml.snakeyaml.Yaml;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class FileConverter {
    public static String convertJsonToYaml(String inputJsonFilePath) {
        String outputFilePath = "";
        try {
             Gson gson = new Gson();
             Reader fileReader = new FileReader(inputJsonFilePath);
             Map<String, Object> jsonObject = gson.fromJson(fileReader, Map.class);

             // Конвертируем объект Java в YAML
             Yaml yaml = new Yaml();
             File inputFile = new File(inputJsonFilePath);
             String inputFileName = inputFile.getName();
             String outputFileName = inputFileName.replace(".json", ".yaml");

             File inputDirectory = new File(inputJsonFilePath).getParentFile();
             File convertedDirectory = new File(inputDirectory, "converted");
             if (!convertedDirectory.exists()) {
             convertedDirectory.mkdir();

          }

         outputFilePath = convertedDirectory.getPath() + File.separator + outputFileName;
         long startTime = System.currentTimeMillis();
         Writer fileWriter = new FileWriter(outputFilePath);
         yaml.dump(jsonObject, fileWriter);
         fileWriter.close();

         long endTime = System.currentTimeMillis();
         long duration = endTime - startTime;

         System.out.println("Конвертацію успішно завершено. Файл збережено: " + outputFilePath);

         // Записываем информацию о конвертации в файл result.log
         ResultLogger.logConversionResult(getFileName(inputJsonFilePath), getFileName(outputFilePath),
              duration, getFileSize(inputJsonFilePath), getFileSize(outputFilePath));
        } catch (IOException e) {
            System.err.println("Помилка при конвертації JSON в YAML: " + e.getMessage());
            e.printStackTrace();
         // Записываем информацию об ошибке в файл result.log
         ResultLogger.logConversionResult(getFileName(inputJsonFilePath), "Не конвертувався (помилка)");
        }
        return outputFilePath;
    }

    public static String convertYamlToJson(String inputYamlFilePath)  {
        String outputFilePath = "";
        try {
            Yaml yaml = new Yaml();
            Reader fileReader = new FileReader( inputYamlFilePath);
            Map<String, Object> yamlObject = yaml.load(fileReader);

            // Преобразуем объект YAML в JSON с красивым форматированием
            Gson gson = new GsonBuilder().setPrettyPrinting().create();


            String jsonString = gson.toJson(yamlObject);

            File inputFile = new File(inputYamlFilePath);
            String inputFileName = inputFile.getName();
            String outputFileName = inputFileName.replace(".yaml", ".json");

            File inputDirectory = inputFile.getParentFile();
            outputFilePath = new File(inputDirectory, outputFileName).getAbsolutePath();

            long startTime = System.currentTimeMillis();
            Writer fileWriter = new FileWriter(outputFilePath);
            fileWriter.write(jsonString);
            fileWriter.close();

            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;

            System.out.println("Конвертацію успішно завершено. Файл збережено: " + outputFilePath);

            // Записываем информацию о конвертации в файл result.log
            ResultLogger.logConversionResult(getFileName(inputYamlFilePath), getFileName(outputFilePath),
                    duration, getFileSize(inputYamlFilePath), getFileSize(outputFilePath));


        } catch (IOException e) {
            System.err.println("Помилка при конвертації YAML у JSON: " + e.getMessage());
            e.printStackTrace();
            // Записываем информацию об ошибке в файл result.log
            ResultLogger.logConversionResult(getFileName(inputYamlFilePath), "Не конвертувався (помилка)");
        }
        return outputFilePath;
    }

    private static String getFileName(String filePath) {
        File file = new File(filePath);
        return file.getName().replaceFirst("[.][^.]+$", "");
    }

    private static long getFileSize(String filePath) throws IOException {
        return Files.size(Paths.get(filePath));
    }


}



