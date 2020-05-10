package edu.duke.ece651.sallysstash;

import java.util.ArrayList;

//This class is used to control all the stacks of a player and conducting placehit and add a new stack
public class stack_control {
  public ArrayList<stack> stackArray;

  //Place a hit on the opposite's stack
  public void placehit(int alphabet, int number, ArrayList<stack> enemyStacks, board enemy_board,Character id) {

    for (stack enemy_stack : enemyStacks) {
      //If this is a hit
      if (enemy_stack.inside(alphabet, number)) {
        enemy_stack.hitArray.add(new hit(alphabet, number, enemy_stack.color));
        place_hit temp = new place_hit();
        temp.place_enemyhit(enemy_board, new hit(alphabet, number, enemy_stack.color));
        if (id != 'C') {
          System.out.println("------------------------------------------------\n");
          System.out.println("You found a Stack !!!\n");
          System.out.println("------------------------------------------------\n");
        }
        else {
          System.out.println("------------------------------------------------\n");
          System.out.println("The opponent found your stack!!!\n");
          System.out.println("------------------------------------------------\n");
        }
        return;
      }
    }
    //If this is a miss
    place_hit placer = new place_hit();
    placer.place_enemymiss(enemy_board, new hit(alphabet, number, null));
    if (id != 'C') {
      System.out.println("------------------------------------------------\n");
      System.out.println("You missed !!!\n");
      System.out.println("------------------------------------------------\n");
    }
        
  }
  //Adding a new stack for the current player
  public void addStack(int x, int y, Character color, int size, int direction) {
    stackArray.add(new stack(x, y, color, size, direction));
  }

  //Adding a new super or crazy stack for the current player
  public void addStrange(int x, int y, Character color, Character facing, Character shape) {
    stackArray.add(new stack(x, y, color, facing, shape));
  }

  public stack_control() {
    stackArray = new ArrayList<stack>();
  }
}
