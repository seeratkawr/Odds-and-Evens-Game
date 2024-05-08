package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

public class Game {
  private String[] options;
  private int round = 1;
  private String choice;
  private String difficulty;
  private AI ai = new EasyAI();

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    this.options = options;
    this.choice = choice.toString();
    this.difficulty = difficulty.toString();
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    round = 1;
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

    if (difficulty.equals("MEDIUM")) {
      ai = new MediumAI(round, humanPlay, choice);
    }

    String aiPlay = String.valueOf(ai.getMove());
    MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", aiPlay);

    int sum = Integer.parseInt(humanPlay) + Integer.parseInt(aiPlay);

    String result = sum % 2 == 0 ? "EVEN" : "ODD";
    if (result == choice) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(sum), result, options[0]);
    } else {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(sum), result, "HAL-9000");
    }
  }

  public void endGame() {}

  public void showStats() {}
}
