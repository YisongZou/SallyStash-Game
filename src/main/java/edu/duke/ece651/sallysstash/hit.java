package edu.duke.ece651.sallysstash;

//The class hit is used to store the hitted positions for a stack
public class hit {
  public int x;
  public int y;
  public int flag;//To determine the position of a given hit in the stack
  public Character color;

  //Constructor
  public hit(int X, int Y, Character my_color) {
    x = X;
    y = Y;
    color = my_color;
  }

}
