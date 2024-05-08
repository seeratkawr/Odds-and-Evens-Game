package nz.ac.auckland.se281;

public class EasyAI implements AI {

  @Override
  public int getMove() {
    return Utils.getRandomNumberRange(0, 5);
  }
}
