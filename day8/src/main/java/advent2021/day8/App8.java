package advent2021.day8;

import java.io.File;
import java.io.FileNotFoundException;

public class App8 {
  public static void main(String[] args) throws FileNotFoundException {
    File file = new File("data/input.txt");
    String absolutePath = file.getAbsolutePath();

    Reader reader = new Reader();
    reader.read(absolutePath);
    
    Calculator calculator = new Calculator(reader.getLines());
    System.out.println(calculator.countNumberOf147());
  }
}
