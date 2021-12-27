package advent2021.day10;

import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.MutableList;

public class Parser {

  private AbstractState mState;

  private IParseError mError;

  private long mTotalForIllegal;
  private MutableList<Long> mTotalForIncomplete = Lists.mutable.empty();
  
  private static final String OPEN_CURLY = "{";
  private static final String CLOSE_CURLY = "}";
  private static final String OPEN_SQUARE = "[";
  private static final String CLOSE_SQUARE = "]";
  private static final String OPEN_ARROW = "<";
  private static final String CLOSE_ARROW = ">";
  private static final String OPEN_REGULAR = "(";
  private static final String CLOSE_REGULAR = ")";
  
  public Parser() {
    super();
    mTotalForIllegal = 0;
    mTotalForIncomplete.clear();
  }

  public void parse(String pLine) {
    mError = null;
    mState = new VoidState();
    try {
      for (int i = 0; i < pLine.length(); i++) {
        mState.parse(pLine.substring(i, i+1));
      }
      if (!(mState instanceof VoidState)) {
        String missing = collectMissing(mState);
        throw new IncompleteError(missing);
      }
    }
    catch (IParseError e) {
      mError = e;
      if (mError instanceof InvalidError) {
        mTotalForIllegal = mTotalForIllegal + mError.getPoints();
      }
      else {
        mTotalForIncomplete.add(mError.getPoints());
      }
    }
  }

  private String collectMissing(AbstractState pState) {
    AbstractState state = pState;
    String result = state.getCloseChar();
    while (state.mPreviousState != null) {
      state = state.mPreviousState;
      result = result + state.getCloseChar();
    }
    return result;
  }

  private void setState(AbstractState pState) {
    mState = pState;
  }
  
  public IParseError getError() {
    return mError;
  }
  
  public long getTotalForIllegal() {
    return mTotalForIllegal;
  }
  
  public long getTotalForIncomplete() {
    MutableList<Long> scores = mTotalForIncomplete.sortThis();
    int index = scores.size() / 2;
    return mTotalForIncomplete.get(index);
  }
  
  private abstract class AbstractState {
    
    protected AbstractState mPreviousState;
    
    public AbstractState(AbstractState pPrevious) {
      mPreviousState = pPrevious;
    }

    protected abstract String getCloseChar();

    abstract void parse(String pChar);

    public boolean handleOpen(String pChar) {
      if (pChar.equals(OPEN_CURLY)) {
        setState(new CurlyState(this));
      }
      else if (pChar.equals(OPEN_ARROW)) {
        setState(new ArrowState(this));
      }
      else if (pChar.equals(OPEN_REGULAR)) {
        setState(new RegularState(this));
      }
      else if (pChar.equals(OPEN_SQUARE)) {
        setState(new SquareState(this));
      }
      else {
        return false;
      }
      return true;
    }
  }
  
  private class VoidState extends AbstractState {

    public VoidState() {
      super(null);
    }

    @Override
    protected String getCloseChar() {
      return "";
    }
    
    @Override
    public void parse(String pChar) {
      if (!handleOpen(pChar)) {
        throw new IllegalStateException();
      }
    }
  }
  
  private class CurlyState extends AbstractState {

    public CurlyState(AbstractState pPrevious) {
      super(pPrevious);
    }

    @Override
    protected String getCloseChar() {
      return CLOSE_CURLY;
    }
    
    @Override
    public void parse(String pChar) {
      if (!handleOpen(pChar)) {
        if (pChar.equals(CLOSE_CURLY)) {
          setState(mPreviousState);
        }      
        else {
          throw new InvalidError(CLOSE_CURLY, pChar);
        }
      }
    }
  }
  
  private class ArrowState extends AbstractState {

    public ArrowState(AbstractState pPrevious) {
      super(pPrevious);
    }

    @Override
    protected String getCloseChar() {
      return CLOSE_ARROW;
    }
    
    @Override
    public void parse(String pChar) {
      if (!handleOpen(pChar)) {
        if (pChar.equals(CLOSE_ARROW)) {
          setState(mPreviousState);
        }      
        else {
          throw new InvalidError(CLOSE_ARROW, pChar);
        }
      }
    }
  }
  
  private class SquareState extends AbstractState {

    public SquareState(AbstractState pPrevious) {
      super(pPrevious);
    }

    @Override
    protected String getCloseChar() {
      return CLOSE_SQUARE;
    }
    
    @Override
    public void parse(String pChar) {
      if (!handleOpen(pChar)) {
        if (pChar.equals(CLOSE_SQUARE)) {
          setState(mPreviousState);
        }      
        else {
          throw new InvalidError(CLOSE_SQUARE, pChar);
        }
      }
    }
  }
  
  private class RegularState extends AbstractState {

    public RegularState(AbstractState pPrevious) {
      super(pPrevious);
    }
    
    @Override
    protected String getCloseChar() {
      return CLOSE_REGULAR;
    }

    @Override
    public void parse(String pChar) {
      if (!handleOpen(pChar)) {
        if (pChar.equals(CLOSE_REGULAR)) {
          setState(mPreviousState);
        }      
        else {
          throw new InvalidError(CLOSE_REGULAR, pChar);
        }
      }
    }
  }

  
  public abstract static class IParseError extends RuntimeException {
    private static final long serialVersionUID = -309565418982996690L;
    
    public abstract long getPoints();
  }
   
  
  public static class InvalidError extends IParseError {
    private static final long serialVersionUID = 2464101863177293928L;
    
    private final String mExpected;
    private final String mActual;

    public InvalidError(String pExpected, String pActual) {
      mExpected = pExpected;
      mActual = pActual;
    }
    
    public long getPoints() {
      if (CLOSE_REGULAR.equals(mActual)) {
        return 3;
      }
      if (CLOSE_SQUARE.equals(mActual)) {
        return 57;
      }
      if (CLOSE_CURLY.equals(mActual)) {
        return 1197;
      }
      if (CLOSE_ARROW.equals(mActual)) {
        return 25137;
      }
      throw new IllegalArgumentException();
    }
    
    public String getActual() {
      return mActual;
    }
    
    @Override
    public String getMessage() {
      return "Expected " + mExpected + ", but found " + mActual;
    }
  }
  
  public static class IncompleteError extends IParseError {
    private static final long serialVersionUID = -545415136785513994L;

    private final String mExpected;

    public IncompleteError(String pExpected) {
      mExpected = pExpected;
    }
    
    public long getPoints() {
      long result = 0;
      for (int i = 0; i < mExpected.length(); i++) {
        String c = mExpected.substring(i, i+1);
        result = result * 5;
        if (CLOSE_REGULAR.equals(c)) {
          result = result + 1;
        }
        else if (CLOSE_SQUARE.equals(c)) {
          result = result + 2;
        }
        else if (CLOSE_CURLY.equals(c)) {
          result = result + 3;
        }
        else if (CLOSE_ARROW.equals(c)) {
          result = result + 4;
        }
      }
      return result;
    }
    
    public String getExpected() {
      return mExpected;
    }
    
    @Override
    public String getMessage() {
      return "Expected " + mExpected;
    }
  }

  
}
