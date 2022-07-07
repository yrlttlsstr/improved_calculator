package ru.ac.uniyar.mf.lizunova;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<String> expression = new ArrayList<>();

        Scanner in = new Scanner(System.in);
        System.out.print("Введите кол-во выражений, которые хотите посчитать: \n");
        int num = Check.inputInt(in);

        for(int i = 0; i < num; i++) {
            System.out.print("Выражение " + (i + 1) + "\n");

            String str = Check.inputStr(in);
            expression.add(str);
        }

        for(int i = 0; i < num; i++) {
            String[] part = expression.get(i).split(" ");

            String answer = calculate(part[0], part[1], part[2]);
            System.out.println("Ответ на выражение " + (i+1));
            System.out.println(answer);
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
                return val1.div(val2).toString();
            default:
                return "Введена была неверная операция!";
        }
    }
}