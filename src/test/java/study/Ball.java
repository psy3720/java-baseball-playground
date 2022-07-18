package study;

import java.util.Objects;

public class Ball {
    private int index;
    private final int number;

    public Ball(int number) {
        this.number = number;
    }

    public Ball(int index, int number) {
        this.index = index;
        this.number = number;
    }

    public Boolean isNumber() {
        if(number > 0 && number < 10) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return index == ball.index &&
                number == ball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, number);
    }

    public BallStatus compare(Ball ball) {
        if(this.equals(ball)) {
            return BallStatus.STRIKE;
        }

        if(ball.index != index && ball.number == number) {
            return BallStatus.BALL;
        }

        return BallStatus.NOTHING;
    }

    @Override
    public String toString() {
        return "Ball{" +
                "index=" + index +
                ", number=" + number +
                '}';
    }
}
