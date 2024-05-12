package nz.ac.auckland.se281;

/** Class to define the hard AI for the game. */
public class HardAI implements AI {
  // Variables to store the round count, player input, player choice, odd count, even Count, and AI
  // method
  private final int roundCount;
  private final String prevWinner;
  private Strategy randomStrategy = new RandomStrategy();
  private Strategy topStrategy;
  private String lastStrategyName;

  /**
   * Constructor for the HardAI class.
   *
   * @param roundCount round number
   * @param playerChoice Odd or Even
   * @param prevWinner Previous winner (AI or human)
   * @param oddCount Number of odd human inputs
   * @param evenCount Number of even human inputs
   */
  public HardAI(
      int roundCount, String playerChoice, String prevWinner, int oddCount, int evenCount) {
    // Assign the values to the variables
    this.roundCount = roundCount;
    this.prevWinner = prevWinner;
    this.topStrategy = new TopStrategy(playerChoice, oddCount, evenCount);
  }

  /**
   * Method to get the move of the AI.
   *
   * @returns the move of the AI
   */
  @Override
  public int play() {
    Strategy strategy = randomStrategy;

    // If the round count is less than or equal to 3, return a random number between 0 and 5
    if (roundCount <= 3) {
      strategy = randomStrategy;
    }

    // If the previous winner is AI, return the last used AI method
    if (prevWinner.equals("AI")) {
      if (lastStrategyName != null && lastStrategyName.equals("random")) {
        strategy = randomStrategy;
      } else {
        strategy = topStrategy;
      }
    }

    // If the previous winner is human, change the AI method and return the move
    if (prevWinner.equals("human")) {
      if (lastStrategyName != null && lastStrategyName.equals("random")) {
        strategy = topStrategy;
      } else {
        strategy = randomStrategy;
      }
    }

    // Store the last used AI method
    lastStrategyName = strategy.getStrategyName();

    // If prevWinner is not "AI" or "human", return a random number
    return strategy.execute();
  }
}
