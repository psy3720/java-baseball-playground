package study;

public enum BallStatus {
    STRIKE, BALL, NOTHING;

    public static Boolean isNothing(long strike, long ball) {
        return strike == 0 && ball == 0;
    }

    public static boolean isBall(long ball) {
        return ball > 0;
    }

    public static boolean isStrike(long strike) {
        return strike > 0;
    }
}
