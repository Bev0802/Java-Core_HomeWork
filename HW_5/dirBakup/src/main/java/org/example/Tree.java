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
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory())
                subDirTotal++;
            if (files[i].isFile())
                print(files[i], indent, true); // доделать!!!

        }

        int subDirCounter = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                subDirCounter++;
                if (files[i].isFile())
                    print(files[i], indent, false);
                print(files[i], indent, subDirCounter == subDirTotal);

            }
        }
    }
}