package nz.ac.auckland.se281;

/** Class to define the hard AI for the game. */
public class Hard implements AiImplement {
  // Variables to store the round count, player input, player choice, odd count, even Count, and AI
  // method
  private final int roundCount;
  private final String playerChoice;
  private final String prevWinner;
  private final int oddCount;
  private final int evenCount;
  private Strategy strategy;
  private Strategy lastStrategy;

  /**
   * Constructor for the HardAI class.
   *
   * @param roundCount round number
   * @param playerChoice Odd or Even
   * @param prevWinner Previous winner (AI or human)
   * @param oddCount Number of odd human inputs
   * @param evenCount Number of even human inputs
   */
  public Hard(int roundCount, String playerChoice, String prevWinner, int oddCount, int evenCount) {
    // Assign the values to the variables
    this.roundCount = roundCount;
    this.playerChoice = playerChoice;
    this.prevWinner = prevWinner;
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
    // If the round count is less than or equal to 3, return a random number between 0 and 5
    if (roundCount <= 3) {
      setStrategy(new RandomStrategy());
      // If the previous winner is AI, return the last used AI method
    } else if (prevWinner.equals("AI")) {
      if (lastStrategy instanceof RandomStrategy) {
        setStrategy(new RandomStrategy());
      } else {
        setStrategy(new TopStrategy(playerChoice, oddCount, evenCount));
      }
      // If the previous winner is human, change the AI method and return the move
    } else if (prevWinner.equals("human")) {
      if (lastStrategy instanceof RandomStrategy) {
        setStrategy(new TopStrategy(playerChoice, oddCount, evenCount));
      } else {
        setStrategy(new RandomStrategy());
      }
    }

    // Store the last used AI method
    lastStrategy = strategy;

    // If prevWinner is not "AI" or "human", return a random number
    return strategy.execute();
  }
}
