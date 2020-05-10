package edu.duke.ece651.sallysstash;

import java.util.Scanner;

//Dig a place chosen by a player
public class dig {
  public void digthis(Scanner in,validation valid, stack_control B_control,stack_control A_control,board A_enemy,Character id) {
    input_converter converter = new input_converter("A1");
    String input = new String();
    //If it is a computer
    if (id != 'C') {
      //in = new Scanner(System.in);
      input = in.nextLine();
      converter = new input_converter(input);
    }
    else {
      converter = new input_converter(computer.generateX() + computer.generateY());
    }
    while (!valid.validHit(converter.x, converter.y)) {
      if (id != 'C') {
        //The dig is not valid
        System.out.println("Invalid dig, coordinate out of board, please guess again!\n");
        //in = new Scanner(System.in);
        input = in.nextLine();
        converter = new input_converter(input);
      }
      //      else {
      //converter = new input_converter(computer.generateX() + computer.generateY());
      //}
      if (!valid.validHit(converter.x, converter.y)) {
        continue;
      }
    }
    //The dig is valid, place the dig
    A_control.placehit(converter.x, converter.y, B_control.stackArray, A_enemy, id);
  }
}
