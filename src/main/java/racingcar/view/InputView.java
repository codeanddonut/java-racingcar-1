package racingcar.view;

import racingcar.domain.Cars;
import racingcar.domain.Trial;

import java.util.Scanner;

public class InputView {
    private static final Scanner input = new Scanner(System.in);

    public static Cars inputCarNames() {
        return TryUntilSuccess.run(() -> {
            System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
            return new Cars(input.nextLine());
        });
    }

    public static Trial inputNumberOfTrials() {
        return TryUntilSuccess.run(() -> {
            System.out.println("시도할 회수는 몇회인가요?");
            return Trial.of(Integer.parseInt(input.nextLine().trim()));
        });
    }
}