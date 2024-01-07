package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Program {

    private static final int WIN_COUNT = 4; // Выигрышная комбинация
    private static final char DOT_HUMAN = 'X'; // Фишка игрока - человек
    private static final char DOT_AI = '0'; // Фишка игрока - компьютер
    private static final char DOT_EMPTY = '*'; // Признак пустого поля

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    private static char[][] field; // Двумерный массив хранит текущее состояние игрового поля

    private static int fieldSizeX; // Размерность игрового поля
    private static int fieldSizeY; // Размерность игрового поля


    public static void main(String[] args) {

        field = new char[3][];

        while (true){
            initialize();
            printField();
            while (true){
                humanTurn();
                printField();
                if (checkGameState(DOT_HUMAN, "Вы победили!"))
                    break;
                aiTurn();
                printField();
                if (checkGameState(DOT_AI, "Победил компьютер!"))
                    break;
            }
            System.out.print("Желаете сыграть еще раз? (Y - да): ");
            if (!scanner.next().equalsIgnoreCase("Y"))
                break;
        }
    }

    /**
     * Инициализация объектов игры
     */
    private static void initialize(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество ячеек по горизонтали (от 3 до 10): ");
        fieldSizeX = scanner.nextInt();
        System.out.println("Введите количество ячеек по вертикали (от 3 до 10): ");
        fieldSizeY = scanner.nextInt();
        field = new char[fieldSizeX][fieldSizeY];
        for (int x = 0; x < fieldSizeX; x++){
            for (int y = 0; y < fieldSizeY; y++){
                field[x][y] = DOT_EMPTY;
            }
        }

    }

    /**
     * Отрисовка игрового поля
     *
     *     +-1-2-3-
     *     1|*|X|0|
     *     2|*|*|0|
     *     3|*|*|0|
     *     --------
     */
    private static void printField(){
        System.out.print("+");
        for (int x = 0; x < fieldSizeX * 2 + 1; x++){
            System.out.print((x % 2 == 0) ? "-" : x / 2 + 1);
        }
        System.out.println();

        for (int x = 0; x < fieldSizeX; x++){
            System.out.print(x + 1 + "|");
            for (int y = 0; y < fieldSizeY; y++){
                System.out.print(field[x][y] + "|");
            }
            System.out.println();
        }

        for (int x = 0; x < fieldSizeX * 2 + 2; x++){
            System.out.print("-");
        }
        System.out.println();

    }

    /**
     * Обработка хода игрока (человек)
     */
    private static void humanTurn(){
        int x, y;

        do {

            while (true){
                System.out.print("Введите координату хода X (от 1 до " + fieldSizeX + "): ");
                if (scanner.hasNextInt()){
                    x = scanner.nextInt() - 1;
                    scanner.nextLine();
                    break;
                }
                else {
                    System.out.println("Некорректное число, повторите попытку ввода.");
                    scanner.nextLine();
                }
            }

            while (true){
                System.out.print("Введите координату хода Y (от 1 до 3): ");
                if (scanner.hasNextInt()){
                    y = scanner.nextInt() - 1;
                    scanner.nextLine();
                    break;
                }
                else {
                    System.out.println("Некорректное число, повторите попытку ввода.");
                    scanner.nextLine();
                }
            }
        }
        while (!isCellValid(x, y) || !isCellEmpty(x, y));
        field[x][y] = DOT_HUMAN;
    }
    /**
     * Проверка, ячейка является пустой (DOT_EMPTY)
     * @param x
     * @param y
     * @return
     */
    private static boolean isCellEmpty(int x, int y){
        return field[x][y] == DOT_EMPTY;
    }
    /**
     * Проверка корректности ввода
     * (координаты хода не должны превышать размерность игрового поля)
     * @param x
     * @param y
     * @return
     */
    private static boolean isCellValid(int x, int y){
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    /**
     * Обработка хода компьютера
     */
    private static void aiTurn(){
        int x, y;

        do {
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
        }
        while (!isCellEmpty(x, y));
        field[x][y] = DOT_AI;
    }

    /**
     * Проверка состояния игры
     * @param c фишка игрока
     * @param s победный слоган
     * @return
     */
    private static boolean checkGameState(char c, String s){
        if (checkWin(c, 3, 3)) {
            System.out.println(s);
            return true;
        }
        if (checkDraw()) {
            System.out.println("Ничья!");
            return true;
        }

        return false; // Игра продолжается
    }

    /**
     * Проверка победы
     * @param c
     * @return
     */
    private static boolean checkWinI(char c){

        // Проверка по трем горизонталям
        if (field[0][0] == c && field[0][1] == c && field[0][2] == c) return true;
        if (field[1][0] == c && field[1][1] == c && field[1][2] == c) return true;
        if (field[2][0] == c && field[2][1] == c && field[2][2] == c) return true;

        // Проверка по трем вертикалям
        if (field[0][0] == c && field[1][0] == c && field[2][0] == c) return true;
        if (field[0][1] == c && field[1][1] == c && field[2][1] == c) return true;
        if (field[0][2] == c && field[1][2] == c && field[2][2] == c) return true;

        // Проверка по диагоналям
        if (field[0][0] == c && field[1][1] == c && field[2][2] == c) return true;
        if (field[0][2] == c && field[1][1] == c && field[2][0] == c) return true;

        return false;
    }

    private static boolean checkWin(char c, int rows, int cols) {
        // Проверка по горизонталям
        for (int x = 0; x < rows; x++) {
            boolean win = true;
            for (int y = 0; y < cols; y++) {
                if (field[x][y] != c) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }

        // Проверка по вертикалям
        for (int y = 0; y < cols; y++) {
            boolean win = true;
            for (int x = 0; x < rows; x++) {
                if (field[x][y] != c) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }

        // Проверка по диагонали (слева сверху вправо снизу)
        boolean win = true;
        for (int x = 0; x < rows; x++) {
            if (field[x][x] != c) {
                win = false;
                break;
            }
        }
        if (win) return true;

        // Проверка по диагонали (слева снизу вправо сверху)
        win = true;
        for (int x = 0; x < rows; x++) {
            if (field[x][cols - 1 - x] != c) {
                win = false;
                break;
            }
        }
        return win;
    }


        /**
         * Проверка на ничью
         * @return
         */
    private static boolean checkDraw(){
        for (int x = 0; x < fieldSizeX; x++){
            for (int y = 0; y < fieldSizeY; y++){
                if (isCellEmpty(x, y)) return false;
            }
        }
        return true;
    }



    public class GameChecker {

        public static boolean checkForWin(int[][] gameBoard) {
            int size = gameBoard.length;

            // Check for a win on the rows
            for (int i = 0; i < size; i++) {
                if (Arrays.equals(gameBoard[i], new int[]{1, 1, 1})) {
                    return true;
                } else if (Arrays.equals(gameBoard[i], new int[]{0, 0, 0})) {
                    return true;
                }
            }

            // Check for a win on the columns
            for (int i = 0; i < size; i++) {
                int[] column = new int[size];
                for (int j = 0; j < size; j++) {
                    column[j] = gameBoard[j][i];
                }
                if (Arrays.equals(column, new int[]{1, 1, 1})) {
                    return true;
                } else if (Arrays.equals(column, new int[]{0, 0, 0})) {
                    return true;
                }
            }

            // Check for a win on the diagonals
            if (Arrays.equals(diagonal(gameBoard, 1), new int[]{1, 1, 1})) {
                return true;
            } else if (Arrays.equals(diagonal(gameBoard, 1), new int[]{0, 0, 0})) {
                return true;
            }
            if (size > 3) {
                if (Arrays.equals(diagonal(gameBoard, -1), new int[]{1, 1, 1})) {
                    return true;
                } else if (Arrays.equals(diagonal(gameBoard, -1), new int[]{0, 0, 0})) {
                    return true;
                }
            }

            return false;
        }

        public static int[] diagonal(int[][] gameBoard, int direction) {
            int size = gameBoard.length;
            int[] diagonal = new int[size];
            for (int i = 0; i < size; i++) {
                diagonal[i] = gameBoard[i][i * direction];
            }
            return diagonal;
        }
    }

}
