package advent2021.day11;

import java.io.File;
import java.io.FileNotFoundException;

public class App11b {
  public static void main(String[] args) throws FileNotFoundException {
    File file = new File("data/input.txt");
    String absolutePath = file.getAbsolutePath();

    Reader reader = new Reader();
    reader.read(absolutePath);
    
    Simulator sim = new Simulator(reader.getLines());
    while (!sim.allLevel0()) {
      sim.step();
    }
    System.out.println(sim.getSteps());
  }
}
