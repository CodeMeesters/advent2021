package advent2021.day5;

import org.eclipse.collections.api.list.ImmutableList;

public class Extractor {

  private ImmutableList<Line> mLines;

  public Extractor(ImmutableList<Line> pLines) {
    mLines = pLines;
  }

  public ImmutableList<Line> get() {
    return mLines.select(line -> line.isHorizontal() || line.isVertical());
  }

}
