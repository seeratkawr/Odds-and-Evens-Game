package nz.ac.auckland.se281;

public class Human {
  protected boolean valid = false;

  public String play() {
    String input = Utils.scanner.nextLine();

    while (!Utils.isInteger(input)) {
      input = Utils.scanner.nextLine();
    }

    return input;
  }

  public boolean isInputValid(String input) {
    int inputInt = Integer.parseInt(input);

    if (inputInt >= 0 && inputInt <= 5) {
      valid = true;
    }

    return valid;
  }
}
