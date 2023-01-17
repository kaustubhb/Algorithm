//  Dice simulation. The value dist[i] is the probability that the sum of 2 dice throws is i.
//  Run experiments to validate this calculation simulating N dice throws, keeping track
//  of the frequencies of occurrence of each value when you compute the sum of two
//  random integers between 1 and 6. How large does N have to be before your empirical
//  results match the exact results to three decimal places?

package ch1.section1;

import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;

public class Ex35_DiceSimulation {

  public static void main(String[] args) {
    Ex35_DiceSimulation simulator = new Ex35_DiceSimulation();
    int numSimulations = 10;
    final int SIDES = 6;
    double[] dist = simulator.distribution(SIDES);
    while (true) {
      if (simulator.compareDistributions(dist, 6, numSimulations, 0.01)) {
        StdOut.println(
            "Results matched for the first time with " + numSimulations + " simulations");
        break;
      }
      numSimulations += 100;
    }
  }

  // Returns an array which contains mathematically calculated probability distributions for
  // sum of numbers when 2 dice are thrown
  // dist[i] equals probability that the sum of numbers on 2 dice is i in any throw.
  private double[] distribution(int sides) {
    double[] dist = new double[2 * sides + 1];
    for (int i = 1; i <= sides; ++i) {
      for (int j = 1; j <= sides; ++j) {
        ++dist[i + j];
      }
    }
    for (int i = 2; i <= 2 * sides; ++i) {
      dist[i] /= sides * sides;
    }
    return dist;
  }

  // Returns an array which contains empirically calculated probability distributions for
  // sum of numbers when 2 dice are thrown
  private double[] simulatedDistribution(int sides, int n) {
    StdRandom.setSeed(42);
    double[] dist = new double[2 * sides + 1];
    for (int i = 0; i < n; ++i) {
      int val = StdRandom.uniform(sides) + StdRandom.uniform(sides) + 2;
      ++dist[val];
    }

    for (int i = 2; i <= 2 * sides; ++i) {
      dist[i] /= n;
    }
    return dist;
  }

  private boolean compareDistributions(double[] dist, int sides, int numSimulations,
      double tolerance) {
    double[] simDist = simulatedDistribution(sides, numSimulations);
    for (int i = 0; i < simDist.length; ++i) {
      if (Math.abs(simDist[i] - dist[i]) > tolerance) {
        return false;
      }
    }
    return true;
  }

}
