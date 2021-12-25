package advent2021.day7b;

import java.io.File;
import java.io.FileNotFoundException;

public class App7b {
  public static void main(String[] args) throws FileNotFoundException {
    File file = new File("data/input.txt");
    String absolutePath = file.getAbsolutePath();

    Reader reader = new Reader();
    reader.read(absolutePath);
    
    Calculator calculator = new Calculator(reader.getCohorts());
    Optimizer optimizer = new Optimizer(reader.getMin(), reader.getMax(), calculator);
    int position = optimizer.findMinimum();
    System.out.println(calculator.calculateFuelCosts(position));
  }
}
