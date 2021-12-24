package advent2021.day5b;

import java.io.File;
import java.io.FileNotFoundException;

public class App5b {
  public static void main(String[] args) throws FileNotFoundException {
    File file = new File("data/input.txt");
    String absolutePath = file.getAbsolutePath();

    Reader reader = new Reader();
    reader.read(absolutePath);
    
    Calculator calculator = new Calculator(reader.getLines(), reader.getSize());
    calculator.calculateGrid();
    System.out.println(calculator.getNumberOfOverlaps());
  }
}
