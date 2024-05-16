package nz.ac.auckland.se281;

/** Class to create the AI based on the difficulty. */
public class Factory {
  /**
   * Method to get the AI based on the difficulty.
   *
   * @param difficulty Difficulty of the AI
   * @param roundCount Round number
   * @param playerChoice Odd or Even
   * @param aiWins true if the AI wins, false otherwise
   * @param oddCount Number of odd human inputs
   * @param evenCount Number of even human inputs
   * @return the AI
   */
  public static Ai getAi(
      String difficulty,
      int roundCount,
      String playerChoice,
      boolean aiWins,
      int oddCount,
      int evenCount) {
    // Return the AI based on the difficulty
    switch (difficulty) {
      case "EASY":
        return new Easy();
      case "MEDIUM":
        return new Medium(roundCount, playerChoice, oddCount, evenCount);
      case "HARD":
        return new Hard(roundCount, playerChoice, aiWins, oddCount, evenCount);
      default:
        return null;
    }
  }
}
