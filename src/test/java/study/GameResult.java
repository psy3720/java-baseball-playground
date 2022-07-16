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

        if(ball == 0 && strike == 0) {
            return "낫싱";
        }

        if(ball > 0) {
            result += ball + "볼 ";
        }

        if(strike > 0) {
            result += strike + "스트라이크";
        }

        return result;
    }
}
