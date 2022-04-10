package racing.view;

import java.util.Scanner;
import racing.dto.RacingInput;
import racing.exception.UserInputFailException;

public class RacingInputView {

  public RacingInput printAndGetRacingInput() {
    try (Scanner scanner = new Scanner(System.in)) {
      return printAndGetRacingInput(scanner);
    } catch (RuntimeException e) {
      throw new UserInputFailException("사용자 입력을 받는데 실패했습니다.", e);
    }
  }

  private RacingInput printAndGetRacingInput(Scanner scanner) {
    RacingInput racingInput = new RacingInput();

    System.out.println("자동차 대수는 몇 대 인가요?");
    racingInput.setCarCount(inputToInt(scanner.nextLine()));

    System.out.println("시도할 횟수는 몇 회 인가요?");
    racingInput.setAttemptCount(scanner.nextInt());

    return racingInput;
  }

  private int inputToInt(String input) {
    return Integer.parseInt(input.trim());
  }


}
