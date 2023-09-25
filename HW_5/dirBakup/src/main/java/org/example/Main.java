package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

//TODO: Написать функцию, создающую резервную копию всех файлов в директории во вновь созданную папку ./backup

public class Main {
    public static void main(String[] args) {
        bakup((new File(".")));
    }

    /**
     * Метод создает резервную копию всех файлов в директории и сохраняет в новой папке ./backup
     * @param file - текущая папка или путь к папке.
     */
    public static void bakup(File file) {

        File backupDir = new File("./backup");
        if (!backupDir.exists()) {
            backupDir.mkdir();
        }
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isFile()) {
                    try {
                        Files.copy(f.toPath(), new File(backupDir, f.getName()).toPath());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}