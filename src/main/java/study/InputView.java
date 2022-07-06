package study;

import java.util.Scanner;

public class InputView {
    Scanner sc;

    public InputView() {
        sc = new Scanner(System.in);
    }

    public int input() {
        System.out.printf("숫자를 입력해 주세요 : ");
        int inputNumber = sc.nextInt();

        return inputNumber;
    }
}
