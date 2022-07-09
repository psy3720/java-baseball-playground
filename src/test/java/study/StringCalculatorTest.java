package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {
    StringCalculator stringCalculator;

    @BeforeEach
    void setStringCalculator() {
        stringCalculator = new StringCalculator();
    }

    @Test
    @DisplayName("문자열 계산기 - 정상값 입력")
    void stringCaculator() throws Exception {
        String actual = "2 + 3 * 4 / 2";
        assertThat(stringCalculator.calculate(actual)).isEqualTo(10);
    }

    @Test
    @DisplayName("연산자가 두개 연속으로 오는 경우 에러")
    void sequence_operator() {
        String actual = "2 + 3 * * 4 / 2";
        assertThatThrownBy(() -> stringCalculator.calculate(actual))
                .isInstanceOf(EmptyStackException.class);
    }

    @Test
    @DisplayName("숫자가 두개 연속으로 오는 경우 에러")
    void sequence_number() throws Exception {
        String actual = "2 + 3 3 * 4 / 2";
        assertThatThrownBy(() -> stringCalculator.calculate(actual))
                .isInstanceOf(Exception.class)
                .hasMessage("잘못된 입력값");
    }

    @Test
    @DisplayName("연산자가 먼저오면 에러")
    void first_Operator() {
        String actual = "* 2 + 3 * 4 / 2";
        assertThatThrownBy(() -> stringCalculator.calculate(actual))
                .isInstanceOf(EmptyStackException.class);
    }
}

class StringCalculator {
    Stack<String> operator;
    Stack<Integer> result;

    StringCalculator() {
        result = new Stack<>();
        operator = new Stack<>();
    }

    public int calculate(String input) throws Exception {
        String[] values = input.split(" ");

        for (int i = values.length - 1; i >= 0; i--)
            this.push(values[i]);

        while (!operator.isEmpty())
            result.push(calculateOperatorDistribute());

        if (result.size() != 1) {
            throw new Exception("잘못된 입력값");
        }

        return result.pop();
    }

    private void push(String s) {
        if (isOperator(s))
            operator.push(s);

        if (!isOperator(s))
            result.push(Integer.parseInt(s));
    }

    private int calculateOperatorDistribute() {
        String operator = this.operator.pop();
        int v1 = result.pop();
        int v2 = result.pop();

        if ("+".equals(operator))
            return this.add(v1, v2);
        if ("-".equals(operator))
            return this.sub(v1, v2);
        if ("*".equals(operator))
            return this.mul(v1, v2);
        if ("/".equals(operator))
            return this.div(v1, v2);
        return 0;
    }

    public Boolean isOperator(String s) {
        if ("+".equals(s))
            return true;
        if ("-".equals(s))
            return true;
        if ("/".equals(s))
            return true;
        if ("*".equals(s))
            return true;

        return false;
    }

    public int add(int v1, int v2) {
        return v1 + v2;
    }

    public int sub(int v1, int v2) {
        return v1 - v2;
    }

    public int mul(int v1, int v2) {
        return v1 * v2;
    }

    public int div(int v1, int v2) {
        return v1 / v2;
    }
}