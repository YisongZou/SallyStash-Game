package edu.duke.ece651.sallysstash;

//Convert the input string into coordinates
public class input_converter {
  public int x;
  public int y;
  public int direction;
  public Character facing;
//Convert the input string into coordinates
  public input_converter(String input) {
    //Determine if the input is valid then convert it into coordinates of the baord
    if (input.length() == 2 || input.length() == 3) {
      //The first bit of input
      if (Character.isLetter(input.charAt(0))) {
        x = Character.toUpperCase(input.charAt(0)) - 'A' + 1;
      } else {
        System.out.println("Wrong Format of input");
      }
      //The second bit of input
      if (Character.isDigit(input.charAt(1))) {
        y = Integer.parseInt(String.valueOf(input.charAt(1))) * 2 + 2;
      } else {
        System.out.println("Wrong Format of input");
      }
      //The Third bit of input
      if (input.length() == 3) {
        if (Character.toUpperCase(input.charAt(2)) == 'V') {
          direction = 1;
        }
        if (Character.toUpperCase(input.charAt(2)) == 'H') {
          direction = 0;
        }
        if (Character.toUpperCase(input.charAt(2)) == 'U') {
          facing = 'U';
        }
        if (Character.toUpperCase(input.charAt(2)) == 'D') {
          facing = 'D';
        }
        if (Character.toUpperCase(input.charAt(2)) == 'L') {
          facing = 'L';
        }
        if (Character.toUpperCase(input.charAt(2)) == 'R') {
          facing = 'R';
        }
      }
    } else {
      System.out.println("Wrong Format of input");
    }
  }
}
