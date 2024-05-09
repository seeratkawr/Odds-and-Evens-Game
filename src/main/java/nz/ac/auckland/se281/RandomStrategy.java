package nz.ac.auckland.se281;

public class RandomStrategy implements AIStrategy {

  /** Method to execute the random strategy */
  @Override
  public int execute() {
    return Utils.getRandomNumberRange(0, 5);
  }

  /** Method to get the strategy name */
  @Override
  public String getStrategyName() {
    return "random";
  }
}
