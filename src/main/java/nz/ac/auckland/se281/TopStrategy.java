package nz.ac.auckland.se281;

/** Class to define the top strategy for the AI. */
public class TopStrategy implements Strategy {
  // Variables to store the player choice, odd count, and even count
  private final String playerChoice;
  private final int oddCount;
  private final int evenCount;

  /**
   * Constructor for the TopStrategy class.
   *
   * @param playerChoice Odd or Even
   * @param oddCount Number of odd human inputs
   * @param evenCount Number of even human inputs
   */
  public TopStrategy(String playerChoice, int oddCount, int evenCount) {
    this.playerChoice = playerChoice;
    this.oddCount = oddCount;
    this.evenCount = evenCount;
  }

  /** Method to execute the top strategy. */
  @Override
  public int execute() {
    // Outputs a random number based on the player choice
    if (playerChoice.equals("ODD")) {
      if (oddCount > evenCount) {
        return Utils.getRandomOddNumber();
      } else if (evenCount > oddCount) {
        return Utils.getRandomEvenNumber();
      } else {
        return Utils.getRandomNumberRange(0, 5);
      }
    }

    // Outputs a random number based on the player choice
    if (playerChoice.equals("EVEN")) {
      if (oddCount > evenCount) {
        return Utils.getRandomEvenNumber();
      } else if (evenCount > oddCount) {
        return Utils.getRandomOddNumber();
      } else {
        return Utils.getRandomNumberRange(0, 5);
      }
    }

    // Outputs a random number between 0 and 5
    return Utils.getRandomNumberRange(0, 5);
  }

  /** Method to get the strategy name. */
  @Override
  public String getStrategyName() {
    return "top";
  }
}
