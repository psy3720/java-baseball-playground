package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberBaseBallTest {
    NumberBaseBall numberBaseBall;
    ResultView resultView;
    InputView inputView;

    @BeforeEach
    void create() {
        resultView = new ResultView();
        inputView = new InputView();
        numberBaseBall = new NumberBaseBall(inputView, resultView);
    }

    @Test
    void init() {
        Boolean actual = numberBaseBall.endFlag;
        int ball = numberBaseBall.ball;
        int strike = numberBaseBall.strike;

        assertThat(actual).isFalse();
        assertThat(ball).isEqualTo(0);
        assertThat(strike).isEqualTo(0);
    }

    @Test
    void createCorrectNumber() {
        List<Character> correctNumber = numberBaseBall.createCorrectNumber();
        assertThat(correctNumber.size()).isEqualTo(3);
    }

    @Test
    void addNumberAfterDuplicateCheck() {
        List<Character> correctNumber = numberBaseBall.createCorrectNumber();
        numberBaseBall.addNumberAfterDuplicateCheck(correctNumber.get(0));

        assertThat(numberBaseBall.list.size()).isEqualTo(3);
    }

    @Test
    void resetCountAndTempArray() {
        List<Character> correctNumber = numberBaseBall.createCorrectNumber();

        int strike = numberBaseBall.strike;
        int ball = numberBaseBall.ball;
        numberBaseBall.resetCountAndTempArray();
        List<Character> listTemp = numberBaseBall.listTemp;

        assertThat(strike).isEqualTo(0);
        assertThat(ball).isEqualTo(0);
        assertThat(correctNumber).usingRecursiveComparison().isEqualTo(listTemp);
    }

    @Test
    void strikeCount() {
        List<Character> correctNumber = numberBaseBall.list;
        numberBaseBall.strikeCount(0, correctNumber.get(0));

        int strike = numberBaseBall.strike;

        assertThat(strike).isEqualTo(1);
    }

    @Test
    void ballCount() {
        List<Character> correctNumber = numberBaseBall.list;
        numberBaseBall.ballCount(correctNumber.get(0));

        int ball = numberBaseBall.ball;

        assertThat(ball).isEqualTo(1);
    }


}
