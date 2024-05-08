package nz.ac.auckland.se281;

public class Human {
  public String play() {
    String input = Utils.scanner.nextLine();

    while (!Utils.isInteger(input)) {
      MessageCli.INVALID_INPUT.printMessage();
      input = Utils.scanner.nextLine();
    }

    return input;
  }
}
