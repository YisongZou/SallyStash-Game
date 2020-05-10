package edu.duke.ece651.sallysstash;

//Generating random options for the computer
public class computer {
  //Generate the random x coordinate
  public static String generateX() {
    char cha[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T' };
    int index = (int) (Math.random() * (cha.length));
    char temp = cha[index];
    String ans = Character.toString(temp);
    return ans;
  }
//Generate the random y coordinate
  public static String generateY() {
    char cha[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    int index = (int) (Math.random() * (cha.length));
    char temp = cha[index];
    String ans = Character.toString(temp);
    return ans;
  }
//Generate the random normal stack orientation
  public static String generateNormal() {
    char cha[] = { 'V', 'H' };
    int index = (int) (Math.random() * (cha.length));
    char temp = cha[index];
    String ans = Character.toString(temp);
    return ans;
  }

  //Generate the random  special stack orientation
  public static String generateStrange() {
    char cha[] = { 'U', 'D', 'L', 'R' };
    int index = (int) (Math.random() * (cha.length));
    char temp = cha[index];
    String ans = Character.toString(temp);
    return ans;
  }
  //Generate move options randomly
  public static String generateOption() {
    char cha[] = { 'D', 'M', 'S'};
    int index = (int) (Math.random() * (cha.length));
    char temp = cha[index];
    String ans = Character.toString(temp);
    return ans;
  }
}
