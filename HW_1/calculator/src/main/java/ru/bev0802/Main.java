package ru.bev0802;

import ru.bev0802.actions.*;

public class Main {
    /** Программа для выполнения математических операций
     * Addition, 
     * Subtraction, 
     * Multiplication, 
     *  Division
     */
    public static void main(String[] args) {        
        new Addition(2, 3);
        new Addition(5.25f, 7.53f);

        new Subtraction(7, 2);
        new Subtraction(7.25f, 5.53f);

        new Multiplication(2, 3);
        new Multiplication(5.25f, 7.53f);

        new Division(3, 2);
        new Division(10.25f, 5.53f);
    }
}