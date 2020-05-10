package edu.duke.ece651.sallysstash;

import java.util.*;

public class sonar {
  public static void scan(Scanner in, stack_control B_control, validation valid, Character id) {
    input_converter converter = new input_converter("A1");
    String input = new String();
    if (id != 'C') {
      //Reading from System.in
      //in = new Scanner(System.in);
      input = in.nextLine();
      converter = new input_converter(input);
    }
    // else {
    // converter = new input_converter(computer.generateX() + computer.generateY());
    // }
    while (!(converter.x >= 1 && converter.x <= 20 && converter.y >= 2 && converter.y <= 20)) {
      //If input in not valid, ask the user to reinput
      System.out.println("Invalid input, scanning center coordinate out of board, please input again\n");
      //in = new Scanner(System.in);
      input = in.nextLine();
      converter = new input_converter(input);
      if (!(converter.x >= 1 && converter.x <= 20 && converter.y >= 2 && converter.y <= 20)) {
        continue;
      }
    }
    //Input is valid, scann it.
    Hashtable<Character, Integer> map = new Hashtable<Character, Integer>();
    map.put('G', 0);
    map.put('P', 0);
    map.put('R', 0);
    map.put('B', 0);
    for (stack temp : B_control.stackArray) {
      if (temp.containSquare(new square(converter.x - 3, converter.y))) {
        map.put(temp.color, map.get(temp.color) + 1);
      }
      if (temp.containSquare(new square(converter.x - 2, converter.y))) {
        map.put(temp.color, map.get(temp.color) + 1);
      }
      if (temp.containSquare(new square(converter.x - 2, converter.y - 2))) {
        map.put(temp.color, map.get(temp.color) + 1);
      }
      if (temp.containSquare(new square(converter.x - 2, converter.y + 2))) {
        map.put(temp.color, map.get(temp.color) + 1);
      }
      if (temp.containSquare(new square(converter.x - 1, converter.y))) {
        map.put(temp.color, map.get(temp.color) + 1);
      }
      if (temp.containSquare(new square(converter.x - 1, converter.y - 2))) {
        map.put(temp.color, map.get(temp.color) + 1);
      }
      if (temp.containSquare(new square(converter.x - 1, converter.y + 2))) {
        map.put(temp.color, map.get(temp.color) + 1);
      }
      if (temp.containSquare(new square(converter.x - 1, converter.y - 4))) {
        map.put(temp.color, map.get(temp.color) + 1);
      }
      if (temp.containSquare(new square(converter.x - 1, converter.y + 4))) {
        map.put(temp.color, map.get(temp.color) + 1);
      }
      if (temp.containSquare(new square(converter.x, converter.y))) {
        map.put(temp.color, map.get(temp.color) + 1);
      }
      if (temp.containSquare(new square(converter.x, converter.y - 2))) {
        map.put(temp.color, map.get(temp.color) + 1);
      }
      if (temp.containSquare(new square(converter.x, converter.y + 2))) {
        map.put(temp.color, map.get(temp.color) + 1);
      }
      if (temp.containSquare(new square(converter.x, converter.y - 4))) {
        map.put(temp.color, map.get(temp.color) + 1);
      }
      if (temp.containSquare(new square(converter.x, converter.y + 4))) {
        map.put(temp.color, map.get(temp.color) + 1);
      }
      if (temp.containSquare(new square(converter.x, converter.y - 6))) {
        map.put(temp.color, map.get(temp.color) + 1);
      }
      if (temp.containSquare(new square(converter.x, converter.y + 6))) {
        map.put(temp.color, map.get(temp.color) + 1);
      }
      if (temp.containSquare(new square(converter.x + 1, converter.y))) {
        map.put(temp.color, map.get(temp.color) + 1);
      }
      if (temp.containSquare(new square(converter.x + 1, converter.y - 2))) {
        map.put(temp.color, map.get(temp.color) + 1);
      }
      if (temp.containSquare(new square(converter.x + 1, converter.y + 2))) {
        map.put(temp.color, map.get(temp.color) + 1);
      }
      if (temp.containSquare(new square(converter.x + 1, converter.y + 4))) {
        map.put(temp.color, map.get(temp.color) + 1);
      }
      if (temp.containSquare(new square(converter.x + 1, converter.y - 4))) {
        map.put(temp.color, map.get(temp.color) + 1);
      }
      if (temp.containSquare(new square(converter.x + 2, converter.y))) {
        map.put(temp.color, map.get(temp.color) + 1);
      }

      if (temp.containSquare(new square(converter.x + 2, converter.y - 2))) {
        map.put(temp.color, map.get(temp.color) + 1);
      }
      if (temp.containSquare(new square(converter.x + 2, converter.y + 2))) {
        map.put(temp.color, map.get(temp.color) + 1);
      }
      if (temp.containSquare(new square(converter.x + 3, converter.y))) {
        map.put(temp.color, map.get(temp.color) + 1);
      }
    }
    if (id != 'C') {
      System.out.println("----------------------------------------\nGreen stacks occupy " + map.get('G')
          + " square\nPurple stacks occupy " + map.get('P') + " square\nRed stacks occupy " + map.get('R')
          + " square\nBlue stacks occupy " + map.get('B') + " square\n--------------------------------------------\n");
    }
    else {
      System.out.println("The opponent used a special action\n");
    }
    }
}
