package nz.ac.auckland.se281;

/** Class to define the human player. */
public class Human {
  // Variable to store the validity of the user input
  protected boolean valid = false;

  /**
   * Method to read the user input from the console.
   *
   * @returns the user input
   */
  public String play() {
    // Read the user input
    String input = Utils.scanner.nextLine();

    // Check if the user input is an integer
    while (!Utils.isInteger(input)) {
      input = Utils.scanner.nextLine();
    }

    // return the user input
    return input;
  }

  /**
   * Method to check if the user input is valid.
   *
   * @param input the user input
   * @returns true if the input is valid, false otherwise
   */
  public boolean isInputValid(String input) {
    // Convert the user input to an integer
    int inputInt = Integer.parseInt(input);

    // Check if the user input is between 0 and 5
    if (inputInt >= 0 && inputInt <= 5) {
      valid = true;
    }

    // return the validity of the input
    return valid;
  }
}
