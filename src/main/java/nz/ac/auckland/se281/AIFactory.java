package nz.ac.auckland.se281;

public class AIFactory {
  public static AI createAI(String difficulty) {
    switch (difficulty) {
      case "EASY":
        return new EasyAI();
      case "MEDIUM":
        return new MediumAI();
      default:
        throw new IllegalArgumentException("Invalid difficulty level");
    }
  }
}
