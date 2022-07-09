package study;

import java.util.Scanner;

public class InputView {
    Scanner sc;

    public InputView() {
        sc = new Scanner(System.in);
    }

    public int input() {
        String inputNumber;
        System.out.printf("숫자를 입력해 주세요 : ");
        inputNumber = sc.next();

        while(!validation(inputNumber)) {
            System.out.printf("숫자를 입력해 주세요 : ");
            inputNumber = sc.next();
        }

        return Integer.parseInt(inputNumber);
    }

    public int endInput() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        int inputNumber = sc.nextInt();
        return inputNumber;
    }

    public Boolean validation(String number) {
        if(!isDigit(number)) {
            return false;
        }

        if ((int) Math.log10(Integer.parseInt(number))+1  != 3) {
            return false;
        }

        return true;
    }

    public Boolean isDigit(String number) {
        try {
            Integer.parseInt(number);
            return true;
        }
        catch(NumberFormatException e) {
            return false;
        }
    }
}
