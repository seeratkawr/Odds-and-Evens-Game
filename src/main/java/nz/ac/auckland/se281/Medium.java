package nz.ac.auckland.se281;

/** Class to define the medium AI. */
public class Medium implements AiImplement {
  // Variables to store the round count, player input, player choice, odd count, and even count
  private final int roundCount;
  private final String playerChoice;
  private final int oddCount;
  private final int evenCount;
  private Strategy strategy;

  /**
   * Constructor for the MediumAI class.
   *
   * @param roundCount round number
   * @param playerChoice Odd or Even
   * @param oddCount Number of odd human inputs
   * @param evenCount Number of even human inputs
   */
  public Medium(int roundCount, String playerChoice, int oddCount, int evenCount) {
    // Assign the values to the variables
    this.roundCount = roundCount;
    this.playerChoice = playerChoice;
    this.oddCount = oddCount;
    this.evenCount = evenCount;
  }

  /**
   * Method to set the strategy of the AI.
   *
   * @param strategy the strategy to set
   */
  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  /**
   * Method to get the move of the AI.
   *
   * @returns the move of the AI
   */
  @Override
  public int play() {
    // If the round count is less than or equal to 3, use the random strategy
    if (roundCount <= 3) {
      setStrategy(new RandomStrategy());
    } else {
      setStrategy(new TopStrategy(playerChoice, oddCount, evenCount));
    }

    // Return the result of the strategy's execution
    return strategy.execute();
  }
}
