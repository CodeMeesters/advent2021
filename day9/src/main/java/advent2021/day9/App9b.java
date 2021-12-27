package advent2021.day9;

import java.io.File;
import java.io.FileNotFoundException;

public class App9b {
  public static void main(String[] args) throws FileNotFoundException {
    File file = new File("data/input.txt");
    String absolutePath = file.getAbsolutePath();

    Reader reader = new Reader();
    reader.read(absolutePath);
    
    BasinCalculator calculator = new BasinCalculator(reader.getLines());
    calculator.calculate();
    System.out.println(calculator.getBasinProduct());
  }
}
