package WSOFT_homework.JUnit;

import org.example.Calc;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TaskCalc {

    //Задание 1:
    // Напишите тесты для проверки простого калькулятора, который выполняет сложение, вычитание и деление чисел.
    // Убедитесь, что тест проверяет деление на ноль.

    public static Calc calc;

    @BeforeAll
    public static void setUp() {
        calc = new Calc();
    }

    @Test
    public void shouldPlus() {
        double result = calc.plus(5, 8);
        double expected = 5 + 8;

        assertEquals(expected, result, "Результат сложения должен быть 13");
    }

    @Test
    public void shouldMinus() {
        double result = calc.minus(8, 5);
        double expected = 8 - 5;

        assertEquals(expected, result, "Результат вычитания должен быть 3");
    }

    @Test
    public void shouldDivision() {

        double result = calc.division(9, 3);
        double expected = (double) 9 / 3;

        assertEquals(expected, result, "Результат деления должен быть 3");
    }

    @Test
    void shouldNotDiv0() {
        Exception ex = assertThrows(ArithmeticException.class, () -> {
            int result = calc.division(1,0);
        });

        assertEquals("/ by zero", ex.getMessage());

    }

}
