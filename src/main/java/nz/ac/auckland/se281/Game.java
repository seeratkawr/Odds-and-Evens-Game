package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  private String[] options;
  private int round = 1;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    this.options = options;
    // the first element of options[0]; is the name of the player
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
  }

  public void play() {
    MessageCli.START_ROUND.printMessage(String.valueOf(round));
    round++;
    MessageCli.ASK_INPUT.printMessage();

    String numberFingers = Utils.scanner.nextLine();
    int numberFingersInt = Integer.parseInt(numberFingers);

    if (numberFingersInt < 0 || numberFingersInt > 5) {
      MessageCli.INVALID_INPUT.printMessage();
    } else {
      MessageCli.PRINT_INFO_HAND.printMessage(options[0], numberFingers);
    }

  }

  public void endGame() {}

  public void showStats() {}
}
