package ru.ac.uniyar.mf.lizunova;

import java.util.Scanner;

public class Check {

    // Метод правильного ввода целого числа.
    public static int inputInt(Scanner in) {
        boolean done = false;
        int num = 0;
        while (!done) {
            try {
                String str = in.nextLine();
                num = Integer.parseInt(str);
                done = true;
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели не число или не целое число!\nПовторите попытку: ");
            }
        }
        return num;
    }

    // Метод проверки правильного ввода формата выражения.
    public static boolean inputStrFormat(String str) {
        String[] part = str.split(" ");
        if (part.length == 3) {
            return true;
        } else {
            System.out.println("Вы ввели выражение в неправильном формате!\nПовторите попытку: ");
            return false;
        }
    }

    // Метод проверки правильного ввода каждого числа выражения.
    public static boolean inputStrInt(String str) {
        try {
            String[] part = str.split(" ");
            Fraction num1 = Main.inputFraction(part[0]);
            Fraction num2 = Main.inputFraction(part[2]);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Вы ввели не число или не целое число!\nПовторите попытку: ");
            return false;
        }
    }

    // Метод проверки правильного ввода каждой дроби выражения(знаменатель не может равнятся нулю).
    public static boolean inputStrFract(String str) {
        String[] part = str.split(" ");
        Fraction num1 = Main.inputFraction(part[0]);
        Fraction num2 = Main.inputFraction(part[2]);
        if (CheckDenominsZero(num1, num2)) {
            System.out.println("Знаменатель равен нулю!\nПовторите попытку: ");
            return false;
        }
        return true;
    }

    // Метод проверки правильного ввода операции.
    public static boolean inputStrOper(String str) {
        String[] part = str.split(" ");
        if (part[1].equals("+") || part[1].equals("-") || part[1].equals("*") || part[1].equals("/")) {
            return true;
        }
        System.out.println("Введена была неверная операция!\nПовторите попытку: ");
        return false;
    }

    // Метод проверяет не введено ли деление на ноль.
    public static boolean inputDivZero(String str) {
        String[] part = str.split(" ");
        Fraction num1 = Main.inputFraction(part[0]);
        Fraction num2 = Main.inputFraction(part[2]);
        if ((part[1].equals("/")) && (num2.IsZero())) {
            System.out.println("Деление на ноль!\nПовторите попытку: ");
            return false;
        }
        return true;
    }

    // Метод правильного ввода выражения.
    public static String inputStr(Scanner in) {
        boolean done = false;
        String str = "";
        while (!done) {
            str = in.nextLine();
            done = inputStrFormat(str);
            if (done) {
                done = inputStrInt(str);
                if (done) {
                    done = inputStrFract(str);
                    if (done) {
                        done = inputStrOper(str);
                        if (done) {
                            done = inputDivZero(str);
                        }
                    }
                }
            }
        }
        return str;
    }

    // Метод проверяет равен ли знаменатель нулю.
    public static boolean CheckDenominZero(Fraction num) {
        return num.DenominIsZero();
    }

    // Метод проверяет равенство знаменателя нулю для обеих дробей.
    public static boolean CheckDenominsZero(Fraction num1, Fraction num2) {
        if (CheckDenominZero(num1)) {
            return true;
        }
        return CheckDenominZero(num2);
    }
}
