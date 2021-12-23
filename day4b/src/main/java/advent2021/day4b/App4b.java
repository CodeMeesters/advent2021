package advent2021.day4b;

import java.io.File;
import java.io.FileNotFoundException;

public class App4b {
  
  public static void main(String[] args) throws FileNotFoundException {
    File file = new File("data/input.txt");
    String absolutePath = file.getAbsolutePath();

    Reader reader = new Reader();
    reader.read(absolutePath);
    
    BingoMaster master = new BingoMaster(reader.getBoards(), reader.getDraws());
    master.draw();

  }
}
