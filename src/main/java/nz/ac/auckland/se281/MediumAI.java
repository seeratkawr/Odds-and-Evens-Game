package nz.ac.auckland.se281;

public class MediumAI implements AI {
  // Variables to store the round count, player input, player choice, odd count, and even count
  private final int roundCount;
  private AIStrategy randomStrategy = new RandomStrategy();
  private AIStrategy topStrategy;

  /**
   * Constructor for the MediumAI class
   *
   * @param roundCount round number
   * @param playerChoice Odd or Even
   * @param oddCount Number of odd human inputs
   * @param evenCount Number of even human inputs
   */
  public MediumAI(int roundCount, String playerChoice, int oddCount, int evenCount) {
    // Assign the values to the variables
    this.roundCount = roundCount;
    this.topStrategy = new TopStrategy(playerChoice, oddCount, evenCount);
  }

  /**
   * Method to get the move of the AI
   *
   * @returns the move of the AI
   */
  @Override
  public int getMove() {
    AIStrategy strategy = randomStrategy;

    // If the round count is less than or equal to 3, return a random number between 0 and 5
    if (roundCount <= 3) {
      strategy = randomStrategy;
    } else {
      strategy = topStrategy;
    }

    // Return a random number between 0 and 5
    return strategy.execute();
  }
}
