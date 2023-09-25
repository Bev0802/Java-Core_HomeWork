package org.example;

import java.io.File;

public class Tree {
    public static void main(String[] args) {
        print(new File("."), "", true);
    }

    /**
     * TODO: Доработать метод print, необходимо распечатывать директории и файлы.
     * Метод печати дерева файлов
     *
     * @param file   - текущая папка
     * @param indent - отступ
     * @param last   - последняя папка
     */
    public static void print(File file, String indent, boolean last) {
        System.out.print(indent);
        if (last) {
            System.out.print("└── ");
            indent = indent + "   ";
        } else {
            System.out.print("├── ");
            indent = indent + "│  ";
        }
        System.out.println(file.getName());

        File[] files = file.listFiles();
        if (files == null)
            return;

        int subDirTotal = 0;
        for (File f: files) {            
            subDirTotal++;
        }
        int subDirCounter = 0;
        for (File f: files) {            
            subDirCounter++;             
            print(f, indent, subDirCounter == subDirTotal);
        }
    }
}
