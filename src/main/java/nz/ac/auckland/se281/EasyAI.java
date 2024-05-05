package nz.ac.auckland.se281;

public class EasyAI implements AI {
  AIMethods ai = new AIMethods();
  int easyAI = ai.playRandom();

  @Override
  public int play() {
    return easyAI;
  }
}
