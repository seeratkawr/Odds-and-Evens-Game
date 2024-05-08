package nz.ac.auckland.se281;

public class MediumAI implements AI {
  private int roundCount;
  private String playerInput;
  private String playerChoice;
  private int oddCount = 0;
  private int evenCount = 0;

  public MediumAI(
      int roundCount, String playerInput, String playerChoice, int oddCount, int evenCount) {
    this.roundCount = roundCount;
    this.playerInput = playerInput;
    this.playerChoice = playerChoice;
    this.oddCount = oddCount;
    this.evenCount = evenCount;
  }

  @Override
  public int getMove() {
    if (Utils.isOdd(Integer.parseInt(playerInput))) {
      oddCount++;
    } else {
      evenCount++;
    }

    if (roundCount <= 3) {
      return Utils.getRandomNumberRange(0, 5);
    }

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
}
