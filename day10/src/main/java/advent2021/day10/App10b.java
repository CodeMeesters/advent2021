package advent2021.day10;

import java.io.File;
import java.io.FileNotFoundException;

public class App10b {
  public static void main(String[] args) throws FileNotFoundException {
    File file = new File("data/input.txt");
    String absolutePath = file.getAbsolutePath();

    Reader reader = new Reader();
    reader.read(absolutePath);
    
    Parser parser = new Parser();
    reader.getLines().forEach(l -> parser.parse(l));
    System.out.println(parser.getTotalForIncomplete());
  }
}
