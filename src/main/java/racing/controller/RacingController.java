package racing.controller;

import racing.domain.NamedCars;
import racing.domain.strategy.MoveStrategy;
import racing.domain.strategy.NameValidationStrategy;
import racing.domain.strategy.WinnerCarStrategy;
import racing.view.RacingInputView;
import racing.view.RacingOutputView;

public class RacingController {

  private final RacingInputView racingCarNameInputView;
  private final RacingOutputView racingCarNameOutputView;
  private final MoveStrategy moveStrategy;
  private final NameValidationStrategy nameValidationStrategy;
  private final WinnerCarStrategy winnerCarStrategy;

  public RacingController(RacingInputView racingCarNameInputView,
      RacingOutputView racingCarNameOutputView,
      MoveStrategy moveStrategy, NameValidationStrategy nameValidationStrategy,
      WinnerCarStrategy winnerCarStrategy) {
    this.racingCarNameInputView = racingCarNameInputView;
    this.racingCarNameOutputView = racingCarNameOutputView;
    this.moveStrategy = moveStrategy;
    this.nameValidationStrategy = nameValidationStrategy;
    this.winnerCarStrategy = winnerCarStrategy;
  }

  public void startGame() {
    String carNames = racingCarNameInputView.getRacingCarNames();
    int attemptCount = racingCarNameInputView.getRacingAttemptCount();

    racingCarNameOutputView.printResultTitle();

    NamedCars cars = NamedCars.newInstance(carNames, nameValidationStrategy, moveStrategy);
    for (int i = 0; i < attemptCount; i++) {
      cars.attempt();
      racingCarNameOutputView.printCarNameAndDistance(cars);
    }

    NamedCars winners = winnerCarStrategy.getWinners(cars);
    racingCarNameOutputView.printWinner(winners);

  }
}
