package advent2021.day3b;

import java.io.File;
import java.io.FileNotFoundException;

import advent2021.day3b.Calculator.Totals;

/**
 * Hello world!
 *
 */
public class App3b {
  public static void main(String[] args) throws FileNotFoundException {
    File file = new File("data/input.txt");
    String absolutePath = file.getAbsolutePath();

    Reader reader = new Reader();
    reader.read(absolutePath);
    
    Calculator calculator = new Calculator(reader.getItems());
    Totals totals = calculator.calculate();
    System.out.println(totals.getLifeSupportRating());
  }
}
