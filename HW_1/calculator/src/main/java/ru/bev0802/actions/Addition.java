package ru.bev0802.actions;

public class Addition {

    /**Класс Addition производит сложение двух чисел и возращает результат
     * @param a - целое число (int)
     * @param b - целое число (int)  
     */
    public Addition(int a, int b) {
        int c = a + b;
        System.out.printf("%d + %d = %d%n", a, b, c);
    }

    /**Класс Addition производит сложение двух чисел и возращает результат
     * @param a - дробное число (float)
     * @param b - дробное число (float)
     */
    public Addition(Float a, Float b) {
        float c = a + b;
        System.out.printf("%.2f + %.2f = %.2f%n", a, b, c);
    }

  
    


}
