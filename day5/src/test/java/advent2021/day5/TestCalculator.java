package advent2021.day5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Point;

import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;
import org.junit.Test;

public class TestCalculator {

  private ImmutableList<Line> mLines;
  private PointGenerator mPointGenerator;
  private Calculator mCalculator;

  @Test
  public void extractor() {
    givenADataSet();
    thenTheExtractorShouldFilter();
  }

  @Test
  public void pointGenerator() {
    givenADataSet();
    whenRequestingPointsForLine(0);
    thenTheFollowingShouldBeGenerated(point(0,9), point(1,9), point(2,9), point(3,9), point(4,9), point(5,9));
    whenRequestingPointsForLine(2);
    thenTheFollowingShouldBeGenerated(point(3,4), point(4,4), point(5,4), point(6,4), point(7,4), point(8,4), point(9,4));
    whenRequestingPointsForLine(4);
    thenTheFollowingShouldBeGenerated(point(7,0), point(7,1), point(7,2), point(7,3), point(7,4));
  }
  
  @Test
  public void calculator() {
    givenADataSet();
    afterFiltering();
    whenCalculatingTheGrid();
    thenTheNumberOfOverlappingPointsShouldBe(5);
  }
  
  private void afterFiltering() {
    Extractor extractor = new Extractor(mLines);
    mLines = extractor.get();
  }

  private void thenTheNumberOfOverlappingPointsShouldBe(int pExpected) {
    assertEquals("Overlapping wrong!!", pExpected, mCalculator.getNumberOfOverlaps());
  }

  private void whenCalculatingTheGrid() {
    mCalculator = new Calculator(mLines, 10);
    mCalculator.calculateGrid();
  }

  private void thenTheFollowingShouldBeGenerated(Point...pPoints) {
    int i = 0;
    while (mPointGenerator.hasNext()) {
      Point actual = mPointGenerator.getNext();
      assertEquals("Invalid point", pPoints[i], actual);
      i++;
    }
    assertEquals("Invalid number", pPoints.length, i);
  }

  private Point point(int pX, int pY) {
    return new Point(pX, pY);
  }

  private void whenRequestingPointsForLine(int pIndex) {
    Line line = mLines.get(pIndex);
    mPointGenerator = new PointGenerator(line);
  }

  private void thenTheExtractorShouldFilter() {
    Extractor extractor = new Extractor(mLines);
    ImmutableList<Line> lines = extractor.get();
    assertTrue("Invalid extraction", lines.size() < mLines.size());
  }

  private void givenADataSet() {
    MutableList<Line> lines = Lists.mutable.empty();
    lines.add(new Line(0, 9, 5, 9));
    lines.add(new Line(8, 0, 0, 8));
    lines.add(new Line(9, 4, 3, 4));
    lines.add(new Line(2, 2, 2, 1));
    lines.add(new Line(7, 0, 7, 4));
    lines.add(new Line(6, 4, 2, 0));
    lines.add(new Line(0, 9, 2, 9));
    lines.add(new Line(3, 4, 1, 4));
    lines.add(new Line(0, 0, 8, 8));
    lines.add(new Line(5, 5, 8, 2));
    mLines = lines.toImmutable();
  }
  
}
