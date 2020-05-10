package edu.duke.ece651.sallysstash;

import java.util.ArrayList;

public class choosemove {
  public static stack choose(square my_square, ArrayList<stack> my_stacks){
    stack ans = new stack();
    for (stack temp : my_stacks) {
      if (temp.containSquare(my_square)) {
        ans = temp;
        break;
      }
    }
    return ans;
  }
}
