package advent2021.day1b;

import java.io.File;
import java.io.FileNotFoundException;

public class AppDay1b {
  public static void main(String[] args) throws FileNotFoundException {
    File file = new File("data/input.txt");
    String absolutePath = file.getAbsolutePath();

    Reader reader = new Reader();
    reader.read(absolutePath);

    IncreaseCounter counter = new IncreaseCounter(reader.getItems());
    System.out.println(counter.count());
  }
}
