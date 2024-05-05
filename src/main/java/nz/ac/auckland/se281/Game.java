package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

public class Game {
  private String[] options;
  private int round = 1;
  private String choice;
  private String difficulty;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    this.options = options;
    this.choice = choice.toString();
    this.difficulty = difficulty.toString();
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
  }

  public void play() {
    MessageCli.START_ROUND.printMessage(String.valueOf(round));
    round++;
    MessageCli.ASK_INPUT.printMessage();

    boolean isInputValid = false;
    String numberFingers;
    int numberFingersInt = 0;

    AIMethods ai = new AIMethods();
    ai.setPlayerChoice(choice);
    int aiFingers;
    int totalFingers;

    ai.resetCount();

    while (!isInputValid) {
      numberFingers = Utils.scanner.nextLine();

      try {
        numberFingersInt = Integer.parseInt(numberFingers);

        if (numberFingersInt >= 0 && numberFingersInt <= 5) {
          isInputValid = true;
        } else {
          MessageCli.INVALID_INPUT.printMessage();
        }

      } catch (NumberFormatException e) {
        MessageCli.INVALID_INPUT.printMessage();
      }
    }

    MessageCli.PRINT_INFO_HAND.printMessage(options[0], String.valueOf(numberFingersInt));
    ai.updatePreference(numberFingersInt);

    AI aiFactory = AIFactory.createAI(difficulty);
    aiFingers = aiFactory.play();

    MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", String.valueOf(aiFingers));

    totalFingers = numberFingersInt + aiFingers;

    if (Utils.isEven(totalFingers)) {
      if (choice.equals("EVEN")) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(
            String.valueOf(totalFingers), "EVEN", options[0]);
      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(
            String.valueOf(totalFingers), "EVEN", "HAL-9000");
      }
    } else if (Utils.isOdd(totalFingers)) {
      if (choice.equals("ODD")) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(
            String.valueOf(totalFingers), "ODD", options[0]);
      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(
            String.valueOf(totalFingers), "ODD", "HAL-9000");
      }
    }
  }

  public void endGame() {}

  public void showStats() {}
}
