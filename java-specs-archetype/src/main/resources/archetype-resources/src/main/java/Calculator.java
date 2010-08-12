package ${package};

import java.util.*;

public class Calculator {
  private LinkedList<String> history = new LinkedList<String>();
  public Calculator() {}

  public Integer add(Integer left, Integer right) {
    history.addFirst(left + " + " + right);
    if (left == null || right == null)
      throw new IllegalArgumentException("Neither the left or the right operand may be null.");
    return left + right;
  }

  public List<String> history() {
    return Collections.unmodifiableList(history);
  }
}
