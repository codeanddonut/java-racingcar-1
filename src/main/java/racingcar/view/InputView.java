package racingcar.view;

import racingcar.domain.Cars;
import racingcar.domain.Trial;

import java.util.Scanner;

public class InputView {
    private static final Scanner input = new Scanner(System.in);

    public static Cars inputCarNames() {
        for (;;) {
            System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
            try {
                return new Cars(input.nextLine());
            } catch (IllegalArgumentException e) {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }

    public static Trial inputNumberOfTrials() {
        for(;;) {
            System.out.println("시도할 회수는 몇회인가요?");
            try {
                return Trial.of(Integer.parseInt(input.nextLine().trim()));
            } catch (IllegalArgumentException e) {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }
}