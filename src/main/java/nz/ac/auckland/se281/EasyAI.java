package nz.ac.auckland.se281;

/** Class to define the easy AI. */
public class EasyAI implements AiImplement {
  private Strategy randomStrategy = new RandomStrategy();

  /**
   * Method to get the move of the AI.
   *
   * @returns the move of the AI
   */
  @Override
  public int play() {
    // Return a random number between 0 and 5
    return randomStrategy.execute();
  }
}
