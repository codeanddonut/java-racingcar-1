package racingcar.view;

import racingcar.domain.LineSnapshot;
import racingcar.domain.RoundSnapshot;

import java.util.stream.IntStream;

public class OutputView {
    public static void printRaceStartMessage() {
        System.out.println("\n실행 결과");
    }

    public static void printEachRound(RoundSnapshot roundSnapshot) {
        while (roundSnapshot.hasNext()) {
            LineSnapshot lineSnapshot = roundSnapshot.next();
            System.out.println(lineSnapshot.name() + " : " + drawTrail(lineSnapshot.position()));
        }
        System.out.println();
    }

    private static String drawTrail(int position) {
        final StringBuilder trail = new StringBuilder();
        IntStream.range(0, position).forEach(i -> trail.append("-"));
        return trail.toString();
    }

    public static void printWinners(RoundSnapshot roundSnapshot) {
        String names = roundSnapshot.winners().reduce((a, b) -> a + ", " + b).get();
        System.out.println(
                names
                + HangulPostposition.differentiateIGa(names)
                + " 최종 우승했습니다."
        );
    }
}