package nz.ac.auckland.se281;

public class RandomStrategy implements AIStrategy {

  @Override
  public int execute() {
    return Utils.getRandomNumberRange(0, 5);
  }

  @Override
  public String getStrategyName() {
    return "random";
  }
}
