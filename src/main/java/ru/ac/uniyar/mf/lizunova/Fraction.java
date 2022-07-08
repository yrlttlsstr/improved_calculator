package ru.ac.uniyar.mf.lizunova;

public class Fraction {
    // Поля класса: числитель и знаменатель.
    private int numer;
    private int denomin;

    // Метод находит НОД двух чисел.
    private int getNOD(int num1, int num2) {
        if (num1 == 0) {
            return num2;
        }
        if (num2 == 0) {
            return num1;
        }
        if (num1 > num2) {
            return getNOD(num1 % num2, num2);
        } else {
            return getNOD(num1, num2 % num1);
        }
    }

    // Метод упрощения дроби.
    private void simplify() {
        int nod = getNOD(Math.abs(numer), Math.abs(denomin));
        numer /= nod;
        denomin /= nod;
        if (denomin < 0) {
            denomin *= -1;
            numer *= -1;
        }
    }

    // Конструкторы.
    public Fraction() {
        numer = 0;
        denomin = 1;
    }
    public Fraction(int numer, int denomin) {
        this.numer = numer;
        this.denomin = denomin;
        simplify();
    }
    public Fraction(int numer) {
        this.numer = numer;
        this.denomin = 1;
    }

    // Методы операций с дробями.
    public Fraction sum(Fraction obj) {
        return new Fraction(numer * obj.denomin + obj.numer * denomin, denomin * obj.denomin);
    }
    public Fraction subtract(Fraction obj) {
        return new Fraction(numer * obj.denomin - obj.numer * denomin, denomin * obj.denomin);
    }
    public Fraction multiply(Fraction obj) {
        return new Fraction(numer * obj.numer, denomin * obj.denomin);
    }
    public Fraction div(Fraction obj) {
        return new Fraction(numer * obj.denomin, denomin * obj.numer);
    }

    // Метод проверяет равно ли число нулю.
    public boolean IsZero() {
        if ((denomin == 0) || (numer == 0)) {
            return true;
        }
        return false;
    }

    // Метод проверяет равен ли знаменатель нулю.
    public boolean DenominIsZero() {
        if (denomin == 0) {
            return true;
        }
        return false;
    }

    // Метод перевода дроби в строку.
    @Override
    public String toString() {
        if (denomin == 1) {
            return Integer.toString(numer);
        }
        return numer + "/" + denomin;
    }
}
