package advent2021.day2b;

import java.io.File;
import java.io.FileNotFoundException;

import advent2021.day2b.MovementCalculator.TotalMovement;

public class AppDay2b {
  public static void main(String[] args) throws FileNotFoundException {
    File file = new File("data/input.txt");
    String absolutePath = file.getAbsolutePath();

    Reader reader = new Reader();
    reader.read(absolutePath);
    
    MovementCalculator calculator = new MovementCalculator(reader.getItems());
    TotalMovement totalMovement = calculator.calculate();
    System.out.println(totalMovement.product);
  }
}
