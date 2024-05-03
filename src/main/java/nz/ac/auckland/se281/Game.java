package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  private String[] options; // options array to hold the game options
  private int round = 1; // round number
  private String choice;

  /**
   * This method is used to start a new game, with the specified difficulty, choice and options.
   *
   * @param difficulty The difficulty level of the game.
   * @param choice The players choice.
   * @param options The options array, the first element should be the name of the player.
   * @throws NullPointerException if the options array is null.
   */
  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // set the options array
    this.options = options;
    this.choice = choice.toString();
    // the first element of options[0]; is the name of the player
    // print the welcome message
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
  }

  /**
   * This method initiates a new round of the game by prompting the player to input the number of
   * fingers. Prints relevant messages to guide the player through the game.
   *
   * @throws NumberFormatException if the player inputs a value that cannot be parsed to an integer.
   * @throws ArrayIndexOutOfBoundsException if the player inputs a value that is not within the
   *     range of 0 to 5.
   */
  public void play() {
    // print the start round message
    MessageCli.START_ROUND.printMessage(String.valueOf(round));
    round++; // increment the round number
    // ask the player to input the number of fingers
    MessageCli.ASK_INPUT.printMessage();

    Boolean isInputValid = false; // flag to check if the input is valid
    String numberFingers; // the number of fingers inputted by the player
    int numberFingersInt = 0; // the number of fingers inputted by the player as an integer

    AI ai = new AI();
    int aiFingers;
    int totalFingers;

    // loop until the player inputs a valid number of fingers
    while (!isInputValid) {
      // get the number of fingers inputted by the player
      numberFingers = Utils.scanner.nextLine();

      // check if the input is a number
      try {
        numberFingersInt = Integer.parseInt(numberFingers);

        // check if the input is within the range of 0 to 5 (inclusive)
        if (numberFingersInt >= 0 && numberFingersInt <= 5) {
          isInputValid = true;
        } else {
          // print an error message if the input is not within the range of 0 to 5 (inclusive)
          MessageCli.INVALID_INPUT.printMessage();
        }

        // print an error message if the input is not a number (NumberFormatException)
      } catch (NumberFormatException e) {
        MessageCli.INVALID_INPUT.printMessage();
      }
    }

    // print the player's hand information
    MessageCli.PRINT_INFO_HAND.printMessage(options[0], String.valueOf(numberFingersInt));

    // generate a random number of fingers for the AI
    aiFingers = ai.playRandom();

    // print the AI's hand information
    MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", String.valueOf(aiFingers));

    // calculate the total number of fingers
    totalFingers = numberFingersInt + aiFingers;

    // check if the total number of fingers is even or odd
    if (Utils.isEven(totalFingers)) {
      if (choice.equals("EVEN")) {
        // print the outcome of the round where the player wins
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(
            String.valueOf(totalFingers), "EVEN", options[0]);
      } else {
        // print the outcome of the round where the AI wins
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(
            String.valueOf(totalFingers), "EVEN", "HAL-9000");
      }
    } else if (Utils.isOdd(totalFingers)) {
      if (choice.equals("ODD")) {
        // print the outcome of the round where the player wins
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(
            String.valueOf(totalFingers), "ODD", options[0]);
      } else {
        // print the outcome of the round where the AI wins
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(
            String.valueOf(totalFingers), "ODD", "HAL-9000");
      }
    }
  }

  public void endGame() {}

  public void showStats() {}
}
