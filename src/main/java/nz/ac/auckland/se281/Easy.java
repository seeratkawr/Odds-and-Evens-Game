package nz.ac.auckland.se281;

/** Class to define the easy AI. */
public class Easy implements Ai {
  // Variable to store the strategy of the AI
  private Strategy strategy;

  /** Constructor for the EasyAI class. */
  public Easy() {
    this.strategy = new RandomStrategy();
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
    // Return a random number between 0 and 5
    return strategy.execute();
  }
}
