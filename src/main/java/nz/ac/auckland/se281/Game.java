package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** Class to represent the game. */
public class Game {
  // Variables to store the options, round number, player choice, difficulty, odd count, even count,
  // and AI
  private String[] options;
  private int round = 1;
  private String choice;
  private String difficulty;
  private int oddCount = 0;
  private int evenCount = 0;
  private AiImplement ai;
  private String winner = "";
  private String result;
  private int humanWins = 0;
  private int aiWins = 0;

  /**
   * Method to start a new game.
   *
   * @param difficulty Difficulty of the game
   * @param choice Odd or Even
   * @param options Player name
   */
  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // Assign the values to the variables
    this.options = options;
    this.choice = choice.toString();
    this.difficulty = difficulty.toString();

    // Print the welcome message
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);

    // Reset the round number, odd count, and even count
    round = 1;
    oddCount = 0;
    evenCount = 0;
    winner = "";
  }

  /** Method to play a round of the game. */
  public void play() {
    // Create a new Human object
    Human human = new Human();
    String humanPlay;
    String aiPlay;
    int sum;

    // Check if the player has started the game
    if (difficulty == null && choice == null && options == null) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    // Print the start round message
    MessageCli.START_ROUND.printMessage(Integer.toString(round));
    round++; // Increment the round number
    // Print the ask input message
    MessageCli.ASK_INPUT.printMessage();

    // Get the user input
    humanPlay = human.play();

    // Check if the user input is valid
    while (!human.isInputValid(humanPlay)) {
      MessageCli.INVALID_INPUT.printMessage();
      humanPlay = human.play();
    }

    MessageCli.PRINT_INFO_HAND.printMessage(options[0], humanPlay);

    updateCounters(humanPlay);

    createAi();

    // Get the AI move and print it
    aiPlay = String.valueOf(ai.play());
    MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", aiPlay);

    // Calculate the sum of the user input and AI input
    sum = Integer.parseInt(humanPlay) + Integer.parseInt(aiPlay);

    // Get the outcome of the round
    result = sum % 2 == 0 ? "EVEN" : "ODD";
    // Print the outcome of the round
    if (result.equals(choice)) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(sum), result, options[0]);
      // Set the winner to human
      winner = "human";
    } else {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(sum), result, "HAL-9000");
      // Set the winner to AI
      winner = "AI";
    }

    // Update the game stats
    updateStats(result);
  }

  /**
   * Method to update the odd and even count.
   *
   * @param humanPlay User input
   */
  private void updateCounters(String humanPlay) {
    if (Utils.isOdd(Integer.parseInt(humanPlay))) {
      oddCount++;
    } else {
      evenCount++;
    }
  }

  /** Method to create a new AI object. */
  private void createAi() {
    ai = Factory.getAi(difficulty, round, choice, winner, oddCount, evenCount);
  }

  /**
   * Method to update the game stats.
   *
   * @param result Outcome of the round
   */
  private void updateStats(String result) {
    if (result.equals(choice)) {
      humanWins++;
    } else {
      aiWins++;
    }
  }

  /** Method to end the game. */
  public void endGame() {
    // Check if the player has started the game
    if (difficulty == null && choice == null && options == null) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    // Print the stats at the end of the game
    showStats();

    // Print the end game message (winner or tie)
    if (humanWins > aiWins) {
      MessageCli.PRINT_END_GAME.printMessage(options[0]);
    } else if (aiWins > humanWins) {
      MessageCli.PRINT_END_GAME.printMessage("HAL-9000");
    } else if (aiWins == humanWins) {
      MessageCli.PRINT_END_GAME_TIE.printMessage();
    }

    // Reset the game
    difficulty = null;
    choice = null;
    options = null;
  }

  /** Method to show the game stats. */
  public void showStats() {
    // Check if the player has started the game
    if (difficulty == null && choice == null && options == null) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    // Print the game stats
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        options[0], Integer.toString(humanWins), Integer.toString(aiWins));
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        "HAL-9000", Integer.toString(aiWins), Integer.toString(humanWins));
  }
}
