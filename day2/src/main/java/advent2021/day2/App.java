package advent2021.day2;

import java.io.File;
import java.io.FileNotFoundException;

import advent2021.day2.MovementCalculator;
import advent2021.day2.MovementCalculator.TotalMovement;
import advent2021.day2.Reader;

public class App {
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
