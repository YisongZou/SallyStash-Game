package edu.duke.ece651.sallysstash;

import java.util.ArrayList;

//This class is used to decide whether a game ends
public class gameover {
  public boolean endgame(ArrayList<stack> my_stack) {
    int counter = 0;
    //Remove the repeat hits in each stack
    for (stack temp1 : my_stack) {
      for (int i = 0; i < temp1.hitArray.size(); i++) {
        for (int j = i + 1; j < temp1.hitArray.size(); j++) {
          if (temp1.hitArray.get(i).x == temp1.hitArray.get(j).x && temp1.hitArray.get(i).y == temp1.hitArray.get(j).y) {
            temp1.hitArray.remove(j);
          }
        }
      }
    }
    //Iterate over all the stacks and calculate the whole hits, if it equals 37, end the game 
    for (stack temp : my_stack) {
      counter += temp.hitArray.size();
    }
    if (counter == 43) {
      return true;
    }
    return false;
  }
}
