package nz.ac.auckland.se281;

public class MediumAI implements AI {
  // Variables to store the round count, player input, player choice, odd count, and even count
  private int roundCount;
  private String playerChoice;
  private int oddCount = 0;
  private int evenCount = 0;

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
    this.playerChoice = playerChoice;
    this.oddCount = oddCount;
    this.evenCount = evenCount;
  }

  /**
   * Method to get the move of the AI
   *
   * @returns the move of the AI
   */
  @Override
  public int getMove() {
    // If the round count is less than or equal to 3, return a random number between 0 and 5
    if (roundCount <= 3) {
      return Utils.getRandomNumberRange(0, 5);
    }

    // Outputs for if the player choice is odd
    if (playerChoice.equals("ODD")) {
      if (oddCount > evenCount) {
        return Utils.getRandomOddNumber();
      } else if (evenCount > oddCount) {
        return Utils.getRandomEvenNumber();
      } else {
        return Utils.getRandomNumberRange(0, 5);
      }
    }

    // Outputs for if the player choice is even
    if (playerChoice.equals("EVEN")) {
      if (oddCount > evenCount) {
        return Utils.getRandomEvenNumber();
      } else if (evenCount > oddCount) {
        return Utils.getRandomOddNumber();
      } else {
        return Utils.getRandomNumberRange(0, 5);
      }
    }

    // Return a random number between 0 and 5
    return Utils.getRandomNumberRange(0, 5);
  }
}
