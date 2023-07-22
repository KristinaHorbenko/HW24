package org.example.app;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {
    public static void listFilesInCurrentDirectory() {
        Path currentDirectory = Paths.get("");
        File directory = new File(currentDirectory.toUri());

        System.out.println("Поточна папка: " + currentDirectory.toAbsolutePath());

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Директорія не існує або не є дійсною директорією.");
            return;
        }

        File[] files = directory.listFiles();
        if (files == null || files.length == 0) {
            System.out.println("Директорія порожня.");
            return;
        }

        System.out.println("Файли у поточній папці:");
        for (File file : files) {
            System.out.println(file.getName());
        }
    }
}

