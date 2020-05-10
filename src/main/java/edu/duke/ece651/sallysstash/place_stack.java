package edu.duke.ece651.sallysstash;

//This class is used to place the stacks on the blank board before printing
public class place_stack {
  public void place(board newBoard, stack mystack) {
    if (mystack.facing != null) {
      for (square temp : mystack.squareArray) {
        newBoard.boardArrayList.get(temp.x).set(temp.y, mystack.color);
      }
    }
else{
    if (mystack.direction == 0) {//It is horizontal
      for (int i = mystack.y; i < mystack.y + mystack.size * 2 - 1; i += 2) {
        newBoard.boardArrayList.get(mystack.x).set(i, mystack.color);
      }
    } else if (mystack.direction == 1) {//Vertical
      for (int i = mystack.x; i < mystack.x + mystack.size; i++) {
        newBoard.boardArrayList.get(i).set(mystack.y, mystack.color);
      }
    }
  }
  }
}
