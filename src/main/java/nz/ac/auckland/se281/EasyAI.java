package nz.ac.auckland.se281;

public class EasyAI implements AI {
  /**
   * Method to get the move of the AI
   *
   * @returns the move of the AI
   */
  @Override
  public int getMove() {
    // Return a random number between 0 and 5
    return Utils.getRandomNumberRange(0, 5);
  }
}
