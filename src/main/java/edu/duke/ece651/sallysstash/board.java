package edu.duke.ece651.sallysstash;

import java.util.ArrayList;

//This class stores the blank baord for use before printing a board
public class board {
  //Arraylist to store the contents of a blank board
  public ArrayList<ArrayList<Character>> boardArrayList;

  public board() {
    this.boardArrayList = new ArrayList<ArrayList<Character>>();
    ArrayList<String> tempList = new ArrayList<String>();
    //initializing the board
    tempList.add("  0|1|2|3|4|5|6|7|8|9  \n");
    tempList.add("A  | | | | | | | | |  A\n");
    tempList.add("B  | | | | | | | | |  B\n");
    tempList.add("C  | | | | | | | | |  C\n");
    tempList.add("D  | | | | | | | | |  D\n");
    tempList.add("E  | | | | | | | | |  E\n");
    tempList.add("F  | | | | | | | | |  F\n");
    tempList.add("G  | | | | | | | | |  G\n");
    tempList.add("H  | | | | | | | | |  H\n");
    tempList.add("I  | | | | | | | | |  I\n");
    tempList.add("J  | | | | | | | | |  J\n");
    tempList.add("K  | | | | | | | | |  K\n");
    tempList.add("L  | | | | | | | | |  L\n");
    tempList.add("M  | | | | | | | | |  M\n");
    tempList.add("N  | | | | | | | | |  N\n");
    tempList.add("O  | | | | | | | | |  O\n");
    tempList.add("P  | | | | | | | | |  P\n");
    tempList.add("Q  | | | | | | | | |  Q\n");
    tempList.add("R  | | | | | | | | |  R\n");
    tempList.add("S  | | | | | | | | |  S\n");
    tempList.add("T  | | | | | | | | |  T\n");
    tempList.add("  0|1|2|3|4|5|6|7|8|9  \n");

    //Add the contents finally to the Arraylist
    for (String temp : tempList) {
      ArrayList<Character> tempArray = new ArrayList<Character>();
      for (char tempChar : temp.toCharArray()) {
        tempArray.add(tempChar);
      }
      boardArrayList.add(tempArray);
    }

  }
}
