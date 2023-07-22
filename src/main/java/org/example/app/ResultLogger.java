package org.example.app;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ResultLogger {
    public static void logConversionResult(String fileName, String newFileName, long duration, long oldSize, long newSize) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("result.log", true))) {
            StringBuilder logBuilder = new StringBuilder();
            logBuilder.append(fileName).append(" -> ").append(newFileName)
                    .append(", Duration: ").append(duration).append("ms")
                    .append(", Old Size: ").append(oldSize).append(" bytes")
                    .append(", New Size: ").append(newSize).append(" bytes");

            writer.println(logBuilder.toString());
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл result.log: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void logConversionResult(String fileName, String errorMessage) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("result.log", true))) {
            StringBuilder logBuilder = new StringBuilder();
            logBuilder.append(fileName).append(" -> ").append(errorMessage);

            writer.println(logBuilder);
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл result.log: " + e.getMessage());
            e.printStackTrace();
        }
    }
}


