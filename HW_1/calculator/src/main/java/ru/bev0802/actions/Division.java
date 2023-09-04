package ru.bev0802.actions;

public class Division {

/**Класс Division производит деление двух чисел и возращает результат
     * 
     * @param a - целое или дробное число
     * @param b - целое или дробное число. проверка на 0, если число равно 0 возращается сообщение.
     */
    public Division(float a, float b) {    
        division(b);    
        float c = a / b;
        System.out.printf("%.2f / %.2f = %.2f%n", a, b, c);    
    }
/**Класс Division производит деление двух чисел и возращает результат
     * 
     * @param a - целое или дробное число
     * @param b - целое или дробное число. проверка на 0, если число равно 0 возращается сообщение.
     */
    public Division(int a, int b) {
        division(b);
        int c = a / b;
        System.out.printf("%d / %d = %d%n", a, b, c);
    }

    private void division(int b) {       
        if (b == 0) {
            System.out.println("На ноль делить нельзя");
            return;
        }    
    }

    private void division(float b) {
        if (b == 0) {
            System.out.println("На ноль делить нельзя");
            return;
        }
    }


}
