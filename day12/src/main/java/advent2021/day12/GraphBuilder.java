package advent2021.day12;

import org.eclipse.collections.api.RichIterable;

public class GraphBuilder {
  
  private RichIterable<Line> mLines;

  public GraphBuilder(RichIterable<Line> pLines) {
    mLines = pLines;
  }

  public Graph get() {
    Graph graph = new Graph();
    for (Line line : mLines) {
      graph.addConnection(line.getNodeA(), line.getNodeB());
    }
    return graph;
  }

}
