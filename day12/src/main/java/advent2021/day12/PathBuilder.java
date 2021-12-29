package advent2021.day12;

import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;

import advent2021.day12.Graph.Cave;

public class PathBuilder implements IPathBuilder {

  private Graph mGraph;
  private MutableList<ImmutableList<Cave>> mPaths = Lists.mutable.empty();

  public PathBuilder(Graph pGraph) {
    mGraph = pGraph;
  }

  public void calculate() {
    mPaths.clear(); 
    walk(mGraph.getStart(), Lists.mutable.empty());
  }

  private void walk(Cave pCave, MutableList<Cave> pCurrentPath) {
    pCurrentPath.add(pCave);
    if (pCave == mGraph.getEnd()) {
      mPaths.add(Lists.immutable.withAll(pCurrentPath));
      return;
    }
    for (Cave connection : pCave.getConnections()) {
      // check if not visited already
      boolean visited = (connection.isSmall() && pCurrentPath.contains(connection));
      if (!visited) {
        walk (connection, Lists.mutable.withAll(pCurrentPath));
      }
    }
  }

  public ImmutableList<ImmutableList<Cave>> getPaths() {
    return mPaths.toImmutable();
  }

}
