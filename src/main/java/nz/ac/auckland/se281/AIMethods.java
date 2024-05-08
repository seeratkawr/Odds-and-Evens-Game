package nz.ac.auckland.se281;

public class AIMethods {
  private int oddCount = 0;
  private int evenCount = 0;
  private int roundCount = 1;
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
    roundCount = 1;
  }

  public void updatePreference(int playerFingers) {
    if (Utils.isOdd(playerFingers)) {
      oddCount++;
    } else {
      evenCount++;
    }
    roundCount++;
  }

  public int getRoundCount() {
    return roundCount;
  }

  public int getOddCount() {
    return oddCount;
  }

  public int getEvenCount() {
    return evenCount;
  }

  public int playMedium() {
    if (roundCount <= 3) {
      return playRandom(); // Call playRandom() only for the first three rounds
    } else {
      // Switch to "Top" strategy from the fourth round onwards
      if (oddCount > evenCount && playerChoice.equals("EVEN")) {
        // If more odd numbers have been played and player chose EVEN, AI chooses an even number
        AIChoice = Utils.getRandomEvenNumber();
      } else if (evenCount > oddCount && playerChoice.equals("ODD")) {
        // If more even numbers have been played and player chose ODD, AI chooses an odd number
        AIChoice = Utils.getRandomOddNumber();
      } else {
        // If counts are equal or player's choice doesn't match the count distribution, AI chooses
        // randomly
        AIChoice = Utils.getRandomNumberRange(0, 5);
      }
      return AIChoice;
    }
  }
}
