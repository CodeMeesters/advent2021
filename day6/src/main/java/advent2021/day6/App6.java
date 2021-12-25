package advent2021.day6;

import java.io.File;
import java.io.FileNotFoundException;

public class App6 {
  public static void main(String[] args) throws FileNotFoundException {
    File file = new File("data/input.txt");
    String absolutePath = file.getAbsolutePath();

    Reader reader = new Reader();
    reader.read(absolutePath);
    Sea sea = new Sea(reader.getCohorts());
    sea.gotoDay(256);
    System.out.println(sea.getNumberOfFish());
  }
}
