package advent2021.day5;

import java.io.File;
import java.io.FileNotFoundException;

public class App5 {
  public static void main(String[] args) throws FileNotFoundException {
    File file = new File("data/input.txt");
    String absolutePath = file.getAbsolutePath();

    Reader reader = new Reader();
    reader.read(absolutePath);
    
    Extractor extractor = new Extractor(reader.getLines());
    Calculator calculator = new Calculator(extractor.get(), reader.getSize());
    calculator.calculateGrid();
    System.out.println(calculator.getNumberOfOverlaps());
  }
}
