// Binomial distribution. Estimate the number of recursive calls that would be
// used by the function binomialSlow.
// Develop a better implementation (binomialFast) that is based on saving computed values in an array.

package ch1.section1;

import java.util.HashMap;
import java.util.Objects;

public class Ex27_Binomial {

  /* T(n, k) = T(n-1, k) + T(n-1, k-1)
  This is same as identity for binomial coefficient nCk. Number of recursive calls = C(100, 50),
  which is too much for a computer.
   */
  public static double binomialSlow(int n, int k, double p) {
    if ((n == 0) || (k < 0)) {
      return 1.0;
    }
    return (1.0 - p) * binomialSlow(n - 1, k, p) + p * binomialSlow(n - 1, k - 1, p);
  }

  public static double binomialFast(int n, int k, double p) {
    return binomialFastHelper(n, k, p, new HashMap<>());
  }

  public static double binomialFastHelper(int n, int k, double p,
      HashMap<BinomialCoeff, Double> coeffMap) {
    if ((n == 0) || (k < 0)) {
      return 1.0;
    }
    BinomialCoeff coeff = new BinomialCoeff(n, k);
    if (coeffMap.containsKey(coeff)) {
      return coeffMap.get(coeff);
    }
    double dist =
        (1.0 - p) * binomialFastHelper(n - 1, k, p, coeffMap) + p * binomialFastHelper(n - 1, k - 1,
            p, coeffMap);
    coeffMap.put(coeff, dist);
    return dist;
  }

  public static void main(String[] args) {
    System.out.println(binomialFast(100, 50, 0.05));
    System.out.println(binomialSlow(10, 5, 0.05));
  }

  static class BinomialCoeff {

    private final int n;
    private final int k;

    public BinomialCoeff(int n, int k) {
      this.n = n;
      this.k = k;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof BinomialCoeff)) {
        return false;
      }
      BinomialCoeff that = (BinomialCoeff) o;
      return n == that.n && k == that.k;
    }

    @Override
    public int hashCode() {
      return Objects.hash(n, k);
    }
  }

}
