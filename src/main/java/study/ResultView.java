package study;

public class ResultView {
    int strike;
    int ball;

    public void result(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;

        if(isNothing()) {
            System.out.printf("낫싱");
        }

        if(ball > 0) {
            System.out.printf("%d볼 ", ball);
        }

        if(strike > 0) {
            System.out.printf("%d스트라이크", strike);
        }

        System.out.println();
    }

    public Boolean isNothing() {
        if (strike == 0 && ball == 0) {
            return true;
        }
        return false;
    }
}
