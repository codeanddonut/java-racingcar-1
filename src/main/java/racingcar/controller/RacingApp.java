package racingcar.controller;

import racingcar.domain.Race;
import racingcar.domain.RoundSnapshot;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingApp {
    public static void main(String[] args) {
        final Race race = new Race(InputView.inputCarNames(), InputView.inputNumberOfTrials());
        OutputView.printRaceStartMessage();
        RoundSnapshot roundSnapshot = null;
        while (race.hasNext()) {
            roundSnapshot = race.next();
            OutputView.printEachRound(roundSnapshot);
        }
        OutputView.printWinners(roundSnapshot);
    }
}