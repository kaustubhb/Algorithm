package ch1.section2;

public class Counter {

  private final String fName;
  private int fCount;

  public Counter(String name) {
    fName = name;
    fCount = 0;
  }

  public void increment() {
    ++fCount;
  }

  public int tally() {
    return fCount;
  }

  public String toString() {
    return fCount + " " + fName + "s";
  }
}
