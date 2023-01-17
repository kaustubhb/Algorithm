// Modify DoublingTest to use StdDraw to produce plots like the standard and
// log-log plots in the text, rescaling as necessary so that the plot always fills a substantial
// portion of the window.

// Log-log plot

package ch1.section4;

import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ex3_DoublingTestDrawLogarithmic {

  public static void main(String[] args) {
    StdRandom.setSeed(0);
    Ex3_DoublingTestDrawLogarithmic driver = new Ex3_DoublingTestDrawLogarithmic();
    List<InputTime> data = driver.generateLogarithmicPlotData();
    driver.plotGraph(data);
  }

  private List<InputTime> generatePlotData() {
    List<InputTime> data = new ArrayList<>();
    for (int n = 250; n <= 30000; n *= 1.5) {
      int[] arr = new int[n];
      for (int i = 0; i < n; ++i) {
        arr[i] = StdRandom.uniform(-n * 10, n * 10);
      }
      Stopwatch timer = new Stopwatch();
      ThreeSumFast.countTriples(arr);
      InputTime it = new InputTime(n, timer.elpasedTimeMillis());
      System.out.println(it);
      data.add(it);
    }
    return data;
  }

  private List<InputTime> generateLogarithmicPlotData() {
    List<InputTime> data = generatePlotData();
    return data.stream().map(it ->
        new InputTime(Math.log(it.x), Math.log(it.y))
    ).collect(Collectors.toList());
  }

  private void plotGraph(List<InputTime> data) {
    long xMax = Math.round(data.get(data.size() - 1).x * 1.3);
    long yMax = Math.round(data.get(data.size() - 1).y * 1.3);
    double margin = 0;

    // StdDraw.setCanvasSize(500,500);
    StdDraw.setXscale(0, xMax);
    StdDraw.setYscale(0, yMax);

    InputTime prev = null;
    for (var d : data) {
      StdDraw.setPenRadius(0.01);
      StdDraw.point(margin + d.x, margin + d.y);
      if (prev != null) {
        StdDraw.setPenRadius(0.005);
        StdDraw.line(prev.x + margin, prev.y + margin, d.x + margin, d.y + margin);
      }
      prev = d;
    }
  }

  private static class InputTime {

    double x;
    double y;

    public InputTime(double x, double y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public String toString() {
      return "InputTime{" +
          "x=" + x +
          ", y=" + y +
          '}';
    }
  }
}
