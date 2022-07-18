package study;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Balls {
    List<Ball> balls;

    public Balls() {
        createRandomNumber();
    }

    public Balls(List<Ball> balls) {
        this.balls = balls;
    }

    public int count() {
        return balls.size();
    }

    public Boolean isDuplicate(Ball ball) {
        return balls.contains(ball);
    }

    public long compare(Balls user) {
        long count = 0;

        for (int i = 0; i < balls.size(); i++) {
            BallStatus compare = balls.get(i).compare(user.balls.get(i));

            if (compare == BallStatus.STRIKE) {
                count++;
            }
        }

        return count;
    }

    public long contains(Balls ball) {
        int count = 0;
        for (int i = 0; i < ball.balls.size(); i++) {
            if (contain(ball.balls.get(i))) {
                count++;
            }
        }

        return count;
//        return balls.stream()
//                .filter(ball1 -> ball.balls.contains(ball1))
//                .count();
    }

    public Boolean contain(Ball ball) {
        for(int i=0; i<balls.size(); i++) {
            BallStatus compare = balls.get(i).compare(ball);
            if(compare == BallStatus.BALL) {
                return true;
            }
        }
        return false;
    }

    public GameResult play(Balls user) {
        long strike = compare(user);
        long ball = contains(user);

        return new GameResult(strike, ball);
    }

    public List<Ball> createRandomNumber() {
        balls = new ArrayList<>();
        int index = 0;

        while (balls.size() < 3) {
            Random random = new Random();
            int i = random.nextInt(9) + 1;

            if (!isDuplicate(new Ball(index, i))) {
                balls.add(new Ball(index++, i));
            }
        }

        return balls;
    }
}
