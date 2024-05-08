package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

public class Game {
  private String[] options;
  private int round = 1;
  private String choice;
  private String difficulty;
  private AIMethods ai = new AIMethods();

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    this.options = options;
    this.choice = choice.toString();
    this.difficulty = difficulty.toString();
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    ai.resetCount();
  }

  public void play() {
    Human human = new Human();

    MessageCli.START_ROUND.printMessage(Integer.toString(round));
    round++;
    MessageCli.ASK_INPUT.printMessage();

    String humanPlay = human.play();

    while (!human.isInputValid(humanPlay)) {
      MessageCli.INVALID_INPUT.printMessage();
      humanPlay = human.play();
    }

    MessageCli.PRINT_INFO_HAND.printMessage(options[0], humanPlay);
  }

  public void endGame() {}

  public void showStats() {}
}
