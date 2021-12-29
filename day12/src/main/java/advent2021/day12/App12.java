package advent2021.day12;

import java.io.File;
import java.io.FileNotFoundException;

public class App12 {
  public static void main(String[] args) throws FileNotFoundException {
    File file = new File("data/input.txt");
    String absolutePath = file.getAbsolutePath();

    Reader reader = new Reader();
    reader.read(absolutePath);
    
    GraphBuilder builder = new GraphBuilder(reader.getLines());
    Graph graph = builder.get();
    PathBuilder pathBuilder = new PathBuilder(graph);
    pathBuilder.calculate();
    System.out.println(pathBuilder.getPaths().size());
  }
}
