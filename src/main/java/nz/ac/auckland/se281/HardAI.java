package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;

public class HardAI implements AI {
  // Variables to store the round count, player input, player choice, odd count, even Count, and AI
  // method
  private int roundCount;
  private String playerChoice;
  private String prevWinner;
  private int oddCount = 0;
  private int evenCount = 0;
  private List<String> aiMethod = new ArrayList<>();

  /**
   * Constructor for the HardAI class
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
    this.playerChoice = playerChoice;
    this.prevWinner = prevWinner;
    this.oddCount = oddCount;
    this.evenCount = evenCount;
  }

  /**
   * Method to get the move of the AI using the Top method
   *
   * @returns the move of the AI
   */
  private int top() {
    // Add the AI method to the list
    aiMethod.add("top");

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

    // Return a random number between 0 and 5 if the player choice is not odd or even
    return Utils.getRandomNumberRange(0, 5);
  }

  /**
   * Method to get the move of the AI using the Random method
   *
   * @returns the move of the AI
   */
  private int random() {
    // Add the AI method to the list
    aiMethod.add("random");

    // Return a random number between 0 and 5
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
      return random();
    }

    // If the previous winner is AI, return the last used AI method
    if (prevWinner.equals("AI")) {
      if (aiMethod.size() > 0 && aiMethod.get(aiMethod.size() - 1).equals("random")) {
        return random();
      } else {
        return top();
      }
    }

    // If the previous winner is human, change the AI method and return the move
    if (prevWinner.equals("human")) {
      if (aiMethod.size() > 0 && aiMethod.get(aiMethod.size() - 1).equals("random")) {
        return top();
      } else {
        return random();
      }
    }

    // If prevWinner is not "AI" or "human", return a random number
    return random();
  }
}
