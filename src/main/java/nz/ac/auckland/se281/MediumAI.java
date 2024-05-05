package nz.ac.auckland.se281;

public class MediumAI implements AI {

  AIMethods ai = new AIMethods();
  int mediumAI = ai.playMedium();

  @Override
  public int play() {
    return mediumAI;
  }
}
