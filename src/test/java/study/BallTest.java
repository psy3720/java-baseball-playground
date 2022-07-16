package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {
    /*
     * 기능 정리
     * 스트라이크: 같은 수가 같은 자리에 있는 경우
     * 볼: 다른 자리에 있는 경우
     * 낫싱: 같은 수가 전혀 없는 경우
     *
     * 3자리의 임의의 수를 입력 받는다
     * 유효성 검증(예외)
     *  - 1부터 9까지의 숫자 인지? [o]
     *  - 서로 다른 임의의 수인지? [o]
     *  - 3자리 수 인지? [o]
     * ---
     *
     *  com     player
     * 1 2 3 /  1 2 3
     *
     * */

    @Test
    @DisplayName("1부터 9까지의 숫자 여부")
    void isNumber() {
        Ball ball = new Ball(1);
        Boolean isNumber = ball.isNumber();

        assertThat(isNumber).isTrue();
    }

    @Test
    @DisplayName("공의 숫자 비교")
    void compareNumber() {
        Ball ball = new Ball(1);
        Boolean actual = ball.equals(new Ball(1));

        assertThat(actual).isTrue();
    }

    @Test
    @DisplayName("공의 개수가 3개")
    void countBalls() {
        Balls balls = new Balls(Arrays.asList(new Ball(1), new Ball(2), new Ball(3)));
        int size = balls.count();

        assertThat(size).isEqualTo(3);
    }

    @Test
    void duplicateBallNumber() {
        Balls balls = new Balls(Arrays.asList(new Ball(1), new Ball(2), new Ball(3)));

        Boolean actual = balls.isDuplicate(new Ball(3));
        assertThat(actual).isFalse();
    }

    @Test
    void compare() {
        Ball ball = new Ball(0, 1);
        BallStatus compare = ball.compare(new Ball(0, 1));
        assertThat(compare).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void strike() {
        Balls com = new Balls(Arrays.asList(new Ball(1), new Ball(2), new Ball(3)));
        Balls user = new Balls(Arrays.asList(new Ball(1), new Ball(2), new Ball(3)));

        long compare = com.compare(user);
        assertThat(compare).isEqualTo(3);

    }

    @Test
    void containsBall() {
        Balls com = new Balls(Arrays.asList(new Ball(1), new Ball(2), new Ball(3)));
        Balls user = new Balls(Arrays.asList(new Ball(2), new Ball(4), new Ball(1)));

        long actual = com.contains(user);
        assertThat(2).isEqualTo(actual);
    }

    @Test
    void result() {
        Balls com = new Balls(Arrays.asList(new Ball(1), new Ball(2), new Ball(3)));
//        Balls com = new Balls(Arrays.asList(new Ball(1), new Ball(2), new Ball(3)));
        Balls user = new Balls(Arrays.asList(new Ball(5), new Ball(4), new Ball(6)));

        GameResult result = com.play(user);
        String actual = result.result();

        assertThat(actual).isEqualTo("낫싱");
    }

    @Test
    void createRandomNumber() {
        Balls com = new Balls();
        List<Ball> ball = com.createRandomNumber();

        assertThat(ball.get(0).isNumber()).isTrue();
        assertThat(ball.get(1).isNumber()).isTrue();
        assertThat(ball.get(2).isNumber()).isTrue();
        assertThat(com.balls.size()).isEqualTo(3);
    }


}
