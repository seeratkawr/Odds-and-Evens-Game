package nz.ac.auckland.se281;

/** Interface to define the AI strategy. */
public interface Strategy {
  // Method to execute the strategy
  int execute();

  // Method to get the strategy name
  String getStrategyName();
}
