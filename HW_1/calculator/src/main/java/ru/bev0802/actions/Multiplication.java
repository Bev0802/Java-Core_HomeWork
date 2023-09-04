package ru.bev0802.actions;

public class Multiplication {

    /**Класс Multiplication производит умножение двух чисел и возращает результат
     * @param a - целое или дробное число
     * @param b - целое или дробное число
     */
    public Multiplication(int a, int b) {
        int c = a * b;
        System.out.printf("%d * %d = %d%n", a, b, c);
    }
    /**Класс Multiplication производит умножение двух чисел и возращает результат
     * @param a - целое или дробное число
     * @param b - целое или дробное число
     */
    public Multiplication(Float a, Float b) {
        float c = a * b;
        System.out.printf("%.2f * %.2f = %.2f%n", a, b, c);
    }

}
