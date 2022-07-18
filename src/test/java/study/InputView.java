package study;

import java.util.ArrayList;
import java.util.Scanner;

public class InputView {
    Scanner sc;
    GameResult play;

    public InputView() {
        sc = new Scanner(System.in);
    }

    public void input() {
        play = new GameResult(0, 0);
        Balls com = new Balls();
        com.balls.stream().forEach(ball -> System.out.println(ball.toString()));

        while (!play.result().equals("3스트라이크")) {
            System.out.printf("숫자를 입력해 주세요: ");
            String input = sc.next();
            String[] split = input.split("");

            ArrayList<Ball> user = new ArrayList<>();
            int index = 0;

            for (String s : split) {
                user.add(new Ball(index++, Integer.valueOf(s)));
            }

            Balls userBalls = new Balls(user);
            play = com.play(userBalls);
            System.out.println("play = " + play.result());
        }

        this.endGame();

    }

    private void endGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        int i = sc.nextInt();

        if (i == 1) {
            this.input();
            return;
        }

        if (i == 2) {
            System.out.println("게임 종료!");
            return;
        }

        this.endGame();
    }
}
