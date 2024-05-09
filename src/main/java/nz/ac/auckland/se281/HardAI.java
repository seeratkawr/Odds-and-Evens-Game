package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;

public class HardAI implements AI {
  // Variables to store the round count, player input, player choice, odd count, and even count
  private int roundCount;
  private String playerChoice;
  private String prevWinner;
  private int oddCount = 0;
  private int evenCount = 0;
  private List<String> aiMethod = new ArrayList<>();

  /**
   * Constructor for the MediumAI class
   *
   * @param roundCount round number
   * @param playerChoice Odd or Even
   * @param oddCount Number of odd human inputs
   * @param evenCount Number of even human inputs
   */
  public HardAI(
      int roundCount, String playerChoice, String prevWinner, int oddCount, int evenCount) {
    // Assign the values to the variables
    this.roundCount = roundCount;
    this.playerChoice = playerChoice;
    this.prevWinner = prevWinner;
    this.oddCount = oddCount;
    this.evenCount = evenCount;
  }

  private int top(int oddCount, int evenCount) {
    if (playerChoice.equals("ODD")) {
      if (oddCount > evenCount) {
        return Utils.getRandomOddNumber();
      } else if (evenCount > oddCount) {
        return Utils.getRandomEvenNumber();
      } else {
        return Utils.getRandomNumberRange(0, 5);
      }
    }

    if (playerChoice.equals("EVEN")) {
      if (oddCount > evenCount) {
        return Utils.getRandomEvenNumber();
      } else if (evenCount > oddCount) {
        return Utils.getRandomOddNumber();
      } else {
        return Utils.getRandomNumberRange(0, 5);
      }
    }

    return Utils.getRandomNumberRange(0, 5);
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
      aiMethod.add("random");
      return Utils.getRandomNumberRange(0, 5);
    }

    if (prevWinner.equals("AI")) {
      if (aiMethod.get(aiMethod.size() - 1).equals("top")) {
        aiMethod.add("top");
        return top(oddCount, evenCount);
      } else {
        aiMethod.add("random");
        return Utils.getRandomNumberRange(0, 5);
      }
    }

    return Utils.getRandomNumberRange(0, 5);
  }
}
