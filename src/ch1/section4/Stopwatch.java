package ch1.section4;

public class Stopwatch {

  private final long start;

  public Stopwatch() {
    start = System.currentTimeMillis();
  }

  public double elapsedTimeSec() {
    return (System.currentTimeMillis() - start) / 1000.0;
  }

  public long elpasedTimeMillis() {
    return System.currentTimeMillis() - start;
  }

}
