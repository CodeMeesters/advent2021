package advent2021.day5;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;

public class Reader {

  private MutableList<Line> mLines = Lists.mutable.empty();
   
  public Reader() {
    super();
  }

  public ImmutableList<Line> getLines() {
    return mLines.toImmutable();
  }

  public int getSize() {
    int maxX = mLines.collectInt(line -> Math.max(line.getX1(), line.getX2())).max();
    int maxY = mLines.collectInt(line -> Math.max(line.getY1(), line.getY2())).max();
    int max = Math.max(maxX, maxY);
    return max + 1; 
  }
  
  public void read(String pFile) throws FileNotFoundException {
    Scanner s = new Scanner(new BufferedReader(new FileReader(pFile)));
    try {
      while (s.hasNextLine()) {
        mLines.add(parseLine(s.nextLine()));
      }
    }
    finally {
      s.close();
    }
  }
  
  private Line parseLine(String pLine) {
    String[] points = pLine.split(" -> ");
    String[] start = points[0].split(",");
    String[] end = points[1].split(",");
    Point startPoint = new Point(Integer.parseInt(start[0]), Integer.parseInt(start[1]));
    Point endPoint = new Point(Integer.parseInt(end[0]), Integer.parseInt(end[1]));
    return new Line(startPoint, endPoint);
  }

}
