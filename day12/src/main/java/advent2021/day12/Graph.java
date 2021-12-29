package advent2021.day12;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.factory.Maps;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.MutableMap;

public class Graph {

  private static final String START = "start";
  private static final String END = "end";
  
  private Cave mStart;
  private Cave mEnd;
  private MutableMap<String, Cave> mCaves = Maps.mutable.empty();
  
  public void addConnection(String pCaveA, String pCaveB) {
    Cave nodeA = mCaves.getIfAbsentPut(pCaveA, () -> new Cave(pCaveA));
    Cave nodeB = mCaves.getIfAbsentPut(pCaveB, () -> new Cave(pCaveB));
    
    nodeA.connect(nodeB);
    nodeB.connect(nodeA);
    
    if (pCaveA.equals(START)) {
      mStart = nodeA;
    }
    if (pCaveB.equals(START)) {
      mStart = nodeB;
    }
    if (pCaveA.equals(END)) {
      mEnd = nodeA;
    }
    if (pCaveB.equals(END)) {
      mEnd = nodeB;
    }
  }
  
  public Cave getStart() {
    return mStart;
  }
  
  public Cave getEnd() {
    return mEnd;
  }
  
  public int getSize() {
    return mCaves.size();
  }
  
  public class Cave {

    private String mName;
    private MutableList<Cave> mConnections = Lists.mutable.empty();
    
    public Cave(String pName) {
      mName = pName;
    }
    
    public boolean isSmall() {
      return StringUtils.isAllLowerCase(mName);
    }
    
    public ImmutableList<Cave> getConnections() {
      return mConnections.toImmutable();
    }
    
    public void connect(Cave pOther) {
      mConnections.add(pOther);
    }

    public String getName() {
      return mName;
    }
    
    @Override
    public String toString() {
      return mName;
    }
    
  }
}
