package advent2021.day12;

import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;

import advent2021.day12.Graph.Cave;

public class AdvancedPathBuilder implements IPathBuilder {

  private Graph mGraph;
  private MutableList<ImmutableList<Cave>> mPaths = Lists.mutable.empty();

  public AdvancedPathBuilder(Graph pGraph) {
    mGraph = pGraph;
  }

  public void calculate() {
    mPaths.clear(); 
    walk(mGraph.getStart(), false, Lists.mutable.empty());
  }

  private void walk(Cave pCave, boolean pSmallCaveVisited, MutableList<Cave> pCurrentPath) {
    pCurrentPath.add(pCave);
    if (pCave == mGraph.getEnd()) {
      mPaths.add(Lists.immutable.withAll(pCurrentPath));
      return;
    }
    for (Cave connection : pCave.getConnections()) {
      // check if not visited already
      boolean visited = pCurrentPath.contains(connection);
      boolean isStart = (connection == mGraph.getStart());
      if (!isStart) {
        if (connection.isSmall() && visited && !pSmallCaveVisited) {
          walk (connection, true, Lists.mutable.withAll(pCurrentPath));
        }
        else if (connection.isSmall() && !visited) {
          walk (connection, pSmallCaveVisited, Lists.mutable.withAll(pCurrentPath));
        }  
        else if (!connection.isSmall()) {
          walk (connection, pSmallCaveVisited, Lists.mutable.withAll(pCurrentPath));
        }
        else {
          // skip
        }
      }
    }
  }

  public ImmutableList<ImmutableList<Cave>> getPaths() {
    return mPaths.toImmutable();
  }

}
