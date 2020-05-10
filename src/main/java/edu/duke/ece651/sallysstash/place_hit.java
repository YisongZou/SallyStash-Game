package edu.duke.ece651.sallysstash;
//This class will be responsible for drawing hits on the board before frinting a board
public class place_hit {
  //place a hit on player's own board with '*'
  public void place(board my_board, hit my_hit) {
    my_board.boardArrayList.get(my_hit.x).set(my_hit.y, '*');
  }

  //place a hit on the enemy board showed on the right side with color
  public void place_enemyhit(board enemy_board, hit my_hit) {
    enemy_board.boardArrayList.get(my_hit.x).set(my_hit.y, my_hit.color);
  }
  //place a miss on the enemy board showed on the right side with 'X'
  public void place_enemymiss(board enemy_board, hit my_hit) {
    enemy_board.boardArrayList.get(my_hit.x).set(my_hit.y, 'X');
  }
}
