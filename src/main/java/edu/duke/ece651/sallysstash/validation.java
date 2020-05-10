package edu.duke.ece651.sallysstash;

import java.util.ArrayList;

//Detedmine if the stack or the hits chosed by the player is valid
public class validation {
  //Detedmine if the stack chosed by the player is valid
  public boolean validStack(int x, int y, int size, int direction, ArrayList<stack> my_stacks) {
    boolean overlap = true;
    stack my_stack = new stack(x, y, null, size, direction);
    for (stack temp : my_stacks) {
      if (temp.overlap(my_stack)) {
        //The new stack overlaps with a old one
        return false;
      }
    }
    overlap = false;
    boolean valid = false;
    //Determine if the new stack is out of bound of the board
    if (direction == 0) {//It is horizontal
      if (x >= 1 && x <= 20 && y + size * 2 - 2 <= 20 && y >= 2) {
        valid = true;
      } else {
        valid = false;
      }
    } else if (direction == 1) {//Vertical
      if (y >= 2 && y <= 20 && x + size <= 21 && x >= 1) {
        valid = true;
      } else {
        valid = false;
      }
    }
    return (!overlap) && valid;
  }

  //Detedmine if the spuer or crazy stack chosed by the player is valid
  public boolean validStrange(int x, int y, Character facing, Character shape, ArrayList<stack> my_stacks) {
    if (facing == null || shape == null) {
      return false;
    }
    boolean overlap = true;
    stack my_stack = new stack(x, y, null, facing, shape);
    for (stack temp : my_stacks) {
      if (temp.overlap(my_stack)) {
        //The new stack overlaps with a old one
        return false;
      }
    }
    overlap = false;
    boolean valid = false;
    //Determine if the new super stack is out of bound of the board
    if (shape == 'S') {
      if (facing == 'U') {
        if(1 <= x && x <= 19 && 4 <= y && y <=18){
          valid = true;
        }
        else{
          valid = false;
        }
      }
      if (facing == 'D') {
        if(1<=x && x <= 19 && 2 <= y && y <= 16){
          valid = true;
        }
        else{
          valid = false;
        }
      }
      if (facing == 'R') {
        if(1<= x && x <= 18 && 2 <= y && y <= 18){
          valid = true;
        }
        else{
          valid = false;
        }
      }
      if (facing == 'L') {
        if(1 <= x && x <= 18 && 4 <= y && y <= 20){
          valid = true;
        }
        else{
          valid = false;
        }
      }
    }
    //Determine if the new crazy stack is out of board
    else if(shape == 'C'){
      if (facing == 'U') {
        if(1 <= x && x <= 16 && 2 <= y && y <= 18){
          valid = true;
        }
        else{
          valid = false;
        }
      }
      if (facing == 'D') {
        if(1 <= x && x <= 16 && 4 <= y && y <= 20){
          valid = true;
        }
        else{
          valid = false;
        }
      }
      if (facing == 'R') {
        if(2 <= x && x <= 20 && 2 <= y && y <= 12 ){
          valid = true;
        }
        else{
          valid = false;
        }
      }
      if (facing == 'L') {
        if(1 <= x && x <= 19 && 2 <= y && y <= 12){
          valid = true;
        }
        else{
          valid = false;
        }
      }
    }
    return (!overlap) && valid;
  }

  //Detedmine if the hit(dig) chosed by the player is valid
  public boolean validHit(int x, int y) {
    if (x >= 1 && x <= 20 && y >= 2 && y <= 20) {
      return true;
    } else {
      return false;
    }
  }
}
