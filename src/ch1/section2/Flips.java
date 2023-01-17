package ch1.section2;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;

class Flips {

  public static void main(String[] args) {
    StdOut.print("Number of coin tosses? ");
    int T = StdIn.readInt();

    Counter h = new Counter("Heads");
    Counter t = new Counter("Tails");

    for (int i = 0; i < T; ++i) {
      if (StdRandom.bernoulli(0.5)) {
        h.increment();
      } else {
        t.increment();
      }
    }
    StdOut.println(h);
    StdOut.println(t);
    StdOut.println("Delta: " + Math.abs(h.tally() - t.tally()));
  }
}