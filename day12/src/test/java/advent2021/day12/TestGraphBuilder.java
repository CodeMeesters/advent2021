package advent2021.day12;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;
import org.junit.Test;

public class TestGraphBuilder {

  private ImmutableList<Line> mLines;
  private Graph mGraph;

  @Test
  public void createGraph1() {
    givenDataSet1();
    whenCreatingAGraph();
    thenTheGraphShouldHaveAStart();
    thenTheGraphShouldHaveAnEnd();
    thenTheGraphShouldHaveNCaves(6);
  }
  
  @Test
  public void createGraph2() {
    givenDataSet2();
    whenCreatingAGraph();
    thenTheGraphShouldHaveAStart();
    thenTheGraphShouldHaveAnEnd();
  }
  
  private void thenTheGraphShouldHaveNCaves(int pExpected) {
    assertEquals(pExpected, mGraph.getSize());
  }


  private void thenTheGraphShouldHaveAnEnd() {
    assertNotNull(mGraph.getEnd());
  }

  private void thenTheGraphShouldHaveAStart() {
    assertNotNull(mGraph.getStart());
  }

  private void whenCreatingAGraph() {
    GraphBuilder builder = new GraphBuilder(mLines);
    mGraph = builder.get();
  }

  private void givenDataSet1() {
    MutableList<Line> lines = Lists.mutable.empty();
    lines.add(new Line("start", "A"));
    lines.add(new Line("start", "b"));
    lines.add(new Line("A", "c"));
    lines.add(new Line("A", "b"));
    lines.add(new Line("b", "d"));
    lines.add(new Line("A", "end"));
    lines.add(new Line("b", "end"));
    mLines = lines.toImmutable();
  }
  
  private void givenDataSet2() {
    MutableList<Line> lines = Lists.mutable.empty();
    lines.add(new Line("dc", "end"));
    lines.add(new Line("HN", "start"));
    lines.add(new Line("start", "kj"));
    lines.add(new Line("dc", "start"));
    lines.add(new Line("dc", "HN"));
    lines.add(new Line("LN", "dc"));
    lines.add(new Line("HN", "end"));
    lines.add(new Line("kj", "sa"));
    lines.add(new Line("kj", "HN"));
    lines.add(new Line("kj", "dc"));
    mLines = lines.toImmutable();
  }
}
