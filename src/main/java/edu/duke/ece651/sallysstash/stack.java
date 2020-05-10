package edu.duke.ece651.sallysstash;

import java.util.ArrayList;

//This class is used to represent a stack
public class stack {
  public int x;
  public int y;
  public Character color;
  public int size;
  public int direction;
  public Character facing;//The direction for the super and crazy stacks
  public Character shape;//used to determine if it is a Superstack or a Crazystack

  //The hitted positions
  public ArrayList<hit> hitArray;
  //The owned squares
  public ArrayList<square> squareArray;

  //Decide if a position is inside the stack
  public boolean inside(int X, int Y) {
    if (facing == null) {
      if (direction == 0) {
        if (X == x && Y >= y && Y <= y + size * 2 - 2) {
          return true;
        }
        return false;
      }
      if (direction == 1) {
        if (Y == y && X >= x && X <= x + size - 1) {
          return true;
        }
        return false;
      }
    } else {
      if (this.containSquare(new square(X, Y))) {
        return true;
      }
      return false;
    }
    return true;
  }

  //Default Constructor
  public stack() {
    hitArray = new ArrayList<hit>();
    squareArray = new ArrayList<square>();
    //All the contained squares
    if (direction == 0) {
      for (int i = y; i < y + size * 2 - 1; i += 2) {
        squareArray.add(new square(x, i));
      }
    }
    if (direction == 1) {
      for (int j = x; j < x + size; j += 1) {
        squareArray.add(new square(j, y));
      }
    }
  }

  //Constructor for normal rectangle stack
  public stack(int my_x, int my_y, Character my_color, int my_size, int my_direction) {
    x = my_x;
    y = my_y;
    color = my_color;
    size = my_size;
    direction = my_direction;
    hitArray = new ArrayList<hit>();
    squareArray = new ArrayList<square>();
    //All the contained squares
    if (direction == 0) {
      for (int i = y; i < y + size * 2 - 1; i += 2) {
        squareArray.add(new square(x, i));
      }
    }
    if (direction == 1) {
      for (int j = x; j < x + size; j += 1) {
        squareArray.add(new square(j, y));
      }
    }
  }

  //Constructor for super and crazy stacks
  public stack(int my_x, int my_y, Character my_color, Character my_facing, Character my_shape) {
    x = my_x;
    y = my_y;
    color = my_color;

    facing = my_facing;
    shape = my_shape;

    hitArray = new ArrayList<hit>();
    squareArray = new ArrayList<square>();
    //All the contained squares
    //Superstack
    if (my_shape == 'S') {
      //Up
      if (my_facing == 'U') {
        squareArray.add(new square(x, y));
        squareArray.add(new square(x + 1, y));
        squareArray.add(new square(x + 1, y - 2));
        squareArray.add(new square(x + 1, y + 2));
      }
      //Down
      if (my_facing == 'D') {
        squareArray.add(new square(x, y));
        squareArray.add(new square(x, y + 2));
        squareArray.add(new square(x, y + 4));
        squareArray.add(new square(x + 1, y + 2));
      }
      //Left
      if (my_facing == 'L') {
        squareArray.add(new square(x, y));
        squareArray.add(new square(x + 1, y - 2));
        squareArray.add(new square(x + 1, y));
        squareArray.add(new square(x + 2, y));
      }
      //Right
      if (my_facing == 'R') {
        squareArray.add(new square(x, y));
        squareArray.add(new square(x + 1, y));
        squareArray.add(new square(x + 2, y));
        squareArray.add(new square(x + 1, y + 2));
      }
      //Crazy stack
    } else if (my_shape == 'C') {
      //Up
      if (my_facing == 'U') {
        squareArray.add(new square(x, y));
        squareArray.add(new square(x + 1, y));
        squareArray.add(new square(x + 2, y));
        squareArray.add(new square(x + 2, y + 2));
        squareArray.add(new square(x + 3, y + 2));
        squareArray.add(new square(x + 4, y + 2));
      }
      //Down
      if (my_facing == 'D') {
        squareArray.add(new square(x, y));
        squareArray.add(new square(x + 1, y));
        squareArray.add(new square(x + 2, y));
        squareArray.add(new square(x + 2, y - 2));
        squareArray.add(new square(x + 3, y - 2));
        squareArray.add(new square(x + 4, y - 2));
      }
      //Left
      if (my_facing == 'L') {
        squareArray.add(new square(x, y));
        squareArray.add(new square(x, y + 2));
        squareArray.add(new square(x, y + 4));
        squareArray.add(new square(x + 1, y + 4));
        squareArray.add(new square(x + 1, y + 6));
        squareArray.add(new square(x + 1, y + 8));
      }
      //Right
      if (my_facing == 'R') {
        squareArray.add(new square(x, y));
        squareArray.add(new square(x, y + 2));
        squareArray.add(new square(x, y + 4));
        squareArray.add(new square(x - 1, y + 4));
        squareArray.add(new square(x - 1, y + 6));
        squareArray.add(new square(x - 1, y + 8));
      }
    }
  }

  //Determine if a stack contains a square
  public boolean containSquare(square my_square) {
    for (square temp : squareArray) {
      if (temp.x == my_square.x && temp.y == my_square.y) {
        return true;
      }
    }
    return false;
  }

  //Determine if two stack overlaps
  public boolean overlap(stack my_stack) {
    for (square temp : squareArray) {
      if (my_stack.containSquare(temp)) {
        return true;
      }
    }
    return false;
  }

  //Add the moved hit to the stack
  public void addMovedhit(hit my_hit) {
    if (shape != null) {
      if (shape == 'S') {
        //Up
        if (facing == 'U') {
          if (my_hit.flag == 1) {
            this.hitArray.add(new hit(x, y, color));
          }
          if (my_hit.flag == 3) {
            this.hitArray.add(new hit(x + 1, y, color));
          }
          if (my_hit.flag == 2) {
            this.hitArray.add(new hit(x + 1, y - 2, color));
          }
          if (my_hit.flag == 4) {
            this.hitArray.add(new hit(x + 1, y + 2, color));
          }
        }
        //Down
        if (facing == 'D') {
          if (my_hit.flag == 4) {
            this.hitArray.add(new hit(x, y, color));
          }
          if (my_hit.flag == 3) {
            this.hitArray.add(new hit(x, y + 2, color));
          }
          if (my_hit.flag == 2) {
            this.hitArray.add(new hit(x, y + 4, color));
          }
          if (my_hit.flag == 1) {
            this.hitArray.add(new hit(x + 1, y + 2, color));
          }
        }
        //Left
        if (facing == 'L') {
          if (my_hit.flag == 4) {
            this.hitArray.add(new hit(x, y, color));
          }
          if (my_hit.flag == 3) {
            this.hitArray.add(new hit(x + 1, y, color));
          }
          if (my_hit.flag == 2) {
            this.hitArray.add(new hit(x + 2, y, color));
          }
          if (my_hit.flag == 1) {
            this.hitArray.add(new hit(x + 1, y - 2, color));
          }
        }
        //Right
        if (facing == 'R') {
          if (my_hit.flag == 1) {
            this.hitArray.add(new hit(x + 1, y + 2, color));
          }
          if (my_hit.flag == 3) {
            this.hitArray.add(new hit(x + 1, y, color));
          }
          if (my_hit.flag == 2) {
            this.hitArray.add(new hit(x, y, color));
          }
          if (my_hit.flag == 4) {
            this.hitArray.add(new hit(x + 2, y, color));
          }
        }
        //Crazy stack
      } else if (shape == 'C') {
        //Up
        if (facing == 'U') {
          if (my_hit.flag == 1) {
            this.hitArray.add(new hit(x, y, color));
          }
          if (my_hit.flag == 2) {
            this.hitArray.add(new hit(x + 1, y, color));
          }
          if (my_hit.flag == 3) {
            this.hitArray.add(new hit(x + 2, y, color));
          }
          if (my_hit.flag == 4) {
            this.hitArray.add(new hit(x + 2, y + 2, color));
          }
          if (my_hit.flag == 5) {
            this.hitArray.add(new hit(x + 3, y + 2, color));
          }
          if (my_hit.flag == 6) {
            this.hitArray.add(new hit(x + 4, y + 2, color));
          }
        }
        //Down
        if (facing == 'D') {
          if (my_hit.flag == 1) {
            this.hitArray.add(new hit(x + 4, y - 2, color));
          }
          if (my_hit.flag == 2) {
            this.hitArray.add(new hit(x + 3, y - 2, color));
          }
          if (my_hit.flag == 3) {
            this.hitArray.add(new hit(x + 2, y - 2, color));
          }
          if (my_hit.flag == 4) {
            this.hitArray.add(new hit(x + 2, y, color));
          }
          if (my_hit.flag == 5) {
            this.hitArray.add(new hit(x + 1, y, color));
          }
          if (my_hit.flag == 6) {
            this.hitArray.add(new hit(x, y, color));
          }
        }
        //Left
        if (facing == 'L') {
          if (my_hit.flag == 1) {
            this.hitArray.add(new hit(x + 1, y + 8, color));
          }
          if (my_hit.flag == 2) {
            this.hitArray.add(new hit(x + 1, y + 6, color));
          }
          if (my_hit.flag == 3) {
            this.hitArray.add(new hit(x + 1, y + 4, color));
          }
          if (my_hit.flag == 4) {
            this.hitArray.add(new hit(x, y + 4, color));
          }
          if (my_hit.flag == 5) {
            this.hitArray.add(new hit(x, y + 2, color));
          }
          if (my_hit.flag == 6) {
            this.hitArray.add(new hit(x, y, color));
          }
        }
        //Right
        if (facing == 'R') {
          if (my_hit.flag == 6) {
            this.hitArray.add(new hit(x - 1, y + 8, color));
          }
          if (my_hit.flag == 5) {
            this.hitArray.add(new hit(x - 1, y + 6, color));
          }
          if (my_hit.flag == 4) {
            this.hitArray.add(new hit(x - 1, y + 4, color));
          }
          if (my_hit.flag == 3) {
            this.hitArray.add(new hit(x, y + 4, color));
          }
          if (my_hit.flag == 2) {
            this.hitArray.add(new hit(x, y + 2, color));
          }
          if (my_hit.flag == 1) {
            this.hitArray.add(new hit(x, y, color));
          }
        }
      }
    } else {
      if (this.direction == 0) {
        this.hitArray.add(new hit(this.x, this.y + (my_hit.flag - 1) * 2, color));
      } else {
        this.hitArray.add(new hit(this.x + my_hit.flag - 1, this.y, color));
      }
    }
  }

  //Add a flag to each hits in the hitlist for us to figure out the hits after remove
  public void flaghit() {
    for(hit temp: this.hitArray){
      if (shape != null) {
        if (shape == 'S') {
          //Up
          if (facing == 'U') {
            if (temp.x == x && temp.y == y) {
              temp.flag = 1;
            }
            if (temp.x == x + 1 && temp.y == y) {
              temp.flag = 3;
            }
            if (temp.x == x + 1 && temp.y == y - 2) {
              temp.flag = 2;
            }
            if (temp.x == x + 1 && temp.y == y + 2) {
              temp.flag = 4;
            }
          }
          //Down
          if (facing == 'D') {
            if (temp.x == x && temp.y == y) {
              temp.flag = 4;
            }
            if (temp.x == x && temp.y == y + 2) {
              temp.flag = 3;
            }
            if (temp.x == x && temp.y == y + 4) {
              temp.flag = 2;
            }
            if (temp.x == x + 1 && temp.y == y + 2) {
              temp.flag = 1;
            }
          }
          //Left
          if (facing == 'L') {
            if (temp.x == x && temp.y == y) {
              temp.flag = 4;
            }
            if (temp.x == x + 1 && temp.y == y) {
              temp.flag = 3;
            }
            if (temp.x == x + 2 && temp.y == y) {
              temp.flag = 2;
            }
            if (temp.x == x + 1 && temp.y == y - 2) {
              temp.flag = 1;
            }
          }
          //Right
          if (facing == 'R') {
            if (temp.x == x + 1 && temp.y == y + 2) {
              temp.flag = 1;
            }
            if (temp.x == x + 1 && temp.y == y) {
              temp.flag = 3;
            }
            if (temp.x == x && temp.y == y) {
              temp.flag = 2;
            }
            if (temp.x == x + 2 && temp.y == y) {
              temp.flag = 4;
            }
          }
          //Crazy stack
        } else if (shape == 'C') {
          //Up
          if (facing == 'U') {
            if (temp.x == x && temp.y == y) {
              temp.flag = 1;
            }
            if (temp.x == x + 1 && temp.y == y) {
              temp.flag = 2;
            }
            if (temp.x == x + 2 && temp.y == y) {
              temp.flag = 3;
            }
            if (temp.x == x + 2 && temp.y == y + 2) {
              temp.flag = 4;
            }
            if (temp.x == x + 3 && temp.y == y + 2) {
              temp.flag = 5;
            }
            if (temp.x == x + 4 && temp.y == y + 2) {
              temp.flag = 6;
            }
          }
          //Down
          if (facing == 'D') {
            if (temp.x == x + 4 && temp.y == y - 2) {
              temp.flag = 1;
            }
            if (temp.x == x + 3 && temp.y == y - 2) {
              temp.flag = 2;
            }
            if (temp.x == x + 2 && temp.y == y - 2) {
              temp.flag = 3;
            }
            if (temp.x == x + 2 && temp.y == y) {
              temp.flag = 4;
            }
            if (temp.x == x + 1 && temp.y == y) {
              temp.flag = 5;
            }
            if (temp.x == x && temp.y == y) {
              temp.flag = 6;
            }
          }
          //Left
          if (facing == 'L') {
            if (temp.x == x + 1 && temp.y == y + 8) {
              temp.flag = 1;
            }
            if (temp.x == x + 1 && temp.y == y + 6) {
              temp.flag = 2;
            }
            if (temp.x == x + 1 && temp.y == y + 4) {
              temp.flag = 3;
            }
            if (temp.x == x && temp.y == y + 4) {
              temp.flag = 4;
            }
            if (temp.x == x && temp.y == y + 2) {
              temp.flag = 5;
            }
            if (temp.x == x && temp.y == y) {
              temp.flag = 6;
            }
          }
          //Right
          if (facing == 'R') {
            if (temp.x == x - 1 && temp.y == y + 8) {
              temp.flag = 6;
            }
            if (temp.x == x - 1 && temp.y == y + 6) {
              temp.flag = 5;
            }
            if (temp.x == x - 1 && temp.y == y + 4) {
              temp.flag = 4;
            }
            if (temp.x == x && temp.y == y + 4) {
              temp.flag = 3;
            }
            if (temp.x == x && temp.y == y + 2) {
              temp.flag = 2;
            }
            if (temp.x == x && temp.y == y) {
              temp.flag = 1;
            }
          }
        }
      }
      else {
        if (this.direction == 0) {
          temp.flag = (temp.y - this.y)/2 + 1;
        }
        else {
          temp.flag = temp.x - this.x + 1;
        }
      }
  }
  }
}



