package edu.duke.ece651.sallysstash;

import java.util.ArrayList;
import java.util.Scanner;

//The class that contains the main function and also responsible for printing the results
public class print {
  //Print the current user board with the stacks, hits on it 
  public void printboard(ArrayList<stack> stackArrayList) {
    board mine = new board();
    place_stack stackPlacer = new place_stack();
    place_hit hitPlacer = new place_hit();
    for (stack my_stack : stackArrayList) {
      //place the stacks onto the blank board before printing
      stackPlacer.place(mine, my_stack);
      for (hit my_hit : my_stack.hitArray) {
        //place the hits onto the board before printing
        hitPlacer.place(mine, my_hit);
      }
    }
    //Using this string for print the player's own board
    String result = new String();
    for (ArrayList<Character> row : mine.boardArrayList) {
      for (Character square : row) {
        result += square;
      }
    }
    System.out.println(result);
  }

  //Print the current user board and enemy board with the stacks, hits and misses on it 
  public void printtwoboards(board enemy, ArrayList<stack> stackArrayList) {
    board mine = new board();
    place_stack stackPlacer = new place_stack();
    place_hit hitPlacer = new place_hit();
    for (stack my_stack : stackArrayList) {
      //place the stacks onto the blank board before printing
      stackPlacer.place(mine, my_stack);
      for (hit my_hit : my_stack.hitArray) {
        //place the hits onto the board before printing
        hitPlacer.place(mine, my_hit);
      }
    }

    //Using the string to concatenate the two boares side by side
    String result = new String();
    int i = 0;
    for (ArrayList<Character> row : mine.boardArrayList) {
      for (Character square : row) {
        result += square;
      }
      result = result.substring(0, result.length() - 1);
      result += "                  ";
      for (Character enemySquare : enemy.boardArrayList.get(i)) {
        result += enemySquare;
      }
      i += 1;
    }
    System.out.println(result);
  }

  //The main function for this game
  public static void main(String[] args) {
    //Used to validate the user input
    validation valid = new validation();
    //used to manipulate the stacks a player owns
    stack_control A_control = new stack_control();
    //The enemy baord of A
    board A_enemy = new board();

    stack_control B_control = new stack_control();
    //The enemy board of B
    board B_enemy = new board();
    //print object for printing the baords
    print my_print = new print();
    //Determine if A or B is a computer, 'C' represents it is a computer
    Character A_id = ' ';
    Character B_id = ' ';
    //Choose computer or player
    System.out.println("Please choose the identity for A, 'C' or'c' for computer, other input for human\n");
    Scanner in = new Scanner(System.in);
    String input = in.nextLine();
    if (input.length() == 1) {
      A_id = Character.toUpperCase(input.charAt(0));
    } else {
      A_id = 'H';
    }
    System.out.println("Please choose the identity for B, 'C' or'c' for computer, other input for human\n");
    //in = new Scanner(System.in);
    input = in.nextLine();
    if (input.length() == 1) {
      B_id = Character.toUpperCase(input.charAt(0));
    } else {
      B_id = 'H';
    }
    //Placing stacks begins
    if (A_id != 'C') {
      my_print.printboard(A_control.stackArray);
      System.out.println(
          "Player A, you are going place Sally’s stash on the board. Make sure Player B isn’t\nlooking! For each stack, type the coordinate of the upper left side of the stash,\nfollowed by either H (for horizontal) or V (for vertical). For example, M4H would\nplace a stack horizontally starting at M4 and going to the right. You have\n2 Green stacks that are 1x2\n3 Purple stacks that are 1x3\n3 Red Superstacks\n3 Blue Crazystacks\nThe Red Superstacks and Blue Crazystacks have four different orientations – Up (U), Right (R), Down (D), and left (L).In other words, a Superstack starting at A1 that’s up would be A1U, and a Crazystack starting at I3 that’s Left, would be I3L.");
    }
    //A begins to choose the stacks
    //////////////////////////////////////////////////////////////////////////////////
    if (A_id != 'C') {
      //      in = new Scanner(System.in);
      System.out.println("Player A, where do you want to place the first Green stack?");
    }
    Choose_stack choser = new Choose_stack();
    Choose_strange choseStrange = new Choose_strange();
    //Used to get the input and place the stack
    choser.choose(in, A_control, valid, 'G', 2, A_id);
    //////////////////////////////////////////////////////////////////////////////////////////
    if (A_id != 'C') {
      my_print.printboard(A_control.stackArray);
      System.out.println("Player A, where do you want to place the second Green stack?");
    }
    choser.choose(in, A_control, valid, 'G', 2, A_id);
    ////////////////////////////////////////////////////////////////////////////////////////////
    if (A_id != 'C') {
      my_print.printboard(A_control.stackArray);
      System.out.println("Player A, where do you want to place the first Purple stack?");
    }
    choser.choose(in, A_control, valid, 'P', 3, A_id);
    ////////////////////////////////////////////////////////////////////////////////////////////
    if (A_id != 'C') {
      my_print.printboard(A_control.stackArray);
      System.out.println("Player A, where do you want to place the second Purple stack?");
    }
    choser.choose(in, A_control, valid, 'P', 3, A_id);
    ////////////////////////////////////////////////////////////////////////////////////////////
    if (A_id != 'C') {
      my_print.printboard(A_control.stackArray);
      System.out.println("Player A, where do you want to place the third Purple stack?");
    }
    choser.choose(in, A_control, valid, 'P', 3, A_id);
    ////////////////////////////////////////////////////////////////////////////////////////////
    if (A_id != 'C') {
      my_print.printboard(A_control.stackArray);
      System.out.println("Player A, where do you want to place the first Red Superstack?");
    }
    choseStrange.choose(in, A_control, valid, 'S', 'R', A_id);
    ////////////////////////////////////////////////////////////////////////////////////////////
    if (A_id != 'C') {
      my_print.printboard(A_control.stackArray);
      System.out.println("Player A, where do you want to place the second Red Superstack?");
    }
    choseStrange.choose(in, A_control, valid, 'S', 'R', A_id);
    ////////////////////////////////////////////////////////////////////////////////////////////
    if (A_id != 'C') {
      my_print.printboard(A_control.stackArray);
      System.out.println("Player A, where do you want to place the third Red Superstack?");
    }
    choseStrange.choose(in, A_control, valid, 'S', 'R', A_id);
    ////////////////////////////////////////////////////////////////////////////////////////////
    if (A_id != 'C') {
      my_print.printboard(A_control.stackArray);
      System.out.println("Player A, where do you want to place the first Blue Crazystack?");
    }
    choseStrange.choose(in, A_control, valid, 'C', 'B', A_id);
    ////////////////////////////////////////////////////////////////////////////////////////////
    if (A_id != 'C') {
      my_print.printboard(A_control.stackArray);
      System.out.println("Player A, where do you want to place the second Blue Crazystack?");
    }
    choseStrange.choose(in, A_control, valid, 'C', 'B', A_id);
    ///////////////////////////////////////////////////////////////////////////////////////////
    if (A_id != 'C') {
      my_print.printboard(A_control.stackArray);
      System.out.println("Player A, where do you want to place the third Blue Crazystack?");
    }
    choseStrange.choose(in, A_control, valid, 'C', 'B', A_id);
    ///////////////////////////////////////////////////////////////////////////////////////////
    //IT IS B'S TURN TO PLACE STACKS
    ///////////////////////////////////////////////////////////////////////////////////////////
    if (B_id != 'C') {
      my_print.printboard(B_control.stackArray);
      System.out.println(
          "Player B, you are going place Sally’s stash on the board. Make sure Player A isn’t\nlooking! For each stack, type the coordinate of the upper left side of the stash,\nfollowed by either H (for horizontal) or V (for vertical). For example, M4H would\nplace a stack horizontally starting at M4 and going to the right. You have\n2 Green stacks that are 1x2\n3 Purple stacks that are 1x3\n3 Red Superstacks\n3 Blue Crazystacks\nThe Red Superstacks and Blue Crazystacks have four different orientations – Up (U), Right (R), Down (D), and left (L).In other words, a Superstack starting at A1 that’s up would be A1U, and a Crazystack starting at I3 that’s Left, would be I3L.");
      System.out.println("Player B, where do you want to place the first Green stack?");
    }
    choser.choose(in, B_control, valid, 'G', 2, B_id);
    ////////////////////////////////////////////////////////////////////////////////////////////
    if (B_id != 'C') {
      my_print.printboard(B_control.stackArray);
      System.out.println("Player B, where do you want to place the second Green stack?");
    }
    choser.choose(in, B_control, valid, 'G', 2, B_id);
    ///////////////////////////////////////////////////////////////////////////////////////////
    if (B_id != 'C') {
      my_print.printboard(B_control.stackArray);
      System.out.println("Player B, where do you want to place the first Purple stack?");
    }
    choser.choose(in, B_control, valid, 'P', 3, B_id);
    ///////////////////////////////////////////////////////////////////////////////////////////
    if (B_id != 'C') {
      my_print.printboard(B_control.stackArray);
      System.out.println("Player B, where do you want to place the second Purple stack?");
    }
    choser.choose(in, B_control, valid, 'P', 3, B_id);
    ///////////////////////////////////////////////////////////////////////////////////////////
    if (B_id != 'C') {
      my_print.printboard(B_control.stackArray);
      System.out.println("Player B, where do you want to place the third Purple stack?");
    }
    choser.choose(in, B_control, valid, 'P', 3, B_id);
    ///////////////////////////////////////////////////////////////////////////////////////////
    if (B_id != 'C') {
      my_print.printboard(B_control.stackArray);
      System.out.println("Player B, where do you want to place the first Red Superstack?");
    }
    choseStrange.choose(in, B_control, valid, 'S', 'R', B_id);
    ///////////////////////////////////////////////////////////////////////////////////////////
    if (B_id != 'C') {
      my_print.printboard(B_control.stackArray);
      System.out.println("Player B, where do you want to place the second Red Superstack?");
    }
    choseStrange.choose(in, B_control, valid, 'S', 'R', B_id);
    ///////////////////////////////////////////////////////////////////////////////////////////
    if (B_id != 'C') {
      my_print.printboard(B_control.stackArray);
      System.out.println("Player B, where do you want to place the third Red Superstack?");
    }
    choseStrange.choose(in, B_control, valid, 'S', 'R', B_id);
    ///////////////////////////////////////////////////////////////////////////////////////////
    if (B_id != 'C') {
      my_print.printboard(B_control.stackArray);
      System.out.println("Player B, where do you want to place the first Blue Crazystack?");
    }
    choseStrange.choose(in, B_control, valid, 'C', 'B', B_id);
    ///////////////////////////////////////////////////////////////////////////////////////////
    if (B_id != 'C') {
      my_print.printboard(B_control.stackArray);
      System.out.println("Player B, where do you want to place the second Blue Crazystack?");
    }
    choseStrange.choose(in, B_control, valid, 'C', 'B', B_id);
    ////////////////////////////////////////////////////////////////////////////////////
    if (B_id != 'C') {
      my_print.printboard(B_control.stackArray);
      System.out.println("Player B, where do you want to place the third Blue Crazystack?");
    }
    choseStrange.choose(in, B_control, valid, 'C', 'B', B_id);
    ////////////////////////////////////////////////////////////////////////////////////

    //Game Starts
    System.out.println("--------------------Game Starts----------------\n");
    //Used to determine if the game is over
    gameover end = new gameover();
    //Used for a user to choose a square to dig
    dig digger = new dig();
    int A_moves = 3;
    int A_sonar = 3;
    int B_moves = 3;
    int B_sonar = 3;
    //Iterate until teh game ends
    while (true) {
      if (A_id != 'C') {
        System.out.println("Player A’s turn:\n     Your tree                                Player B’s tree");
        my_print.printtwoboards(A_enemy, A_control.stackArray);
        System.out.println(
            "------------------------------------------\nPossible actions for Player A:\n\nD Dig in a square\nM Move a stack to another square ("
                + A_moves + " remaining)\nS Sonar scan (" + A_sonar
                + " remaining)\n\nPlayer A, what would you like to do?\n------------------------------------------\n");
        // in = new Scanner(System.in);
        input = in.nextLine();
      } else {
        input = computer.generateOption();
      }
      char temp;
      if (input.length() >= 1) {
        temp = Character.toUpperCase(input.charAt(0));
      } else {
        temp = ' ';
      }
      //option is valid or not
      while (!(temp == 'D' || temp == 'S' || temp == 'M') || input.length() != 1 || (temp == 'M' && A_moves == 0)
          || (temp == 'S' && A_sonar == 0)) {
        if ((temp == 'M' && A_moves == 0) || (temp == 'S' && A_sonar == 0)) {
          if (A_id != 'C') {
            System.out.println("You do not have a move or sonar token left!!\n");
          }
        }
        if (A_id != 'C') {
          System.out.println("Please select a choice from D, S and M");
        }
        if (A_id != 'C') {
          //in = new Scanner(System.in);
          input = in.nextLine();
          temp = Character.toUpperCase(input.charAt(0));
        } else {
          if (A_moves == 0 && A_sonar != 0) {
            temp = 'S';
          } else if (A_moves != 0 && A_sonar == 0) {
            temp = 'M';
          } else {
            temp = 'D';
          }
        }
      }
      switch (temp) {
      case 'D':
        if (A_id != 'C') {
          System.out.println("Please select a coordinate to dig");
        }
        //Dig the place that the player chooses
        digger.digthis(in, valid, B_control, A_control, A_enemy, A_id);
        break;
      case 'M':
        move.moveStack(in, A_control, valid, A_id);
        A_moves--;
        break;
      case 'S':
        if (A_id != 'C') {
          System.out.println("Please select a coordinate as the center for the sonar");
        }
        sonar.scan(in, B_control, valid, A_id);
        A_sonar--;
        break;
      default:
        break;
      }
      //Determine if A wins
      if (end.endgame(B_control.stackArray)) {
        System.out.println("Game results:\n");
        System.out.println("A's boards:\n");
        my_print.printtwoboards(A_enemy, A_control.stackArray);
        System.out.println("B's boards:\n");
        my_print.printtwoboards(B_enemy, B_control.stackArray);
        System.out.println("The above are the game results!\n");
        System.out.println("A wins the game!\n");
        break;
      }
      if (A_id != 'C') {
        System.out.println("Press any key to move on to the next player\n");
        //in = new Scanner(System.in);
        input = in.nextLine();
      }

      if (B_id != 'C') {
        System.out.println("Player B’s turn:\n     Your tree                                     Player A’s tree");
        my_print.printtwoboards(B_enemy, B_control.stackArray);
        System.out.println(
            "------------------------------------------\nPossible actions for Player B:\n\nD Dig in a square\nM Move a stack to another square ("
                + B_moves + " remaining)\nS Sonar scan (" + B_sonar
                + " remaining)\n\nPlayer B, what would you like to do?\n------------------------------------------\n");
        //in = new Scanner(System.in);
        input = in.nextLine();
      } else {
        input = computer.generateOption();
      }
      if (input.length() >= 1) {
        temp = Character.toUpperCase(input.charAt(0));
      } else {
        temp = ' ';
      }
      //Option is valid or not
      while (!(temp == 'D' || temp == 'S' || temp == 'M') || input.length() != 1 || (temp == 'M' && B_moves == 0)
          || (temp == 'S' && B_sonar == 0)) {
        if ((temp == 'M' && B_moves == 0) || (temp == 'S' && B_sonar == 0)) {
          if (B_id != 'C') {
            System.out.println("You do not have a move or sonar token left!!\n");
          }
        }
        if (B_id != 'C') {
          System.out.println("Please select a choice from D, S and M");
        }
        if (B_id != 'C') {
          //          in = new Scanner(System.in);
          input = in.nextLine();
          temp = Character.toUpperCase(input.charAt(0));
        } else {
          if (B_moves == 0 && B_sonar != 0) {
            temp = 'S';
          } else if (B_moves != 0 && B_sonar == 0) {
            temp = 'M';
          } else {
            temp = 'D';
          }
        }
      }

      switch (temp) {
      case 'D':
        if (B_id != 'C') {
          //Dig the place that the player chooses
          System.out.println("Please select a coordinate to dig");
        }
        digger.digthis(in, valid, A_control, B_control, B_enemy, B_id);
        break;
      case 'M':
        move.moveStack(in, B_control, valid, B_id);
        B_moves--;
        break;
      case 'S':
        if (B_id != 'C') {
          System.out.println("Please select a coordinate as the center for the sonar");
        }
        sonar.scan(in, A_control, valid, B_id);
        B_sonar--;
        break;
      default:
        break;
      }
      //Determine if B wins
      if (end.endgame(A_control.stackArray)) {
        System.out.println("Game results:\n");
        System.out.println("B's boards:\n");
        my_print.printtwoboards(B_enemy, B_control.stackArray);
        System.out.println("A's boards:\n");
        my_print.printtwoboards(A_enemy, A_control.stackArray);
        System.out.println("The above are the game results!\n");
        System.out.println("B wins the game!\n");
        break;
      }
      if (B_id != 'C') {
        System.out.println("Press any key to move on to the next player\n");
        //in = new Scanner(System.in);
        input = in.nextLine();
      }
    }
    in.close();
  }
}
