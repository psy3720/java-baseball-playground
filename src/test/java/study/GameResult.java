package study;

public class GameResult {
    private final long strike;
    private final long ball;

    public GameResult(long strike, long ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public String result() {
        String result = "";

        if(BallStatus.isNothing(strike, ball)) {
            return "낫싱";
        }

        if(BallStatus.isBall(ball)) {
            result += ball + "볼 ";
        }

        if(BallStatus.isStrike(strike)) {
            result += strike + "스트라이크";
        }

        return result;
    }
}
