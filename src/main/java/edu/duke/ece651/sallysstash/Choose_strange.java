package edu.duke.ece651.sallysstash;
import java.util.Scanner;

//This class is used to reading from System.in and placing the given valid stacks into the user's stack array
public class Choose_strange{
  public void choose(Scanner in,stack_control A_control, validation valid, char shape, Character color,Character id) {
    input_converter converter = new input_converter("A3u");
    String input = new String();
    if (id != 'C') {
      //Reading from System.in
      //      in = new Scanner(System.in);
      input = in.nextLine();
      converter = new input_converter(input);
    }
    else {
      converter = new input_converter(computer.generateX()+computer.generateY()+computer.generateStrange());
    }
    while (!valid.validStrange(converter.x, converter.y, converter.facing, shape, A_control.stackArray)) {
      if (id != 'C') {
        //If input in not valid, ask the user to reinput
        System.out.println("Invalid input, input out of board or collides with another stack, please input again\n");
        //        in = new Scanner(System.in);
        input = in.nextLine();
        converter = new input_converter(input);
      }
      else {
        converter = new input_converter(computer.generateX()+computer.generateY()+computer.generateStrange());
      }
      if (!valid.validStrange(converter.x, converter.y, converter.facing,shape, A_control.stackArray)) {
        continue;
      }
    }
    //Input is valid, add the stack into the stack array
    A_control.addStrange(converter.x, converter.y, color, converter.facing, shape);
  }
}
