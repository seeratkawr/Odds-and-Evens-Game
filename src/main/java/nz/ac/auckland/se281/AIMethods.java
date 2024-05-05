package nz.ac.auckland.se281;

public class AIMethods {
  private int oddCount = 0;
  private int evenCount = 0;
  private int roundCount = 0;
  private String playerChoice;
  private int AIChoice;

  public AIMethods() {
    resetCount();
  }

  public void setPlayerChoice(String playerChoice) {
    this.playerChoice = playerChoice;
  }

  public int playRandom() {
    return Utils.getRandomNumberRange(0, 5);
  }

  public void resetCount() {
    oddCount = 0;
    evenCount = 0;
    roundCount = 0;
  }

  public void updatePreference(int playerFingers) {
    if (Utils.isOdd(playerFingers)) {
      oddCount++;
    } else {
      evenCount++;
    }
    roundCount++;
  }

  public int playMedium() {
    if (roundCount <= 3) {
      return playRandom();
    } else if ((oddCount > evenCount) && playerChoice.equals("ODD")) {
      AIChoice = Utils.getRandomOddNumber();
    } else if ((evenCount > oddCount) && playerChoice.equals("EVEN")) {
      AIChoice = Utils.getRandomOddNumber();
    } else {
      AIChoice = playRandom();
    }

    return AIChoice;
  }
}
