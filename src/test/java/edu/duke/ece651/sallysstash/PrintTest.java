package edu.duke.ece651.sallysstash;

import java.io.FileInputStream;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public class PrintTest {
  @Test
  public void test_() {
    try{

      
    FileInputStream fis0 = new FileInputStream("computer_computer.txt");
    System.setIn(fis0);
    print.main(null);

    FileInputStream fis1= new FileInputStream("human_human1.txt");
    System.setIn(fis1);
    print.main(null);

    FileInputStream fis2= new FileInputStream("human_human2.txt");
    System.setIn(fis2);
    print.main(null);

    } catch (IOException e) {
    e.printStackTrace();
    }
    
    }

}
