import org.junit.jupiter.api.Test;
import ru.ac.uniyar.mf.lizunova.Main;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalcTest {
    @Test
    void additionPositive() {
        String actual = Main.calculate("1", "+", "1");
        assertEquals("2", actual);
    }

    @Test
    void multiplicationPositive() {
        String actual = Main.calculate("2", "*", "2");
        assertEquals("4", actual);
    }

    @Test
    void divisionPositive() {
        String actual = Main.calculate("4", "/", "2");
        assertEquals("2", actual);
    }

    @Test
    void subtractionPositive() {
        String actual = Main.calculate("2", "-", "2");
        assertEquals("0", actual);
    }

    @Test
    void additionNegative() {
        String actual = Main.calculate("-1", "+", "-1");
        assertEquals("-2", actual);
    }

    @Test
    void multiplicationNegative() {
        String actual = Main.calculate("-2", "*", "-2");
        assertEquals("4", actual);
    }

    @Test
    void divisionNegative() {
        String actual = Main.calculate("-4", "/", "-2");
        assertEquals("2", actual);
    }

    @Test
    void subtractionNegative() {
        String actual = Main.calculate("-2", "-", "-2");
        assertEquals("0", actual);
    }

    @Test
    void additionNegativeAndPositiv() {
        String actual = Main.calculate("-1", "+", "1");
        assertEquals("0", actual);
    }

    @Test
    void multiplicationNegativeAndPositiv() {
        String actual = Main.calculate("-2", "*", "2");
        assertEquals("-4", actual);
    }

    @Test
    void divisionNegativeAndPositiv() {
        String actual = Main.calculate("-4", "/", "2");
        assertEquals("-2", actual);
    }

    @Test
    void subtractionNegativeAndPositiv() {
        String actual = Main.calculate("-2", "-", "2");
        assertEquals("-4", actual);
    }

    @Test
    void additionFractionWhole() {
        String actual = Main.calculate("1/2", "+", "1/2");
        assertEquals("1", actual);
    }

    @Test
    void multiplicationFractionWhole() {
        String actual = Main.calculate("2/1", "*", "4/2");
        assertEquals("4", actual);
    }

    @Test
    void divisionFractionWhole() {
        String actual = Main.calculate("1/2", "/", "2/4");
        assertEquals("1", actual);
    }

    @Test
    void subtractionFractionWhole() {
        String actual = Main.calculate("1/2", "-", "1/2");
        assertEquals("0", actual);
    }

    @Test
    void additionFraction() {
        String actual = Main.calculate("1/2", "+", "4/2");
        assertEquals("5/2", actual);
    }

    @Test
    void multiplicationFraction() {
        String actual = Main.calculate("2/3", "*", "1/3");
        assertEquals("2/9", actual);
    }

    @Test
    void divisionFraction() {
        String actual = Main.calculate("5/6", "/", "1/2");
        assertEquals("5/3", actual);
    }

    @Test
    void subtractionFraction() {
        String actual = Main.calculate("3/4", "-", "2/4");
        assertEquals("1/4", actual);
    }

    @Test
    void divisionFractionByZero1() {
        String actual = Main.calculate("5/0", "/", "1/2");
        assertEquals("0", actual);
    }

    @Test
    void divisionFractionByZero2() {
        String actual = Main.calculate("5/4", "/", "0");
        assertEquals("Деление на ноль!", actual);
    }
}
