package advent2021.day12;

import static org.junit.Assert.assertEquals;

import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;
import org.junit.Test;

public class TestPathBuilder {

  private ImmutableList<Line> mLines;
  private Graph mGraph;
  private IPathBuilder mPathBuilder;

  @Test
  public void simpleForGraph1() {
    givenDataSet1();
    whenCreatingAGraph();
    givenAPathBuilder();
    thenTheGraphShouldHaveNPaths(10);
  }
  
  @Test
  public void advancedForGraph1() {
    givenDataSet1();
    whenCreatingAGraph();
    givenAnAdvancedPathBuilder();
    thenTheGraphShouldHaveNPaths(36);
  }
  
  @Test
  public void simpleForGraph2() {
    givenDataSet2();
    whenCreatingAGraph();
    givenAPathBuilder();
    thenTheGraphShouldHaveNPaths(19);
  }
  
  @Test
  public void advancedForGraph2() {
    givenDataSet2();
    whenCreatingAGraph();
    givenAnAdvancedPathBuilder();
    thenTheGraphShouldHaveNPaths(103);
  }
  
  @Test
  public void simpleForGraph3() {
    givenDataSet3();
    whenCreatingAGraph();
    givenAPathBuilder();
    thenTheGraphShouldHaveNPaths(226);
  }
  
  @Test
  public void advancedForGraph3() {
    givenDataSet3();
    whenCreatingAGraph();
    givenAnAdvancedPathBuilder();
    thenTheGraphShouldHaveNPaths(3509);
  }
  
  private void givenAPathBuilder() {
    mPathBuilder = new PathBuilder(mGraph);
    mPathBuilder.calculate();
  }
  
  private void givenAnAdvancedPathBuilder() {
    mPathBuilder = new AdvancedPathBuilder(mGraph);
    mPathBuilder.calculate();
  }

  private void thenTheGraphShouldHaveNPaths(int pExpected) {
    assertEquals(pExpected, mPathBuilder.getPaths().size());
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
  
  private void givenDataSet3() {
    MutableList<Line> lines = Lists.mutable.empty();
    lines.add(new Line("fs", "end"));
    lines.add(new Line("he", "DX"));
    lines.add(new Line("fs", "he"));
    lines.add(new Line("start", "DX"));
    lines.add(new Line("pj", "DX"));
    lines.add(new Line("end", "zg"));
    lines.add(new Line("zg", "sl"));
    lines.add(new Line("zg", "pj"));
    lines.add(new Line("pj", "he"));
    lines.add(new Line("RW", "he"));
    lines.add(new Line("fs", "DX"));
    lines.add(new Line("pj", "RW"));
    lines.add(new Line("zg", "RW"));
    lines.add(new Line("start", "pj"));
    lines.add(new Line("he", "WI"));
    lines.add(new Line("zg", "he"));
    lines.add(new Line("pj", "fs"));
    lines.add(new Line("start", "RW"));
    mLines = lines.toImmutable();
  }
}
