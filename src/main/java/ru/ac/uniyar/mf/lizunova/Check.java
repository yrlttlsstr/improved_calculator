package ru.ac.uniyar.mf.lizunova;

import java.util.Scanner;

public class Check {

    public static int inputInt(Scanner in) {
        boolean done = false;
        int num = 0;
        while(!done) {
            try {
                String str = in.nextLine();
                num = Integer.parseInt(str);
                done = true;
            } catch(NumberFormatException e) {
                System.out.println("Вы ввели не число или не целое число!\nПовторите попытку: ");
            }
        }
        return num;
    }

    public static boolean inputStrFormat(Scanner in, String str) {
                String[] part = str.split(" ");
                if(part.length == 3) {
                    return true;
                } else {
                    System.out.println("Вы ввели выражение в неправильном формате!\nПовторите попытку: ");
                    return false;
                }
    }

    public static boolean inputStrInt(Scanner in, String str) {
            try {
                String[] part = str.split(" ");
                Fraction num1 = Main.inputFraction(part[0]);
                Fraction num2 = Main.inputFraction(part[2]);
                return true;
            } catch(NumberFormatException e) {
                System.out.println("Вы ввели не число или не целое число!\nПовторите попытку: ");
                return false;
            }
    }

    public static boolean inputStrFract(Scanner in, String str) {
        String[] part = str.split(" ");
        Fraction num1 = Main.inputFraction(part[0]);
        Fraction num2 = Main.inputFraction(part[2]);
        if(CheckDenominsZero(num1, num2)) {
            System.out.println("Знаменатель равен нулю!\nПовторите попытку: ");
            return false;
        }
        return true;
    }

    public static boolean inputDivZero(Scanner in, String str) {
        String[] part = str.split(" ");
        Fraction num1 = Main.inputFraction(part[0]);
        Fraction num2 = Main.inputFraction(part[2]);
        if((part[1].equals("/")) && (num2.IsZero())) {
            System.out.println("Деление на ноль!\nПовторите попытку: ");
            return false;
        }
        return true;
    }

    public static String inputStr(Scanner in) {
        boolean done = false;
        String str = "";
        while(!done) {
            str = in.nextLine();
            done = inputStrFormat(in, str);
            if(done == true) {
                done = inputStrInt(in, str);
                if(done == true){
                    done = inputStrFract(in, str);
                    if(done == true) {
                        done = inputDivZero(in, str);
                    }
                }
            }
        }
        return str;
    }

    public static boolean CheckDenominZero(Fraction num) {
        return num.DenominIsZero();
    }

    public static boolean CheckDenominsZero(Fraction num1, Fraction num2) {
        if(CheckDenominZero(num1)){
            return true;
        }
        return CheckDenominZero(num2);
    }
}
