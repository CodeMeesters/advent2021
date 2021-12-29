package advent2021.day12;

import org.eclipse.collections.api.list.ImmutableList;

import advent2021.day12.Graph.Cave;

public interface IPathBuilder {

  void calculate();
  ImmutableList<ImmutableList<Cave>> getPaths();

}
