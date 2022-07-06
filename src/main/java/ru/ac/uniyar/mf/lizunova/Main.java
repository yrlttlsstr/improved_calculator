package ru.ac.uniyar.mf.lizunova;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = "";
        str = in.nextLine();
        String[] part = str.split(" ");
        Fraction num1 = inputFraction(part[0]);
        Fraction num2 = inputFraction(part[2]);

        switch (part[1]) {
            case "+":
                System.out.println(num1.sum(num2).toString());
                break;
            case "-":
                System.out.println(num1.subtract(num2).toString());
                break;
            case "*":
                System.out.println(num1.multiply(num2).toString());
                break;
            case "/":
                if (num2.IsZero()) {
                    System.out.println("Деление на ноль!");
                } else {
                    System.out.println(num1.div(num2).toString());
                }
                break;
        }
    }

    public static Fraction inputFraction(String fraction) {
        String[] data = fraction.split("/");
        if (data.length == 1) {
            return new Fraction(Integer.parseInt(data[0]));
        }
        return new Fraction(Integer.parseInt(data[0]), Integer.parseInt(data[1]));
    }

    public static String calculate(String num1, String oper, String num2) {
        Fraction val1 = inputFraction(num1);
        Fraction val2 = inputFraction(num2);



        switch (oper) {
            case "+":
                return val1.sum(val2).toString();
            case "-":
                return val1.subtract(val2).toString();
            case "*":
                return val1.multiply(val2).toString();
            case "/":
                if (val2.IsZero()) {
                    return "Деление на ноль!";
                } else {
                    return val1.div(val2).toString();
                }
            default:
                return "Введена была неверная операция!";
        }
    }
}