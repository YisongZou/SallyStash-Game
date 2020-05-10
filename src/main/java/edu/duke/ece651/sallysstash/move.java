package edu.duke.ece651.sallysstash;
import java.util.Scanner;

//This class is used to reading from System.in and move the selected stack frome user
public class move {
  public static void moveStack(Scanner in, stack_control A_control, validation valid,Character id) {
    input_converter converter = new input_converter("A1");
    String input = new String();
    if (id != 'C') {
      System.out.println("please select a coordinate in a stack that you want to move\n");
      //Reading from System.in
      //      in = new Scanner(System.in);
      input = in.nextLine();
      converter = new input_converter(input);
    }
    else {
      converter = new input_converter(computer.generateX() + computer.generateY());
    }
    stack this_stack = choosemove.choose(new square(converter.x, converter.y), A_control.stackArray);
    if (id != 'C') {
      System.out.println("please select a coordinate and the orientation of the move\n");
      //in = new Scanner(System.in);
      input = in.nextLine();
      converter = new input_converter(input);
    }
    else {
      if (this_stack.facing != null) {
        converter = new input_converter(computer.generateX() + computer.generateY() + computer.generateStrange());
      }
      else {
        converter = new input_converter(computer.generateX() + computer.generateY() + computer.generateNormal());
      }
    }
    if (this_stack.facing != null) {
      while (!valid.validStrange(converter.x, converter.y, converter.facing, this_stack.shape, A_control.stackArray)) {
        if (id != 'C') {
          //If input in not valid, ask the user to reinput
          System.out.println("Invalid input, input out of board or collides with another stack, please input again\n");
          //  in = new Scanner(System.in);
          input = in.nextLine();
          converter = new input_converter(input);
        }
        else {
          converter = new input_converter(computer.generateX() + computer.generateY() + computer.generateStrange());
        }
        if (!valid.validStrange(converter.x, converter.y, converter.facing, this_stack.shape, A_control.stackArray)) {
          continue;
        }
      }
      //Input is valid,remove the stack and esstablish a new one according to the new location
      this_stack.flaghit();
      stack stack_after = new stack(converter.x, converter.y, this_stack.color, converter.facing, this_stack.shape);
      for (hit temp : this_stack.hitArray) {
        stack_after.addMovedhit(temp);
      }
      for (int i = 0; i < A_control.stackArray.size(); i++) {
        if (this_stack.x == A_control.stackArray.get(i).x && this_stack.y == A_control.stackArray.get(i).y) {
          A_control.stackArray.remove(i);
        }
      }
      A_control.stackArray.add(stack_after);
      if (id == 'C') {
        System.out.println("The opponent used a special action\n");
      }
    } else {
      while (!valid.validStack(converter.x, converter.y, this_stack.size, converter.direction, A_control.stackArray)) {
        if (id != 'C') {
          //If input in not valid, ask the user to reinput
          System.out.println("Invalid input, input out of board or collides with another stack, please input again\n");
          //in = new Scanner(System.in);
          input = in.nextLine();
          converter = new input_converter(input);
        }
        else {
          converter = new input_converter(computer.generateX() + computer.generateY() + computer.generateNormal());
        }
        if (!valid.validStack(converter.x, converter.y, this_stack.size, converter.direction, A_control.stackArray)) {
          continue;
        }
      }
      //Input is valid,remove the stack and esstablish a new one according to the new location
      this_stack.flaghit();
      stack stack_after = new stack(converter.x, converter.y, this_stack.color, this_stack.size, converter.direction);
      for (hit temp : this_stack.hitArray) {
        stack_after.addMovedhit(temp);
      }
      for (int i = 0; i < A_control.stackArray.size(); i++) {
        if (this_stack.x == A_control.stackArray.get(i).x && this_stack.y == A_control.stackArray.get(i).y) {
          A_control.stackArray.remove(i);
        }
      }
      A_control.stackArray.add(stack_after);
      if (id == 'C') {
        System.out.println("The opponent used a special action\n");
      }
    }
  }
}
