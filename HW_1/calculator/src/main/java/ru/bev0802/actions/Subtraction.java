package ru.bev0802.actions;


public class Subtraction {

    /**Класс Addition производит вычитание и возращает результат
     * @param a - целое или дробное число
     * @param b - целое или дробное число
     */
     
    public Subtraction(int a, int b) {
        int c = a - b;
        System.out.printf("%d - %d = %d%n", a, b, c);
    }
    /**Класс Addition производит вычитание и возращает результат
     * @param a - целое или дробное число
     * @param b - целое или дробное число
     */
    public Subtraction(Float a, Float b) {
        float c = a - b;
        System.out.printf("%.2f - %.2f = %.2f%n", a, b, c);
    }
}
