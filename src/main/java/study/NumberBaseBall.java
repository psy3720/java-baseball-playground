package study;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberBaseBall {
    InputView inputView;
    ResultView resultView;
    Boolean endFlag;
    List<Character> list;
    List<Character> listTemp;
    int strike;
    int ball;

    public NumberBaseBall(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.init();
    }

    void init() {
        endFlag = false;
        this.createCorrectNumber();
        this.resetCountAndTempArray();
    }

    public List<Character> createCorrectNumber() {
        list = new ArrayList<>();

        while (list.size() < 3) {
            this.addNumberAfterDuplicateCheck((char) (new Random().nextInt(9) + 1 + '0'));
        }

        return list;
    }

    void addNumberAfterDuplicateCheck(char c) {
        if (!list.contains(c)) {
            list.add(c);
        }
    }

    void resetCountAndTempArray() {
        strike = 0;
        ball = 0;

        listTemp = new ArrayList<>();

        for (Character c : list) {
            listTemp.add(c);
            System.out.printf("%c", c);
        }
    }

    public void gameStart() {
        while (!endFlag) {
            this.throwNumberBall(inputView.input());
        }
    }

    void throwNumberBall(int number) {
        String userInputNumber = String.valueOf(number);

        for (int i = 0; i < userInputNumber.length(); i++) {
            this.count(i, userInputNumber.charAt(i));
        }

        resultView.result(strike, ball);

        if (strike == list.size()) {
            this.endGame();
        }

        this.resetCountAndTempArray();
    }

    void endGame() {
        int input = inputView.endInput();

        if (input == 1) {
            this.init();
            this.gameStart();
        }

        if (input == 2) {
            this.endFlag = true;
        }
    }

    void count(int index, char c) {
        this.strikeCount(index, c);
        this.ballCount(c);
    }

    void strikeCount(int index, char c) {
        if (c == listTemp.get(index)) {
            strike++;
            listTemp.set(index, 'e');
        }
    }

    void ballCount(char c) {
        if (listTemp.contains(c)) {
            ball++;
        }
    }

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        NumberBaseBall numberBaseBall = new NumberBaseBall(inputView, resultView);
        numberBaseBall.gameStart();
    }
}
