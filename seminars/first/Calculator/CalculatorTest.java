package seminars.first.Calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    public static void main(String[] args) {
        // Проверка базового функционала с целыми числами:
        if (8 != Calculator.calculation(2, 6, '+')) {
            throw new AssertionError("Ошибка в методе");
        }

        if (0 != Calculator.calculation(2, 2, '-')) {
            throw new AssertionError("Ошибка в методе");
        }

        if (14 != Calculator.calculation(2, 7, '*')) {
            throw new AssertionError("Ошибка в методе");
        }

        if (2 != Calculator.calculation(100, 50, '/')) {
            throw new AssertionError("Ошибка в методе");
        }

        // Случаи с неправильными аргументами
        // аргумент operator типа char, должен вызывать исключение, если он получает не базовые символы (+-*/)
        // try {
        //     seminars.first.Calculator.Calculator.calculation(8, 4, '_');
        // } catch (IllegalStateException e) {
        //     if (!e.getMessage().equals("Unexpected value operator: _")) {
        //         throw new AssertionError("Ошибка в методе");
        //     }
        // }

        // Проверка базового функционала с целыми числами, с использованием утверждений:
        assert 8 == Calculator.calculation(2, 6, '+');
        assert 0 == Calculator.calculation(2, 2, '-');
        assert 14 == Calculator.calculation(2, 7, '*');
        assert 2 == Calculator.calculation(100, 50, '/');

        // Проверка базового функционала с целыми числами, с использованием утверждений AssertJ:
        assertThat(Calculator.calculation(2, 6, '+')).isEqualTo(8);
        assertThat(Calculator.calculation(2, 2, '-')).isEqualTo(0);
        assertThat(Calculator.calculation(2, 7, '*')).isEqualTo(14);
        assertThat(Calculator.calculation(100, 50, '/')).isEqualTo(2);


// Homework_1. calculatingDiscount tests
        // correct calculation of the discount
        assertThat(Calculator.calculatingDiscount(100, 10)).isEqualTo(90);

        // correct calculation of the discount for the purchase amount equal to 0
        assertThat(Calculator.calculatingDiscount(0, 15)).isEqualTo(0);

        // correct calculation of the discount for the discountAmount equal to 0
        assertThat(Calculator.calculatingDiscount(99, 0)).isEqualTo(99);

        // throwing an exception for the purchase amount less than 0
        assertThatThrownBy(() -> Calculator.calculatingDiscount(-100, 15))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("The arguments are incorrect");
//        Calculator.calculatingDiscount(-100, 15);

        // throwing an exception for the discountAmount less than 0
        assertThatThrownBy(() -> Calculator.calculatingDiscount(58, -15))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("The arguments are incorrect");
//        Calculator.calculatingDiscount(58, -15);

        // throwing an exception for the discountAmount more than 100
        assertThatThrownBy(() -> Calculator.calculatingDiscount(58, 150))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("The arguments are incorrect");
//        Calculator.calculatingDiscount(58, 150);
    }
}