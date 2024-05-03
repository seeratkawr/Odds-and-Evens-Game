package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  private String[] options; // options array to hold the player name
  private int round = 1; // round number

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // set the options array
    this.options = options;
    // the first element of options[0]; is the name of the player
    // print the welcome message
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
  }

  public void play() {
    // print the start round message
    MessageCli.START_ROUND.printMessage(String.valueOf(round));
    round++; // increment the round number
    // ask the player to input the number of fingers
    MessageCli.ASK_INPUT.printMessage();

    // read the number of fingers from the player
    String numberFingers = Utils.scanner.nextLine();
    // convert the number of fingers to an integer
    int numberFingersInt = Integer.parseInt(numberFingers);

    // check if the number of fingers is between 0 and 5
    // if not, ask the player to input the number of fingers again
    while (numberFingersInt < 0 || numberFingersInt > 5) {
      MessageCli.INVALID_INPUT.printMessage();
      numberFingers = Utils.scanner.nextLine();
      numberFingersInt = Integer.parseInt(numberFingers);
    }

    // print the player's hand information
    MessageCli.PRINT_INFO_HAND.printMessage(options[0], numberFingers);
  }

  public void endGame() {}

  public void showStats() {}
}
