package racing.domain.strategy;

public class NumberCompareMoveStrategy implements MoveStrategy {

  private final NumberGenerator numberGenerator;
  public static final int CAN_MOVE_NUMBER = 4;

  public NumberCompareMoveStrategy(NumberGenerator numberGenerator) {
    this.numberGenerator = numberGenerator;
  }

  @Override
  public boolean canMove() {
    return numberGenerator.generate() >= CAN_MOVE_NUMBER;
  }
}
