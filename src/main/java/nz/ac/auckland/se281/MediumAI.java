package nz.ac.auckland.se281;

public class MediumAI implements AI {
  private int roundCount;
  private String playerInput;
  private String playerChoice;
  private int oddCount = 0;
  private int evenCount = 0;

  public MediumAI(int roundCount, String playerInput, String playerChoice) {
    this.roundCount = roundCount;
    this.playerInput = playerInput;
    this.playerChoice = playerChoice;

    if (Utils.isOdd(Integer.parseInt(playerInput))) {
      oddCount++;
    } else {
      evenCount++;
    }
  }

  @Override
  public int getMove() {
    int aiChoice = 0;

    if (roundCount <= 3) {
      aiChoice = Utils.getRandomNumberRange(0, 5);
    }

    if (oddCount > evenCount && playerChoice.equals("EVEN")) {
      aiChoice = Utils.getRandomEvenNumber();
    }

    if (evenCount > oddCount && playerChoice.equals("ODD")) {
      aiChoice = Utils.getRandomOddNumber();
    }

    if (oddCount == evenCount) {
      aiChoice = Utils.getRandomNumberRange(0, 5);
    }

    return aiChoice;
  }
}
