package nz.ac.auckland.se281;

public class TopStrategy implements AIStrategy {
  private final String playerChoice;
  private final int oddCount;
  private final int evenCount;

  public TopStrategy(String playerChoice, int oddCount, int evenCount) {
    this.playerChoice = playerChoice;
    this.oddCount = oddCount;
    this.evenCount = evenCount;
  }

  @Override
  public int execute() {
    if (playerChoice.equals("ODD")) {
      if (oddCount > evenCount) {
        return Utils.getRandomOddNumber();
      } else if (evenCount > oddCount) {
        return Utils.getRandomEvenNumber();
      } else {
        return Utils.getRandomNumberRange(0, 5);
      }
    }

    if (playerChoice.equals("EVEN")) {
      if (oddCount > evenCount) {
        return Utils.getRandomEvenNumber();
      } else if (evenCount > oddCount) {
        return Utils.getRandomOddNumber();
      } else {
        return Utils.getRandomNumberRange(0, 5);
      }
    }

    return Utils.getRandomNumberRange(0, 5);
  }

  @Override
  public String getStrategyName() {
    return "top";
  }
}
